package project.redis.schedule.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ScheduleDto {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
