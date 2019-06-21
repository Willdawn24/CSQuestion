package core;

public interface IDraw {
    boolean getDisplayable(int width, int height);
    boolean getLine(int startX, int startY, int endX, int endY);
    boolean getRectangle(int startX, int startY, int endX, int endY) ;
    void display();
    boolean fill(int x, int y, char c);
}
