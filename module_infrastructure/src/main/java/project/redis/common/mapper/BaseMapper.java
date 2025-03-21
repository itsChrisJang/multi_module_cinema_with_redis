package project.redis.common.mapper;

public interface BaseMapper<D, E> {
    D toDomain(E entity);
//    E toEntity(D domain);  // 양방향 매핑 지원 시
}
