package project.redis.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovieEntity is a Querydsl query type for MovieEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovieEntity extends EntityPathBase<MovieEntity> {

    private static final long serialVersionUID = 279880590L;

    public static final QMovieEntity movieEntity = new QMovieEntity("movieEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    public final EnumPath<project.redis.domain.movie.MovieRate> filmRating = createEnum("filmRating", project.redis.domain.movie.MovieRate.class);

    public final EnumPath<project.redis.domain.movie.MovieGenre> genre = createEnum("genre", project.redis.domain.movie.MovieGenre.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final DatePath<java.time.LocalDate> releaseDate = createDate("releaseDate", java.time.LocalDate.class);

    public final NumberPath<Integer> runningTime = createNumber("runningTime", Integer.class);

    public final ListPath<project.redis.schedule.entity.ScheduleEntity, project.redis.schedule.entity.QScheduleEntity> schedules = this.<project.redis.schedule.entity.ScheduleEntity, project.redis.schedule.entity.QScheduleEntity>createList("schedules", project.redis.schedule.entity.ScheduleEntity.class, project.redis.schedule.entity.QScheduleEntity.class, PathInits.DIRECT2);

    public final StringPath thumbnailUrl = createString("thumbnailUrl");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updDt = _super.updDt;

    //inherited
    public final StringPath updId = _super.updId;

    public QMovieEntity(String variable) {
        super(MovieEntity.class, forVariable(variable));
    }

    public QMovieEntity(Path<? extends MovieEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovieEntity(PathMetadata metadata) {
        super(MovieEntity.class, metadata);
    }

}

