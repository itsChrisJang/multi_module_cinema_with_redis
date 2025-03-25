package project.redis.screen.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QScreenEntity is a Querydsl query type for ScreenEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScreenEntity extends EntityPathBase<ScreenEntity> {

    private static final long serialVersionUID = -1729349696L;

    public static final QScreenEntity screenEntity = new QScreenEntity("screenEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updDt = _super.updDt;

    //inherited
    public final StringPath updId = _super.updId;

    public QScreenEntity(String variable) {
        super(ScreenEntity.class, forVariable(variable));
    }

    public QScreenEntity(Path<? extends ScreenEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScreenEntity(PathMetadata metadata) {
        super(ScreenEntity.class, metadata);
    }

}

