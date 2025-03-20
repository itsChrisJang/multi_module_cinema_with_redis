package project.redis.schedule.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;
import project.redis.movie.entity.MovieEntity;
import project.redis.screen.entity.ScreenEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "SCHEDULE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "SCREEN_ID", nullable = false)
    private ScreenEntity screen;

    @Column(name = "START_DT", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "END_DT", nullable = false)
    private LocalDateTime endTime;

}
