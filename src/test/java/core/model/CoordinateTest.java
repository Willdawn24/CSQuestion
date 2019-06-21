package core.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void getxCoordinateTest() {
        int x=1, y=1;
        Coordinate coordinate = new Coordinate(x,y);
        assertEquals(x, coordinate.getxCoordinate());
    }

    @Test
    public void getyCoordinateTest() {
        int x=1, y=1;
        Coordinate coordinate = new Coordinate(x,y);
        assertEquals(y, coordinate.getyCoordinate());
    }

    @Test
    public void equalsTest() {
        Coordinate cdnt1 = new Coordinate(1,1);
        Coordinate cdnt2 = new Coordinate(1,1);
        Coordinate cdnt3 = new Coordinate(1,2);
        Coordinate cdnt4 = new Coordinate(2,2);
        assertTrue(cdnt1.equals(cdnt2));
        assertFalse(cdnt1.equals(cdnt3));
        assertFalse(cdnt3.equals(cdnt4));
    }

    @Test
    public void offsetTest() {
        Coordinate coordinate = new Coordinate(2,2);
        Coordinate target1 = new Coordinate(2,4),
                target2 = new Coordinate(4,2),
            target3 = new Coordinate(0,0);
        assertTrue(coordinate.offset(2,true).equals(target1));
        assertTrue(coordinate.offset(2,false).equals(target2));
        assertTrue(coordinate.offset(-2,true).offset(-2,false).equals(target3));
        assertTrue(coordinate.offset(0,true).equals(coordinate));
    }



}