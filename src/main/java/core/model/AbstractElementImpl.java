package core.model;


/**
 *
 */
public abstract class AbstractElementImpl implements ICommitable {

    protected abstract boolean checkConstructorArgs();

    @Override
    public abstract boolean commit(IDisplayable displayable, Coordinate coordinate) throws IllegalArgumentException;

}
