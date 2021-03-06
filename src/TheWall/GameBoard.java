package TheWall;

import java.awt.*;
import java.util.ArrayList;
/**
Creator: Erdem Ege Marasli
 This class contains all the information about the gameboard.
 */
public class GameBoard implements Drawable
{
    private Map map;
    private ArrayList<GameUnit> gameUnits = new ArrayList<GameUnit>();
    private GameUnit[] castle;
    private GameUnit[] castle1Dev;
    private GameUnit[] castle2Dev;
    private GameUnit[] fixedUnits;
    final int edgeHeight = 20;
    final int edgeWidth = 20;
    final int squareHeight = 60;
    final int squareWidth = 60;
    final int rectangleHeight = 20;
    final int rectangleWidth = 60;
    final int mostLeftX = 100;
    final int mostUpY = 100;
    Edge edges[] = new Edge[26];
    Square squares[] = new Square[16];
    Rectangle horizontalRectangles[] = new Rectangle[21];
    Rectangle verticalRectangles[] = new Rectangle[20];
    int theme;
    int mode;
    int friendlyUnitCount;
    int hostileUnitCount;
    public GameBoard(Map map, int mode, int theme)
    {
        /*
        if(mode == 4){
            friendlyUnitCount=0;
            hostileUnitCount=0;
            this.theme = theme;
            this.mode = mode;
            createEmptyGameBoard();
            castle = new GameUnit[2];
        }
        */


        friendlyUnitCount=0;
        hostileUnitCount=0;
        this.theme = theme;
        createEmptyGameBoard();

        this.map = map;
        castle = new GameUnit[2];
        setUpGameBoard();
        this.mode = mode;
        if (mode == 1) {
            createUnitsForDeveloper();
            castle = null;
        }

    }

    /**
     *
     * This method setups the game board for to play already created map
     */
    public void setUpCreatedMap(String str){
        int [] squaresLocations = new int[16];
        int [] edgeLocations = new int[26];
        int [] horizontalLineLocations = new int[21];
        int [] verticalLineLocations = new int[20];
        int count = 0;
        for(int i = 0; i < squaresLocations.length; i++){
            squaresLocations[i] = Character.getNumericValue(str.charAt(count));
            count++;
        }
        for(int i = 0; i < edgeLocations.length; i++){
            edgeLocations[i] = Character.getNumericValue(str.charAt(count));
            count++;
        }
        for(int i = 0; i < horizontalLineLocations.length; i++){
            horizontalLineLocations[i] = Character.getNumericValue(str.charAt(count));
            count++;
        }
        for(int i = 0; i < verticalLineLocations.length; i++){
            verticalLineLocations[i] = Character.getNumericValue(str.charAt(count));
            count++;
        }
        map = new Map(squaresLocations,edgeLocations,horizontalLineLocations,verticalLineLocations);
        setUpGameBoard();

    }
    public void setCastle(GameUnit[] castle) {
        this.castle = castle;
    }

    public GameUnit[] getCastle() {
        return castle;
    }

    public ArrayList<GameUnit> getGameUnits() {
        return gameUnits;
    }

    public GameUnit[] getCastle1Dev() {
        return castle1Dev;
    }

    public GameUnit[] getCastle2Dev() {
        return castle2Dev;
    }

    public GameUnit[] getFixedUnits() {
        return fixedUnits;
    }

    public int getMode() {
        return mode;
    }

    /**
     * This method setups the gameboard according to the current map.
     * */
    public void setUpGameBoard(){
        int temp = 0;
        for (int i = 0; i < map.getSquareLocations().length; i++) {
            squares[i].setInfo(map.getSquareLocations()[i]);
            if (map.getSquareLocations()[i] == 1) {
                GameUnit unit = new GameUnit(squares[i].getX(), squares[i].getY(), squareHeight, false, theme);
                unit.setInfo(friendlyUnitCount);
                unit.setIndexNo(i);
                friendlyUnitCount++;
                gameUnits.add(unit);
            }
            else if (map.getSquareLocations()[i] == 2) {
                GameUnit unit = new GameUnit(squares[i].getX(), squares[i].getY(), squareHeight, true, theme);
                unit.setInfo(hostileUnitCount);
                unit.setIndexNo(i);
                hostileUnitCount++;
                gameUnits.add(unit);
            }
            else if (map.getSquareLocations()[i] == 3) {
                castle[temp] = new GameUnit(squares[i].getX(), squares[i].getY(), squareHeight, false, theme);
                castle[temp].setIndexNo(i);
                castle[temp].setIsCastle(true);
                temp++;
            }
        }
        for (int i = 0; i < map.getEdgeLocations().length; i++) {
            edges[i].setInfo(0);
        }
        for (int i = 0; i < map.getVerticalRectangleLocations().length; i++) {
            if (map.getVerticalRectangleLocations()[i] == 2) {
                verticalRectangles[i].setInfo(2);
            } else {
                verticalRectangles[i].setInfo(0);
            }
        }
        for (int i = 0; i < map.getHorizontalRectangleLocations().length; i++) {
            if (map.getHorizontalRectangleLocations()[i] == 2) {
                horizontalRectangles[i].setInfo(2);
            } else {
                horizontalRectangles[i].setInfo(0);
            }
        }


    }

