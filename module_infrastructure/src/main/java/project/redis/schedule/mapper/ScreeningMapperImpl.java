package project.redis.schedule.mapper;

import org.springframework.stereotype.Component;
import project.redis.domain.movie.Movie;
import project.redis.movie.mapper.MovieMapper;
import project.redis.domain.schedule.Schedule;
import project.redis.schedule.entity.ScheduleEntity;
import project.redis.domain.screen.Screen;
import project.redis.screen.mapper.ScreenMapper;

@Component
public class ScreeningMapperImpl implements ScheduleMapper {

    private final MovieMapper movieMapper;
    private final ScreenMapper screenMapper;

    public ScreeningMapperImpl(MovieMapper movieMapper, ScreenMapper screenMapper) {
        this.movieMapper = movieMapper;
        this.screenMapper = screenMapper;
    }

    @Override
    public Schedule toDomain(
            ScheduleEntity screenEntity
    ) {
        Movie movie = movieMapper.toDomain(screenEntity.getMovie());
        Screen screen = screenMapper.toDomain(screenEntity.getScreen());
        return Schedule.of(movie, screen,
                screenEntity.getStartTime(), screenEntity.getEndTime());
    }
}
