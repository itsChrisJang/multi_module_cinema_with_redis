package project.redis.screen.mapper;

import project.redis.screen.Screen;
import project.redis.screen.entity.ScreenEntity;

public interface ScreenMapper {
    Screen toDomain(ScreenEntity screenEntity);
}
