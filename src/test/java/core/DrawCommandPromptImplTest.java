package core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawCommandPromptImplTest {
    private DrawCommandPromptImpl drawCommandPrompt;

    @Before
    public void before(){
        IDraw iDraw = new DrawImpl();
        drawCommandPrompt = new DrawCommandPromptImpl(iDraw);
    }

    @Test
    public void testGetMainMessage() {
        String string = "";
        assertNotEquals(string, drawCommandPrompt.getMainMessage());
    }

    @Test
    public void testCommandToCreateCanvusWithValidArgs() {
        String[] commandArgs = {"C", "10", "2"};
        assertTrue(drawCommandPrompt.command(commandArgs));
    }
    @Test
    public void testCommandToCreateCanvusWithInvalidArgs() {
        String[] commandArgs = {"C", "-10", "2"};
        assertFalse(drawCommandPrompt.command(commandArgs));

    }

    @Test
    public void testCommandToCreateVerticalLine() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"L","1","1","2","1"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
    }
    @Test
    public void testCommandToCreateHorizontalLine() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"L","1","1","1","2"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
    }

    @Test
    public void testCommandToCreateLineWithInvalidArgs1() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"L","1","1","2","4"};
        assertFalse(drawCommandPrompt.command(commandArgs2));
    }
//    @Test
//    public void testCommandToCreateLineWithInvalidArgs2() {
//        String[] commandArgs = {"C", "10", "4"};
//        drawCommandPrompt.command(commandArgs);
//        String[] commandArgs2 = {"L","1","1","2","-4"};
//        assertFalse(drawCommandPrompt.command(commandArgs2));
//    }
    @Test
    public void testCommandToCreateRectangle() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","2","2"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
    }
    @Test
    public void testCommandToCreateRectangleWithInvalidArgs() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","2","5"};
        assertFalse(drawCommandPrompt.command(commandArgs2));
    }

    @Test
    public void testCommandToFillWithValidArgs() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","3","3"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
        String[] commandArgs3 = {"B","2","2","o"};
        assertTrue(drawCommandPrompt.command(commandArgs3));
    }
//    @Test
//    public void testCommandToFillWithValidArgs2() {
//        String[] commandArgs = {"C", "10", "4"};
//        drawCommandPrompt.command(commandArgs);
//        String[] commandArgs2 = {"R","1","1","3","3"};
//        assertTrue(drawCommandPrompt.command(commandArgs2));
//        String[] commandArgs3 = {"B","4","2","A"};
//        assertTrue(drawCommandPrompt.command(commandArgs3));
//    }
    @Test
    public void testCommandToFillWithInvalidChar() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","3","3"};
        assertTrue(drawCommandPrompt.command(commandArgs2));
        String[] commandArgs3 = {"B","2","2","x"};
        assertFalse(drawCommandPrompt.command(commandArgs3));
    }
//    @Test
//    public void testCommandToFillWithInvalidChar2() {
//        String[] commandArgs = {"C", "10", "4"};
//        drawCommandPrompt.command(commandArgs);
//        String[] commandArgs2 = {"R","1","1","3","3"};
//        assertTrue(drawCommandPrompt.command(commandArgs2));
//        String[] commandArgs3 = {"B","2","2","-"};
//        assertFalse(drawCommandPrompt.command(commandArgs3));
//    }
//    @Test
//    public void testCommandToFillWithInvalidChar3() {
//        String[] commandArgs = {"C", "10", "4"};
//        drawCommandPrompt.command(commandArgs);
//        String[] commandArgs2 = {"R","1","1","3","3"};
//        assertTrue(drawCommandPrompt.command(commandArgs2));
//        String[] commandArgs3 = {"B","2","2","|"};
//        assertFalse(drawCommandPrompt.command(commandArgs3));
//    }
    @Test
    public void testCommandWithInvalidArgumentLength() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","3"};
        assertFalse(drawCommandPrompt.command(commandArgs2));
    }
    @Test
    public void testCommandWithInvalidArgumentType() {
        String[] commandArgs = {"C", "10", "4"};
        drawCommandPrompt.command(commandArgs);
        String[] commandArgs2 = {"R","1","1","3","three"};
        assertFalse(drawCommandPrompt.command(commandArgs2));
    }
}