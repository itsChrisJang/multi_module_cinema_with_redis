package project.redis.seat.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeatEntity is a Querydsl query type for SeatEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeatEntity extends EntityPathBase<SeatEntity> {

    private static final long serialVersionUID = -394982862L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSeatEntity seatEntity = new QSeatEntity("seatEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    public final StringPath column = createString("column");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final StringPath row = createString("row");

    public final project.redis.screen.entity.QScreenEntity screen;

    public final EnumPath<project.redis.domain.seat.SeatStatus> status = createEnum("status", project.redis.domain.seat.SeatStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updDt = _super.updDt;

    //inherited
    public final StringPath updId = _super.updId;

    public QSeatEntity(String variable) {
        this(SeatEntity.class, forVariable(variable), INITS);
    }

    public QSeatEntity(Path<? extends SeatEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSeatEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSeatEntity(PathMetadata metadata, PathInits inits) {
        this(SeatEntity.class, metadata, inits);
    }

    public QSeatEntity(Class<? extends SeatEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.screen = inits.isInitialized("screen") ? new project.redis.screen.entity.QScreenEntity(forProperty("screen")) : null;
    }

}

