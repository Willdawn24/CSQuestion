package core.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Point extends AbstractElementImpl implements ICommitable {
    private static Logger logger = LoggerFactory.getLogger(Point.class);

    private char character = ' ';

    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    protected boolean checkConstructorArgs() {
        return true;
    }

    @Override
    public String toString() {
        return "Point{" +
                "character=" + character +
                '}';
    }

    @Override
    public boolean commit(IDisplayable displayable, Coordinate coordinate) throws IllegalArgumentException {
        logger.debug("Create Point {} at coordiate {}", this, coordinate);
        boolean result = displayable.commit(coordinate,character);
        return result;
    }


}
