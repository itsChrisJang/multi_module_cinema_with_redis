package project.redis.movie.mapper;

import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.movie.Movie;
import project.redis.domain.schedule.Schedule;
import project.redis.movie.entity.MovieEntity;
import project.redis.schedule.entity.ScheduleEntity;

import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements BaseMapper<Movie, MovieEntity> {

    private final BaseMapper<Schedule, ScheduleEntity> scheduleMapper;

    public MovieMapperImpl(BaseMapper<Schedule, ScheduleEntity> scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public Movie toDomain(
            MovieEntity movieEntity
    ) {
        return Movie.of(
                movieEntity.getTitle(),
                movieEntity.getGenre(),
                movieEntity.getReleaseDate(),
                movieEntity.getFilmRating(),
                movieEntity.getThumbnailUrl(),
                movieEntity.getRunningTime(),
                movieEntity.getSchedules().stream()
                        .map(scheduleMapper::toDomain)
                        .collect(Collectors.toList())
        );
    }
}
