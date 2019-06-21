package core.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleTest {

    @Test
    public void checkConstructorArgsTest() {
        Rectangle rect = null;
        rect = new Rectangle(2,2);
        assertTrue(!rect.equals(null));
    }

    @Test
    public void checkConstructorInvalidArgsTest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Rectangle(0,1);});
        Assertions.assertThrows(IllegalArgumentException.class, ()->{new Rectangle(-1,-1);});
    }


    @Test
    public void commitWithValidCoordinate() {
        IDisplayable displayable = new DisplayableCanvus(10,10);
        Rectangle rect = new Rectangle(5,5);
        assertTrue(rect.commit(displayable, new Coordinate(5,5)));
    }
    @Test
    public void commitWithCoordianteOutside() {
        IDisplayable displayable = new DisplayableCanvus(10,10);
        Rectangle rect = new Rectangle(5,5);
        assertFalse(rect.commit(displayable, new Coordinate(8,8)));
    }
    @Test
    public void testIsOnBoundary(){
        Rectangle rect = new Rectangle(10,10);
        assertFalse(rect.isOnBoundary(new Coordinate(1,1)));
    }

    @Test
    public void testIsInside(){
        Rectangle rect = new Rectangle(10,10);
        assertFalse(rect.isInside(new Coordinate(1,1)));
    }
}