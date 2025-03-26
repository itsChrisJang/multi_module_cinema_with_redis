package project.redis.movie.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import project.redis.domain.movie.Genre;
import project.redis.movie.dto.CurrentPlayingMovieProjection;
import project.redis.movie.dto.FlatMovieScheduleRow;
import project.redis.movie.dto.ScheduleProjection;
import project.redis.movie.entity.QMovieEntity;
import project.redis.schedule.entity.QScheduleEntity;
import project.redis.screen.entity.QScreenEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieQueryRepository {

    private final JPAQueryFactory queryFactory;

    public MovieQueryRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Cacheable(value = "current_playing_movie", key =  "#title + '_' + #genre")
    public List<CurrentPlayingMovieProjection> findCurrentPlayingMoviesWithSchedules(
            String title,
            Genre genre
    ) {
        QMovieEntity movie = QMovieEntity.movieEntity;
        QScheduleEntity schedule = QScheduleEntity.scheduleEntity;
        QScreenEntity screen = QScreenEntity.screenEntity;

        List<FlatMovieScheduleRow> rows = queryFactory
                .select(Projections.constructor(
                        FlatMovieScheduleRow.class,
                        movie.id,
                        movie.title,
                        movie.genre,
                        movie.releaseDate,
                        movie.filmRating,
                        movie.thumbnailUrl,
                        movie.runningTime,
                        schedule.startTime,
                        schedule.endTime,
                        screen.name
                ))
                .from(movie)
                .join(movie.schedules, schedule)
                .join(schedule.screen, screen)
                .where(
                        movie.releaseDate.loe(LocalDate.now()),
                        schedule.startTime.goe(LocalDateTime.now()),
                        schedule.endTime.goe(LocalDateTime.now()),
                        title != null && !title.isBlank() ? movie.title.contains(title) : null,
                        genre != null ? movie.genre.eq(genre) : null
                )
                .fetch();

        // 수동 그룹핑 (Java stream으로)
        return rows.stream()
                .collect(Collectors.groupingBy(FlatMovieScheduleRow::movieId))
                .values()
                .stream()
                .map(group -> {
                    FlatMovieScheduleRow first = group.get(0);
                    List<ScheduleProjection> schedules = group.stream()
                            .map(row -> new ScheduleProjection(
                                    row.startTime(),
                                    row.endTime(),
                                    row.screenName()
                            ))
                            .toList();

                    return new CurrentPlayingMovieProjection(
                            first.movieId(),
                            first.title(),
                            first.genre(),
                            first.releaseDate(),
                            first.rating(),
                            first.thumbnailUrl(),
                            first.runningTime(),
                            schedules
                    );
                })
                .toList();
    }


}