    /**
     *
     * This method checks if selected castle is valid to place that current location.
     */
    public boolean isValidMoveCastle(){
        int count = 0;
        if(castle != null){
            for(int i = 0; i < squares.length; i++){
                if(squares[i].isContainPoint(castle[0].getMidX(),castle[0].getMidY()) && squares[i].getInfo() == 0){
                    count++;
                }
                else if(squares[i].isContainPoint(castle[1].getMidX(), castle[1].getMidY()) && squares[i].getInfo() == 0){
                    count++;
                }
            }
        }
        return count == 2;
    }

    /**
     * This method place the castle to the current location and setups the current map accordingly.
     */
    public void makeMoveCastle(){
        if(castle != null){
            for(int i = 0; i < squares.length; i++){
                if(squares[i].isContainPoint(castle[0].getMidX(),castle[0].getMidY()) && squares[i].getInfo() == 0){
                    castle[0].setIndexNo(i);
                    castle[0].setX(squares[i].getX());
                    castle[0].setY(squares[i].getY());
                    squares[i].setInfo(3);
                }
                else if(squares[i].isContainPoint(castle[1].getMidX(), castle[1].getMidY()) && squares[i].getInfo() == 0){
                    castle[1].setIndexNo(i);
                    castle[1].setX(squares[i].getX());
                    castle[1].setY(squares[i].getY());
                    squares[i].setInfo(3);
                }
            }
        }
    }

    /**
     * This method detach the castle when placed,however it has some bugs.
     */
    public void detachCastle(){
        if(castle != null){
            squares[castle[0].getIndexNo()].setInfo(0);
            squares[castle[1].getIndexNo()].setInfo(0);
            castle[0].setIndexNo(-1);
            castle[1].setIndexNo(-1);
        }
    }

