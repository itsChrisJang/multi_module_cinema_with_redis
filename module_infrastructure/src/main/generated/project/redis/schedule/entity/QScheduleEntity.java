package project.redis.schedule.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScheduleEntity is a Querydsl query type for ScheduleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScheduleEntity extends EntityPathBase<ScheduleEntity> {

    private static final long serialVersionUID = 1111374678L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScheduleEntity scheduleEntity = new QScheduleEntity("scheduleEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final project.redis.movie.entity.QMovieEntity movie;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final project.redis.screen.entity.QScreenEntity screen;

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updDt = _super.updDt;

    //inherited
    public final StringPath updId = _super.updId;

    public QScheduleEntity(String variable) {
        this(ScheduleEntity.class, forVariable(variable), INITS);
    }

    public QScheduleEntity(Path<? extends ScheduleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScheduleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScheduleEntity(PathMetadata metadata, PathInits inits) {
        this(ScheduleEntity.class, metadata, inits);
    }

    public QScheduleEntity(Class<? extends ScheduleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.movie = inits.isInitialized("movie") ? new project.redis.movie.entity.QMovieEntity(forProperty("movie")) : null;
        this.screen = inits.isInitialized("screen") ? new project.redis.screen.entity.QScreenEntity(forProperty("screen")) : null;
    }

}

