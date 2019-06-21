package core.model;

import java.util.Objects;

public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

//    public boolean isVerticallyInline(Coordinate coordinate){
//        return !this.equals(coordinate) && getyCoordinate() == coordinate.getyCoordinate();
//    }
//
//    public boolean isHorizontallyInline(Coordinate coordinate){
//        return !this.equals(coordinate) && getxCoordinate() == coordinate.getxCoordinate();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return xCoordinate == that.xCoordinate &&
                yCoordinate == that.yCoordinate;
    }

    public Coordinate offset(int offset, boolean vertical){
        Coordinate cdnt;
        if(vertical){
            cdnt = new Coordinate(getxCoordinate(),getyCoordinate()+offset);
        }else{
            cdnt = new Coordinate(getxCoordinate()+offset, getyCoordinate());
        }
        return cdnt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
