package TheWall;
/*
Creator: Erdem Ege Marasli
 */
public class Map {
    int [] squareLocations; // 16
    int [] edgeLocations; // 26
    int [] horizontalRectangleLocations; // 20
    int [] verticalRectangleLocations; // 21
    public Map(int [] squareLocations, int [] edgeLocations, int [] horizontalRectangleLocations, int[] verticalRectangleLocations ){
        this.squareLocations = squareLocations;
        this.edgeLocations = edgeLocations;
        this.horizontalRectangleLocations = horizontalRectangleLocations;
        this.verticalRectangleLocations = verticalRectangleLocations;
    }

    public int[] getEdgeLocations() {
        return edgeLocations;
    }

    public int[] getHorizontalRectangleLocations() {
        return horizontalRectangleLocations;
    }

    public int[] getSquareLocations() {
        return squareLocations;
    }

    public int[] getVerticalRectangleLocations() {
        return verticalRectangleLocations;
    }
}
