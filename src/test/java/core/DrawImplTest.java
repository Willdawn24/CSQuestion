package core;

import org.junit.Test;

import static org.junit.Assert.*;

public class DrawImplTest {
    DrawImpl draw = new DrawImpl();

    private void createStandardCanvus(){
        draw.getDisplayable(10,5);
    }

    @Test
    public void testGetDisplayable() {
        assertTrue(draw.getDisplayable(10,4));
    }

    @Test
    public void testGetDisplayableWithInvalidArgs() {
        assertFalse(draw.getDisplayable(0,4));
    }
    @Test
    public void testGetDisplayableWithInvalidArgs2() {
        assertFalse(draw.getDisplayable(3,0));
    }
    @Test
    public void testGetDisplayableWithInvalidArgs3() {
        assertFalse(draw.getDisplayable(-4,0));
    }

    @Test
    public void testToCreateVerticalLine() {
        createStandardCanvus();
        assertTrue(draw.getLine(1,1,2,1));
    }
    @Test
    public void testToCreateHorizontalLine() {
        createStandardCanvus();
        assertTrue(draw.getLine(1,1,1,2));
    }

    @Test
    public void testCommandToCreateLineWithInvalidArgs1() {
        createStandardCanvus();
        assertFalse(draw.getLine(1,1,3,2));
    }

    @Test
    public void testCommandToCreateLineWithInvalidArgs2() {
        createStandardCanvus();
        assertFalse(draw.getLine(1,1,3,-2));
    }
    @Test
    public void testCommandToCreateLineWithInvalidArgs3() {
        createStandardCanvus();
        assertFalse(draw.getLine(0,0,0,1));
    }
    @Test
    public void testCommandToCreateRectangle() {
        createStandardCanvus();
        assertTrue(draw.getRectangle(2,2,3,5));
    }

    @Test
    public void testCommandToCreateRectangleWithInvalidArgs() {
        createStandardCanvus();
        assertFalse(draw.getRectangle(2,2,3,15));
    }
    @Test
    public void testCommandToCreateRectangleWithInvalidArgsLength() {
        createStandardCanvus();
        assertFalse(draw.getRectangle(2,2,2,2));
    }
    @Test
    public void testCommandToFillWithValidArgs() {
        createStandardCanvus();
        draw.getRectangle(2,2,5,5);
        assertTrue(draw.fill(3,3,'o'));
    }

    @Test
    public void testCommandToFillWithValidArgs2() {
        createStandardCanvus();
        draw.getRectangle(2,2,5,5);
        assertTrue(draw.fill(3,3,'A'));
    }

    @Test
    public void testCommandToFillWithInvalidChar() {
        createStandardCanvus();
        draw.getRectangle(2,2,5,5);
        assertFalse(draw.fill(3,3,'x'));
    }

    @Test
    public void testCommandToFillWithInvalidChar2() {
        createStandardCanvus();
        draw.getRectangle(2,2,5,5);
        assertFalse(draw.fill(3,3,'-'));
    }
    @Test
    public void testCommandToFillWithInvalidChar3() {
        createStandardCanvus();
        draw.getRectangle(2,2,5,5);
        assertFalse(draw.fill(3,3,'|'));
    }

    @Test
    public void testDisplay() {
        try{
            createStandardCanvus();
            draw.display();
        }catch(Exception exception){
            fail("Unexpected error");
        }

    }
}