package core;

import core.model.Coordinate;
import core.model.DisplayableCanvus;
import core.model.Line;
import core.model.Rectangle;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrawImpl implements IDraw {
    private static Logger logger = LoggerFactory.getLogger(DrawImpl.class);

    DisplayableCanvus displayableCanvus;
    @Override
    public boolean getDisplayable(int width, int height) {
        boolean result = true;
        try{
            displayableCanvus = new DisplayableCanvus(width, height);
        }catch (IllegalArgumentException e){
            result = false;
            logger.error("Failed to create canvus with width {} and height {}. {}", width, height, e.getMessage());
        }
        return result;
    }

    @Override
    public boolean getLine(int startX, int startY, int endX, int endY) {
        Line line;
        boolean result = true;
        try{
            if (startX == endX)
                line = new Line(1+ Math.abs(endY-startY),true);
            else if(startY == endY)
                line = new Line(1+ Math.abs(endX - startX), false);
            else
                throw new IllegalArgumentException("Neither the argument is vertical, nor is horizontal.");
            Coordinate drawPoint = new Coordinate(startX, startY);
            if(!line.commit(displayableCanvus, drawPoint))
                result = false;
        }catch(IllegalArgumentException e){
            result = false;
            logger.error("Failed to create line from {},{} to {},{}. {}", startX, startY, endX, endY, e.getMessage());
        }
        return result;
    }

    @Override
    public boolean getRectangle(int startX, int startY, int endX, int endY)  {
        Rectangle rectangle;
        boolean result = true;
        try{
            rectangle = new Rectangle(1+ Math.abs(endX-startX), 1+ Math.abs(endY - startY));
            Coordinate drawPoint = new Coordinate(startX, startY);
            result = rectangle.commit(displayableCanvus, drawPoint);
        }catch(IllegalArgumentException e){
            result = false;
            logger.error("Failed to create rectangle at {} and {}. {}", new Coordinate(startX, startY), new Coordinate(endX, endY), e.getMessage());
        }
        return result;
    }

    @Override
    public boolean fill(int x, int y, char c) {
        boolean result = true;
        Coordinate coordinate = new Coordinate(x, y);
        if(c == 'x' || c=='-' || c=='|')
            result = false;
        else
            result = displayableCanvus.fill(coordinate, c);
        return result;
    }

    @Override
    public void display() {
        displayableCanvus.display();
    }
}
