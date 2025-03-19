package project.redis.movie.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.redis.movie.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findAll();

    @Query("SELECT DISTINCT m FROM MovieEntity m " +
            "JOIN ScheduleEntity s ON m.id = s.movie.id " +
            "WHERE m.releaseDate <= :today " +
            "AND s.startTime <= :now " +
            "AND s.endTime >= :now")
    List<MovieEntity> findNowPlayingMovies(@Param("today") LocalDate today, @Param("now") LocalDateTime now);

    @Query("SELECT DISTINCT m FROM MovieEntity m " +
            "JOIN FETCH m.schedules s " +
            "WHERE m.releaseDate <= :today " +
            "AND s.startTime <= :now " +
            "AND s.endTime >= :now")
    List<MovieEntity> findNowPlayingMoviesWithSchedules(@Param("today") LocalDate today, @Param("now") LocalDateTime now);


}
