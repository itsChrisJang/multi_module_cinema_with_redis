package project.redis.schedule.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.schedule.Schedule;
import project.redis.domain.screen.Screen;
import project.redis.schedule.entity.ScheduleEntity;
import project.redis.screen.entity.ScreenEntity;

@Component
@Slf4j
public class ScheduleMapperImpl implements BaseMapper<Schedule, ScheduleEntity> {

    private final BaseMapper<Screen, ScreenEntity> screenMapper;

    public ScheduleMapperImpl(BaseMapper<Screen, ScreenEntity> screenMapper) {
        this.screenMapper = screenMapper;
    }

    @Override
    public Schedule toDomain(
            ScheduleEntity scheduleEntity
    ) {
        Screen screen = screenMapper.toDomain(scheduleEntity.getScreen());
        return Schedule.of(
                screen,
                scheduleEntity.getStartTime(),
                scheduleEntity.getEndTime()
        );
    }
}
