package com.sseung.pilot.seungpilotproject.business.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 1756993939L;

    public static final QBoard board = new QBoard("board");

    public final com.sseung.pilot.seungpilotproject.commons.QBaseEntity _super = new com.sseung.pilot.seungpilotproject.commons.QBaseEntity(this);

    public final NumberPath<Long> bdId = createNumber("bdId", Long.class);

    public final EnumPath<com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory> boardCategory = createEnum("boardCategory", com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory.class);

    public final StringPath content = createString("content");

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath title = createString("title");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> view = createNumber("view", Long.class);

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

