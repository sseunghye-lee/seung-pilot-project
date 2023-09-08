package com.sseung.pilot.seungpilotproject.business.comment.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComments is a Querydsl query type for Comments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComments extends EntityPathBase<Comments> {

    private static final long serialVersionUID = -1090749088L;

    public static final QComments comments = new QComments("comments");

    public final com.sseung.pilot.seungpilotproject.commons.QBaseEntity _super = new com.sseung.pilot.seungpilotproject.commons.QBaseEntity(this);

    public final NumberPath<Long> bdId = createNumber("bdId", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> ctId = createNumber("ctId", Long.class);

    //inherited
    public final NumberPath<Long> modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> parentId = createNumber("parentId", Long.class);

    public QComments(String variable) {
        super(Comments.class, forVariable(variable));
    }

    public QComments(Path<? extends Comments> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComments(PathMetadata metadata) {
        super(Comments.class, metadata);
    }

}

