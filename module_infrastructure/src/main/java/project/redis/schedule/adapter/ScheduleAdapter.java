package project.redis.schedule.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.schedule.Schedule;
import project.redis.schedule.entity.ScheduleEntity;
import project.redis.schedule.mapper.ScheduleMapper;
import project.redis.schedule.repository.ScheduleRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduleAdapter {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public List<Schedule> getShowingSchedules() {
        List<ScheduleEntity> screeningEntities = scheduleRepository.findAll();
        return screeningEntities.stream()
                .map(scheduleMapper::toDomain)
                .toList();
    }

    public List<Schedule> getSchedulesByMovieName(
            String movieName
    ) {
        List<ScheduleEntity> screeningEntities = scheduleRepository.findByMovieName(movieName);
        return screeningEntities.stream()
                .map(scheduleMapper::toDomain)
                .toList();
    }
}
