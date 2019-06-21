package core.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointTest {
    private Point point;

    @Before
    public void before(){
        point = new Point();
    }

    @After
    public void after(){
        point = null;
    }

    @Test
    public void setCharacterTest() {
        assertTrue(point.getCharacter() == ' ');
        char c = '.';
        point.setCharacter(c);
        assertTrue(point.getCharacter() == c);
    }

    @Test
    public void getCharacterTest() {
        assertTrue(point.getCharacter() == ' ');
    }

    @Test
    public void checkConstructorArgsTest() {
        assertTrue(point.checkConstructorArgs());
    }

    @Test
    public void toStringTest() {
        assertTrue(point.toString().contains("character= "));
    }

    @Test
    public void testCommitWithInsideCoordinate() {
        IDisplayable displayable = new DisplayableCanvus(10,10);
        Point point = new Point();
        point.setCharacter('o');
        assertTrue(point.commit(displayable, new Coordinate(5,5)));
    }
    @Test
    public void testCommitWithOutsideCoordinate() {
        IDisplayable displayable = new DisplayableCanvus(10,10);
        Point point = new Point();
        point.setCharacter('o');
        assertFalse(point.commit(displayable, new Coordinate(-5,5)));
    }
}