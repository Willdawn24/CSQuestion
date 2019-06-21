package core.model;

public interface IDisplayable {
    void display();
    boolean checkCoordinateValidity(Coordinate coordinate);
    boolean commit(Coordinate coordinate, char c);
}
