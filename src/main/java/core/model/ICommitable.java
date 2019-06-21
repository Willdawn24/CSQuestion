package core.model;

public interface ICommitable {
    boolean commit(IDisplayable displayable, Coordinate coordinate);
}
