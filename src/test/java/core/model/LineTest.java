package core.model;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LineTest {

    @org.junit.Test
    public void checkConstructorInvalidArgs1() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(1,true);});
    }
    @org.junit.Test
    public void checkConstructorInvalidArgs2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Line(-1,true);});
    }
    @org.junit.Test
    public void checkConstructorArgs() {
        Line line1 = null;
        line1 = new Line(2, true);
        assertTrue(line1!=null);
    }

    @org.junit.Test
    public void testCommitWithValidCoordinate() {

        IDisplayable displayable = new DisplayableCanvus(10,10);
        Line line = new Line(2, true);
        assertTrue(line.commit(displayable, new Coordinate(5,5)));

    }
    @org.junit.Test
    public void testCommitVerticalLineWithOutsideCoordinate() {

        IDisplayable displayable = new DisplayableCanvus(10,10);
        Line line = new Line(4, true);
        assertFalse(line.commit(displayable, new Coordinate(9,9)));

    }
    @org.junit.Test
    public void testCommitHorizontalLineWithOutsideCoordinate() {

        IDisplayable displayable = new DisplayableCanvus(10,10);
        Line line = new Line(4, false);
        assertFalse(line.commit(displayable, new Coordinate(9,9)));

    }
}