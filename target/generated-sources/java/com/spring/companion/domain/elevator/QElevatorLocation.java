package com.spring.companion.domain.elevator;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QElevatorLocation is a Querydsl query type for ElevatorLocation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QElevatorLocation extends EntityPathBase<ElevatorLocation> {

    private static final long serialVersionUID = 717964223L;

    public static final QElevatorLocation elevatorLocation = new QElevatorLocation("elevatorLocation");

    public final StringPath elevator_code = createString("elevator_code");

    public final StringPath elevator_loc = createString("elevator_loc");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> line = createNumber("line", Integer.class);

    public final StringPath section = createString("section");

    public final StringPath sub_name = createString("sub_name");

    public QElevatorLocation(String variable) {
        super(ElevatorLocation.class, forVariable(variable));
    }

    public QElevatorLocation(Path<? extends ElevatorLocation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QElevatorLocation(PathMetadata metadata) {
        super(ElevatorLocation.class, metadata);
    }

}

