package core.model;

public interface IShape {
    default boolean isOnBoundary(Coordinate coordinate){return false;};
    default boolean isInside(Coordinate coordinate){return false;};
    default boolean isOutside(Coordinate coordinate){
        return !(isOnBoundary(coordinate) || isInside(coordinate));
    };
}