    /**
     *
     * This method controls the given unit. Returns true if given unit can place to the current location.
     */
    public boolean isValidMove(GameUnit unit){
        if(unit.isCastle() == false){
            for(int i = 0; i < squares.length; i++){
                if(squares[i].isContainPoint(unit.getMidX(),unit.getMidY()) && squares[i].getInfo() == 0){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     *
     * This method place the given unit to the current location and setups the current map accordingly
     */
    public void makeMove(GameUnit unit){
        if(unit.isCastle() == false){
            for(int i = 0; i < squares.length; i++){
                if(squares[i].isContainPoint(unit.getMidX(),unit.getMidY()) && squares[i].getInfo() == 0){
                    unit.setIndexNo(i);
                    unit.setX(squares[i].getX());
                    unit.setY(squares[i].getY());
                    if(unit.isEnemy() == false){
                        squares[i].setInfo(1);
                    }
                    else{
                        squares[i].setInfo(2);
                    }
                    break;
                }
            }
        }
    }

    /**
     *
     * This method detach the given unit from the gameboard and setups the gameboard accordingly.
     */
    public void detachUnit(GameUnit unit){
        if(unit.isCastle() == false){
            squares[unit.getIndexNo()].setInfo(0);
            unit.setIndexNo(-1);
        }

    }
    /**
     *
     * This method controls the given wall. Returns true if given wall can place to the current location.
     */
    public boolean isValidMove(Wall wall){
        //Found the type of the wall
        int verticalCount = 0;
        int horizontalCount = 0;
        int edgeCount = 0;
        for(int i = 0; i < wall.getWallLines().length; i++){
            if(wall.getWallLines()[i].isVertical()){
                verticalCount++;
            }
            else{
                horizontalCount++;
            }
        }
        for(int i = 0; i < wall.getWallEdges().length; i++){
            /*
            if(wall.getWallEdges()[i].isCastle() == true){
                edgeCount++;
            }*/
            edgeCount++;
        }
        int tempVertical = 0;
        int tempHorizontal = 0;
        int tempEdge = 0;
        int middleX;
        int middleY;
        for(int i = 0; i < wall.getWallLines().length; i++){
            middleX = wall.getWallLines()[i].getMiddleX();
            middleY = wall.getWallLines()[i].getMiddleY();
            for(int j = 0; j < verticalRectangles.length; j++){
                if(verticalRectangles[j].isContainPoint(middleX, middleY) && verticalRectangles[j].getInfo() == 0){
                    tempVertical++;
                }
            }
            for(int j = 0; j < horizontalRectangles.length; j++){
                if(horizontalRectangles[j].isContainPoint(middleX, middleY) && horizontalRectangles[j].getInfo() == 0){
                    tempHorizontal++;
                }
            }
        }
        for(int i = 0; i < wall.getWallEdges().length; i++){
            middleX = wall.getWallEdges()[i].getMiddleX();
            middleY = wall.getWallEdges()[i].getMiddleY();
            for(int j = 0; j < edges.length; j++){
                if(edges[j].isContainPoint(middleX, middleY)){

                    if(wall.getWallEdges()[i].isCastle() == true){
                        if(edges[j].getInfo() == 0)
                            tempEdge++;
                    }
                    else{
                        if(edges[j].getInfo() != 1){
                            tempEdge++;
                        }
                    }
                }
            }
        }
        return verticalCount == tempVertical && horizontalCount == tempHorizontal && edgeCount == tempEdge;

    }

    /**
     *
     * This method place the given wall to the current location and setups the current map accordingly
     */
    public void makeMove(Wall wall){
        int middleX;
        int middleY;
        for(int i = 0; i < wall.getWallLines().length; i++){
            middleX = wall.getWallLines()[i].getMiddleX();
            middleY = wall.getWallLines()[i].getMiddleY();
            for(int j = 0; j < verticalRectangles.length; j++){
                if(verticalRectangles[j].isContainPoint(middleX, middleY) && verticalRectangles[j].getInfo() == 0){
                    verticalRectangles[j].setInfo(1);
                    wall.getWallLines()[i].setIndexNo(j);
                    wall.getWallLines()[i].setX(verticalRectangles[j].getX());
                    wall.getWallLines()[i].setY(verticalRectangles[j].getY());
                }
            }
            for(int j = 0; j < horizontalRectangles.length; j++){
                if(horizontalRectangles[j].isContainPoint(middleX, middleY) && horizontalRectangles[j].getInfo() == 0){
                    horizontalRectangles[j].setInfo(1);
                    wall.getWallLines()[i].setIndexNo(j);
                    wall.getWallLines()[i].setX(horizontalRectangles[j].getX());
                    wall.getWallLines()[i].setY(horizontalRectangles[j].getY());
                }
            }
        }
        for(int i = 0; i < wall.getWallEdges().length; i++){
            middleX = wall.getWallEdges()[i].getMiddleX();
            middleY = wall.getWallEdges()[i].getMiddleY();
            for(int j = 0; j < edges.length; j++){
                if(edges[j].isContainPoint(middleX, middleY)){
                    if(wall.getWallEdges()[i].isCastle() == true){
                        if(edges[j].getInfo() == 0){
                            edges[j].setInfo(1);
                            wall.getWallEdges()[i].setIndexNo(j);
                            wall.getWallEdges()[i].setX(edges[j].getX());
                            wall.getWallEdges()[i].setY(edges[j].getY());
                        }
                    }
                    else if(edges[j].getInfo() != 1){
                        wall.getWallEdges()[i].setIndexNo(j);
                        edges[j].setInfo(2);
                        wall.getWallEdges()[i].setX(edges[j].getX());
                        wall.getWallEdges()[i].setY(edges[j].getY());
                    }
                }
            }
        }
        wall.setPlaced(true);
    }
    /**
     *
     * This method detach the given wall from the gameboard and setups the gameboard accordingly.
     */
    public void detachWall(Wall wall){
        for(int i = 0; i < wall.getWallLines().length; i++){
            if(wall.getWallLines()[i].isVertical()){
                verticalRectangles[wall.getWallLines()[i].getIndexNo()].setInfo(0);
            }
            else{
                horizontalRectangles[wall.getWallLines()[i].getIndexNo()].setInfo(0);
            }
        }
        for(int i = 0; i < wall.getWallEdges().length; i++){
            edges[wall.getWallEdges()[i].getIndexNo()].setInfo(0);
        }
        wall.setPlaced(false);
    }
    public String returnCreatedMap(){
        String temp = "";
        for(int i = 0; i < squares.length; i++){
            temp += squares[i].getInfo();
        }
        for(int i = 0; i < edges.length; i++){
            temp += edges[i].getInfo();
        }
        for(int i = 0; i < horizontalRectangles.length; i++){
            temp += horizontalRectangles[i].getInfo();
        }
        for(int i = 0; i < verticalRectangles.length; i++){
            temp += verticalRectangles[i].getInfo();
        }
        return temp;

    }

    /**
     *
     * This method controls if the players current map matches with the given map. If they are match player solved
     * the map so method returns true.
     */
    public boolean isGameFinished(){
        for(int i = 0; i < squares.length; i++){
            if(squares[i].getInfo() != map.getSquareLocations()[i])
                return false;
        }
        for(int i = 0; i < edges.length; i++){
            if((edges[i].getInfo() == 0 || edges[i].getInfo() == 2 ) && (map.getEdgeLocations()[i] == 1))
                return false;
            else if(edges[i].getInfo() ==  1 && map.getEdgeLocations()[i] != 1){
                return false;
            }
        }
        for(int i = 0; i < horizontalRectangles.length; i++){
            if(horizontalRectangles[i].getInfo() != map.getHorizontalRectangleLocations()[i])
                return false;
        }
        for(int i = 0; i < verticalRectangles.length; i++){
            if(verticalRectangles[i].getInfo() != map.getVerticalRectangleLocations()[i])
                return false;
        }
        return true;
    }
    public Rectangle[] getHorizontalRectangles() {
        return horizontalRectangles;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public Rectangle[] getVerticalRectangles() {
        return verticalRectangles;
    }

    public Square[] getSquares() {
        return squares;
    }

    public void draw(Graphics g)
    {
        for(int i = 0; i < 26; i++)
            edges[i].draw(g);
        for(int i = 0; i < 21; i++)
            horizontalRectangles[i].draw(g);
        for(int i = 0; i < 20; i++)
            verticalRectangles[i].draw(g);
        for(int i = 0; i < 16; i++)
            squares[i].draw(g);
        if (mode == 0 || mode == 2 || mode ==3 || mode == 4) {
            for (int i = 0; i < gameUnits.size(); i++){
                gameUnits.get(i).draw(g);
            }
            if(castle != null){
                for (int i = 0; i < castle.length; i++) {
                    castle[i].draw(g);
                }
                g.setColor(Color.BLUE);
                if (castle[0].getY() == castle[1].getY()) {
                    g.fillRect(castle[0].getX() + castle[0].getRadius() / 4, castle[0].getY() + castle[0].getRadius() / 4, castle[0].getRadius() + castle[0].getRadius() / 2, castle[0].getRadius() / 2);
                } else if (castle[0].getX() == castle[1].getX()) {
                    g.fillRect(castle[0].getX() + castle[0].getRadius() / 4, castle[0].getY() + castle[0].getRadius() / 4, castle[0].getRadius() / 2, castle[0].getRadius() + castle[0].getRadius() / 2);
                }
            }

        }
        if(mode == 1){
            fixedUnits[0].draw(g);
            fixedUnits[1].draw(g);
            g.setColor(Color.BLUE);
            if(castle == null){
                castle1Dev[0].draw(g);
                castle1Dev[1].draw(g);
                castle2Dev[0].draw(g);
                castle2Dev[1].draw(g);
                if (castle1Dev[0].getY() == castle1Dev[1].getY()) {
                    g.fillRect(castle1Dev[0].getX() + castle1Dev[0].getRadius() / 4, castle1Dev[0].getY() + castle1Dev[0].getRadius() / 4, castle1Dev[0].getRadius() + castle1Dev[0].getRadius() / 2, castle1Dev[0].getRadius() / 2);
                } else if (castle1Dev[0].getX() == castle1Dev[1].getX()) {
                    g.fillRect(castle1Dev[0].getX() + castle1Dev[0].getRadius() / 4, castle1Dev[0].getY() + castle1Dev[0].getRadius() / 4, castle1Dev[0].getRadius() / 2, castle1Dev[0].getRadius() + castle1Dev[0].getRadius() / 2);
                }
                if (castle2Dev[0].getY() == castle2Dev[1].getY()) {
                    g.fillRect(castle2Dev[0].getX() + castle2Dev[0].getRadius() / 4, castle2Dev[0].getY() + castle2Dev[0].getRadius() / 4, castle2Dev[0].getRadius() + castle2Dev[0].getRadius() / 2, castle2Dev[0].getRadius() / 2);
                } else if (castle2Dev[0].getX() == castle2Dev[1].getX()) {
                    g.fillRect(castle2Dev[0].getX() + castle2Dev[0].getRadius() / 4, castle2Dev[0].getY() + castle2Dev[0].getRadius() / 4, castle2Dev[0].getRadius() / 2, castle2Dev[0].getRadius() + castle2Dev[0].getRadius() / 2);
                }
            }
            else{
                for (int i = 0; i < castle.length; i++) {
                    castle[i].draw(g);

                }
                g.setColor(Color.BLUE);
                if (castle[0].getY() == castle[1].getY()) {
                    g.fillRect(castle[0].getX() + castle[0].getRadius() / 4, castle[0].getY() + castle[0].getRadius() / 4, castle[0].getRadius() + castle[0].getRadius() / 2, castle[0].getRadius() / 2);
                } else if (castle[0].getX() == castle[1].getX()) {
                    g.fillRect(castle[0].getX() + castle[0].getRadius() / 4, castle[0].getY() + castle[0].getRadius() / 4, castle[0].getRadius() / 2, castle[0].getRadius() + castle[0].getRadius() / 2);
                }
            }

            for (int i = 0; i < gameUnits.size(); i++){
                gameUnits.get(i).draw(g);
            }

        }


    }
    public GameUnit createUnit(int x, int y, boolean isEnemy){
        GameUnit temp = new GameUnit(x,y,squareHeight,isEnemy,theme);
        temp.setIsPlaced(false);
        return temp;
    }

    /**
     * This method creates an empty gameboard with related methods.
     */
    public void createEmptyGameBoard()
    {
        createEdges();
        createHorizontalRectangles();
        createVerticalRectangles();
        createSquares();
    }
    /**
     * This method creates units for the developer mode.
     */
    public void createUnitsForDeveloper(){
        int temp = 0;
        castle1Dev = new GameUnit[2];
        castle2Dev = new GameUnit[2];
        fixedUnits = new GameUnit[2];
        GameUnit fixedFriendlyUnit = new GameUnit(1100,0,squareHeight, false,theme);
        GameUnit fixedHostileUnit = new GameUnit(1100,100,squareHeight, true,theme);
        fixedUnits[0] = fixedFriendlyUnit;
        fixedUnits[1] = fixedHostileUnit;
        GameUnit fixedCastle1 = new GameUnit(1100, 200, squareHeight,false,theme);
        GameUnit fixedCastle2 = new GameUnit(1100,280, squareHeight,false,theme);
        GameUnit fixedCastle3 = new GameUnit(1050,380,squareHeight,false,theme);
        GameUnit fixedCastle4 = new GameUnit(1130,380,squareHeight,false,theme);
        fixedCastle1.setIsCastle(true);
        fixedCastle2.setIsCastle(true);
        fixedCastle1.setIsHorizontalCastle(false);
        fixedCastle2.setIsHorizontalCastle(false);
        fixedCastle3.setIsCastle(true);
        fixedCastle4.setIsCastle(true);
        fixedCastle3.setIsHorizontalCastle(true);
        fixedCastle4.setIsHorizontalCastle(true);
        castle1Dev[0] = fixedCastle1;
        castle1Dev[1] = fixedCastle2;
        castle2Dev[0] = fixedCastle3;
        castle2Dev[1] = fixedCastle4;

        /*
        for (int i = 0; i < map.getSquareLocations().length; i++) {
            squares[i].setInfo(map.getSquareLocations()[i]);
            if (map.getSquareLocations()[i] == 1) {
                GameUnit unit = new GameUnit(squares[i].getX(), squares[i].getY(), squareHeight, false, theme);
                unit.setInfo(friendlyUnitCount);
                friendlyUnitCount++;
                gameUnits.add(unit);
            }
            else if (map.getSquareLocations()[i] == 2) {
                GameUnit unit = new GameUnit(squares[i].getX(), squares[i].getY(), squareHeight, true, theme);
                unit.setInfo(hostileUnitCount);
                hostileUnitCount++;
                gameUnits.add(unit);
            }
            else if (map.getSquareLocations()[i] == 3) {
                castle[temp] = new GameUnit(squares[i].getX(), squares[i].getY(), squareHeight, false, theme);
                castle[temp].setIsCastle(true);
                temp++;
            }
        }
        */
    }
    /**
     * This method creates empty edges for gameboard.
     */
    public void createEdges()
    {
        int tempX = mostLeftX + edgeHeight + rectangleWidth;
        for(int i = 0; i < 4; i++)
        {
            edges[i] = new Edge(tempX, mostUpY, edgeWidth,edgeHeight);
            tempX += edgeHeight + rectangleWidth;
        }
        tempX = mostLeftX;
        int tempY = mostUpY +edgeHeight + rectangleWidth;
        int tempCount = 0;
        for(int i = 4; i <22; i++)
        {
            edges[i] = new Edge(tempX,tempY,edgeWidth,edgeHeight);
            tempX += edgeHeight + rectangleWidth;
            tempCount++;
            if(tempCount > 5)
            {
                tempCount = 0;
                tempX = mostLeftX;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeHeight + rectangleWidth;
        for(int i = 22; i < 26; i++)
        {
            edges[i] = new Edge(tempX,tempY,edgeWidth,edgeHeight);
            tempX += edgeHeight + rectangleWidth;
        }
    }
    /**
     * This method creates empty horizontalRectangles for gameboard.
     */
    public void createHorizontalRectangles()
    {
        int tempX = mostLeftX + edgeWidth + edgeWidth + rectangleWidth;
        int tempY = mostUpY;
        int tempCount = 0;
        for(int i = 0; i < 3; i++)
        {
            horizontalRectangles[i] = new Rectangle(tempX,tempY,rectangleWidth,rectangleHeight);
            tempX += edgeWidth + rectangleWidth;
        }
        tempX = mostLeftX + edgeWidth;
        tempY += edgeHeight + rectangleWidth;
        for(int i = 3; i < 18; i++)
        {
            horizontalRectangles[i] = new Rectangle(tempX,tempY,rectangleWidth,rectangleHeight);
            tempX += edgeHeight + rectangleWidth;
            tempCount++;
            if(tempCount > 4)
            {
                tempCount = 0;
                tempX = mostLeftX + edgeWidth;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeWidth + edgeWidth + rectangleWidth;
        for(int i = 18; i < 21; i++)
        {
            horizontalRectangles[i] = new Rectangle(tempX, tempY, rectangleWidth, rectangleHeight);
            tempX += edgeHeight + rectangleWidth;
        }
    }
    /**
     * This method creates empty verticalRectangles for gameboard.
     */
    public void createVerticalRectangles()
    {
        int tempX = mostLeftX + edgeHeight + rectangleWidth;
        int tempY = mostUpY + edgeHeight;
        int tempCount = 0;
        for(int i = 0; i < 4; i++)
        {
            verticalRectangles[i] = new Rectangle(tempX,tempY,rectangleHeight,rectangleWidth);
            tempX += rectangleHeight + squareWidth;
        }
        tempX = mostLeftX;
        tempY += edgeHeight + rectangleWidth;
        for(int i = 4; i < 16; i++)
        {
            verticalRectangles[i] = new Rectangle(tempX,tempY,rectangleHeight,rectangleWidth);
            tempX += rectangleHeight + squareWidth;
            tempCount++;
            if(tempCount > 5)
            {
                tempCount = 0;
                tempX = mostLeftX;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeHeight + rectangleWidth;
        for(int i = 16; i < 20; i++)
        {
            verticalRectangles[i] = new Rectangle(tempX,tempY,rectangleHeight,rectangleWidth);
            tempX += rectangleHeight + squareWidth;
        }
    }
    /**
     * This method creates empty squares for gameboard.
     */
    public void createSquares()
    {
        int tempX = mostLeftX + edgeHeight + rectangleWidth + rectangleHeight;
        int tempY = mostUpY + edgeHeight;
        int tempCount = 0;
        for(int i = 0; i < 3; i++)
        {
            squares[i] = new Square(tempX,tempY,squareWidth,squareHeight);
            tempX += rectangleHeight + squareWidth;
        }
        tempX = mostLeftX + rectangleHeight;
        tempY += edgeHeight + rectangleWidth;
        for(int i = 3; i < 13; i++)
        {
            squares[i] = new Square(tempX,tempY,squareWidth,squareHeight);
            tempX += rectangleHeight + squareWidth;
            tempCount++;
            if(tempCount > 4)
            {
                tempCount = 0;
                tempX = mostLeftX + rectangleHeight;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeHeight + rectangleWidth + rectangleHeight;
        for(int i = 13; i < 16; i++)
        {
            squares[i] = new Square(tempX ,tempY,squareWidth,squareHeight);
            tempX += rectangleHeight + squareWidth;
        }
    }
}
