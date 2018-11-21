package TheWall;

public class Game {

    private GameBoard board;
    private Walls walls;
    public Game(){
        board = new GameBoard();
        walls = new Walls();
    }
    public GameBoard getGameBoard(){
        return board;
    }
    public Wall[] getWalls()
    {
        return walls.getWalls();
    }
}
