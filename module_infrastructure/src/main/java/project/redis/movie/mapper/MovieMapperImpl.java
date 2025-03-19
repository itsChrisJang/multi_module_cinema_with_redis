package project.redis.movie.mapper;

import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.entity.MovieEntity;
import project.redis.schedule.mapper.ScheduleMapper;

import java.util.stream.Collectors;

@Component
public class MovieMapperImpl implements MovieMapper {

    private final ScheduleMapper scheduleMapper;

    public MovieMapperImpl(ScheduleMapper scheduleMapper) {
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
