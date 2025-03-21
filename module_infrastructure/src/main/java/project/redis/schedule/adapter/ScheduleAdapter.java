package project.redis.schedule.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.schedule.Schedule;
import project.redis.schedule.repository.ScheduleRepository;
import project.redis.schedule.entity.ScheduleEntity;

@Component
@RequiredArgsConstructor
public class ScheduleAdapter {

    private final ScheduleRepository scheduleRepository;
    private final BaseMapper<Schedule, ScheduleEntity> scheduleMapper;

//    public List<Schedule> getShowingSchedules() {
//        List<ScheduleEntity> screeningEntities = scheduleRepository.findAll();
//        return screeningEntities.stream()
//                .map(scheduleMapper::toDomain)
//                .toList();
//    }

//    public List<Schedule> getSchedulesByMovieName(
//            String movieName
//    ) {
//        List<ScheduleEntity> screeningEntities = scheduleRepository.findByMovieName(movieName);
//        return screeningEntities.stream()
//        return new ArrayList<ScheduleEntity>().stream()
//                .map(scheduleMapper::toDomain)
//                .toList();
//    }
}
