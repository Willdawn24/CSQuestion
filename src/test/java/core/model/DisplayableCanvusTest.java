package core.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class DisplayableCanvusTest {
    DisplayableCanvus displayableCanvus;
    Coordinate cdntInside, cdntOnBoundary, cdntOnCorner, cdntOutside,
            cdntOutside2, cdntOnBoundary2;

    @Before
    public void setUp() throws Exception {
        displayableCanvus = new DisplayableCanvus(10,10);

        cdntInside = new Coordinate(5,5);
        cdntOnBoundary = new Coordinate(5,0);
        cdntOnCorner = new Coordinate(0,0);
        cdntOutside = new Coordinate(14,7);
        cdntOutside2 = new Coordinate(10,-7);
        cdntOnBoundary2 = new Coordinate(0,7);
    }

    @Test
    public void testInvalidConstruct1(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
           displayableCanvus = new DisplayableCanvus(0,10);
        });
    }
    @Test
    public void testInvalidConstruct2(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            displayableCanvus = new DisplayableCanvus(10,-10);
        });
    }

    @Test
    public void testCommit() {
        Coordinate coordinate = new Coordinate(1,5);
        char c = 'A';
        assertTrue(displayableCanvus.commit(coordinate,c));
    }

    @Test
    public void testCommitWithOutsideCoordinate() {
        Coordinate coordinate = new Coordinate(-1,5);
        char c = 'A';
        assertFalse(displayableCanvus.commit(coordinate,c));
    }
    @Test
    public void testCheckCoordinateValidity() {
        assertFalse(displayableCanvus.checkCoordinateValidity(cdntOnCorner));
        assertFalse(displayableCanvus.checkCoordinateValidity(cdntOnBoundary));
        assertFalse(displayableCanvus.checkCoordinateValidity(cdntOutside));
        assertTrue(displayableCanvus.checkCoordinateValidity(cdntInside));
    }

    @Test
    public void testIsOnBoundary() {
        assertTrue(displayableCanvus.isOnBoundary(cdntOnBoundary));
        assertTrue(displayableCanvus.isOnBoundary(cdntOnCorner));
        assertFalse(displayableCanvus.isOnBoundary(cdntInside));
        assertFalse(displayableCanvus.isOnBoundary(cdntOutside));
    }

    @Test
    public void testIsInside() {
        assertFalse(displayableCanvus.isInside(cdntOnBoundary));
        assertFalse(displayableCanvus.isInside(cdntOnCorner));
        assertTrue(displayableCanvus.isInside(cdntInside));
        assertFalse(displayableCanvus.isInside(cdntOutside));
    }

    @Test
    public void testIsOnVerticalBoundary() {
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntOnBoundary));
        assertTrue(displayableCanvus.isOnVerticalBoundary(cdntOnCorner));
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntInside));
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntOutside));
        assertTrue(displayableCanvus.isOnVerticalBoundary(cdntOnBoundary2));
        assertFalse(displayableCanvus.isOnVerticalBoundary(cdntOutside2));
    }

    @Test
    public void testIsOnHorizontalBoundary() {
        assertTrue(displayableCanvus.isOnHorizontalBoundary(cdntOnBoundary));
        assertTrue(displayableCanvus.isOnHorizontalBoundary(cdntOnCorner));
        assertFalse(displayableCanvus.isOnHorizontalBoundary(cdntInside));
        assertFalse(displayableCanvus.isOnHorizontalBoundary(cdntOutside));
        assertFalse(displayableCanvus.isOnHorizontalBoundary(cdntOnBoundary2));

    }

    @Test
    public void testGetWidth(){
        assertEquals(12, displayableCanvus.getWidth());
    }

    @Test
    public void testGetHeightTest(){
        assertEquals(12, displayableCanvus.getHeight());
    }

    @Test
    public void testGetChar(){
        assertEquals(' ', displayableCanvus.getChar(new Coordinate(5,5)));
    }
    @Test
    public void testGetCharWithOutsideCoordinate(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{displayableCanvus.getChar(new Coordinate(-5,5));});
    }
    @Test
    public void testFillWithInsideCoordinate() {
        char c = 'M';
        assertTrue(displayableCanvus.fill(new Coordinate(5,5), c));
    }
    @Test
    public void testFillWithOutsideCoordinate() {
        char c = 'M';
        assertFalse(displayableCanvus.fill(new Coordinate(0,5), c));
    }
}