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

    public boolean isSame(Map temp){
        for(int i = 0; i < squareLocations.length; i++){
            if(squareLocations[i] != temp.squareLocations[i])
                return false;
        }
        for(int i = 0; i < edgeLocations.length; i++){
            if(edgeLocations[i] != temp.edgeLocations[i])
                return false;
        }
        for(int i = 0; i < horizontalRectangleLocations.length; i++){
            if(horizontalRectangleLocations[i] != temp.horizontalRectangleLocations[i])
                return false;
        }
        for(int i = 0; i < verticalRectangleLocations.length; i++){
            if(verticalRectangleLocations[i] != temp.verticalRectangleLocations[i])
                return false;
        }
        return true;
    }

}
