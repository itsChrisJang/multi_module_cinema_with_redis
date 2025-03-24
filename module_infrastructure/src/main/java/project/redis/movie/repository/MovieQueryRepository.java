package project.redis.movie.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import project.redis.domain.movie.MovieGenre;
import project.redis.movie.entity.MovieEntity;
import project.redis.movie.entity.QMovieEntity;
import project.redis.schedule.entity.QScheduleEntity;
import project.redis.screen.entity.QScreenEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class MovieQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<MovieEntity> findNowPlayingMoviesWithSchedules(LocalDate today, LocalDateTime now, String title, String genre) {
        QMovieEntity movie = QMovieEntity.movieEntity;
        QScheduleEntity schedule = QScheduleEntity.scheduleEntity;
        QScreenEntity screen = QScreenEntity.screenEntity;

        return queryFactory
                .selectDistinct(movie)
                .from(movie)
                .join(movie.schedules, schedule).fetchJoin()
                .join(schedule.screen, screen).fetchJoin()
                .where(
                        movie.releaseDate.loe(today),
                        schedule.startTime.goe(now),
                        schedule.endTime.goe(now),
                        title != null && !title.isBlank() ? movie.title.contains(title) : null,
                        genre != null && !genre.isBlank() ? movie.genre.eq(MovieGenre.valueOf(genre)) : null
                )
                .fetch();
    }
}
