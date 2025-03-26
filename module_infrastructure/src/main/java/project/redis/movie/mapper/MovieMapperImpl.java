package project.redis.movie.mapper;

import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.movie.Movie;
import project.redis.domain.schedule.Schedule;
import project.redis.movie.entity.MovieEntity;
import project.redis.schedule.entity.ScheduleEntity;

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
        return movieEntity.toDomain(movieEntity, scheduleMapper);
    }
}
