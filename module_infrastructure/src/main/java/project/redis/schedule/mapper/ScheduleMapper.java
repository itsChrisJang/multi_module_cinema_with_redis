package project.redis.schedule.mapper;

import project.redis.schedule.Schedule;
import project.redis.schedule.entity.ScheduleEntity;

public interface ScheduleMapper {
    Schedule toDomain(ScheduleEntity screenEntity);
}
