package TheWall;
/**
 * @author Erdem Ege Marasl�
 * @author Ensar Kaya
 */
/**
 * For squareLocations
 * 0 = empty
 * 1 = blueKnights
 * 2 = redKnights
 * 3 = castle
 * For Edge
 * 0 = empty
 * 1 = non empty
 * For Rectangles
 * 0 = empty
 * 1 = wall
 * 2 = castle wall
 */

public class Levels {
    Map [] levels = new Map[64];
    //int [] squareLocations; // 16
    //int [] edgeLocations; // 26
    //int [] horizontalRectangleLocations; // 20
    //int [] verticalRectangleLocations; // 21
    public Levels(){        int [] squareLocations = {3,3,0,
            0,0,0,0,0,
            0,0,1,0,1,
              0,0,1};
int [] edgeLocations = {0,0,1,0,
            0,1,0,0,1,0,
            0,0,0,0,0,0,
            0,0,0,0,0,1,
            0,0,0,0};
int [] horizontalRectangleLocations = {1,1,0,
                        0,1,1,1,0,
                        0,0,1,0,1,
                        0,0,1,0,1,
                          0,0,1};
int [] verticalRectangleLocations = {1,2,1,0,
                        0,0,0,1,1,0,
                        0,0,1,0,0,1,
                        0,0,1,1};
levels[0] = new Map(squareLocations,edgeLocations,horizontalRectangleLocations,verticalRectangleLocations);
int [] squareLocations1 = {0,0,1,
            0,0,0,2,0,
            0,1,0,3,2,
              0,2,3};
int [] edgeLocations1 = {0,1,0,0,
            0,1,0,0,0,0,
            0,0,0,0,0,0,
            0,1,0,0,0,0,
            0,0,1,0};
int [] horizontalRectangleLocations1 = {0,1,1,
                            0,1,0,1,0,
                            0,1,0,1,0,
                            0,1,1,2,0,
                            0,0,1};
int [] verticalRectangleLocations1 = {0,1,0,1,
                        0,1,0,1,0,0,
                        0,1,1,0,1,0,
                          0,0,1,1};
levels[1] = new Map(squareLocations1,edgeLocations1,horizontalRectangleLocations1,verticalRectangleLocations1);
int [] squareLocations2 = {0,3,0,
             1,0,3,0,1,
             0,0,0,0,0,
	           0,0,0};
int [] edgeLocations2 = {1,0,1,0,
	        1,0,0,0,0,1,
	        0,0,0,0,0,0,
	        0,0,0,0,0,0,
	        0,0,0,0};
int [] horizontalRectangleLocations2={1,1,0,
                        1,1,2,1,1,
                        1,0,1,0,1,
                        0,0,0,0,0,
                          0,0,0};
int [] verticalRectangleLocations2 = {1,1,1,0,
                        1,1,1,1,1,1,
                        0,0,0,0,0,0,
                        0,0,0,0};
levels[2] = new Map(squareLocations2,edgeLocations2,horizontalRectangleLocations2,verticalRectangleLocations2);//level-19
int [] squareLocations3 = {0,1,0,
				        0,0,0,0,0,
				        0,3,0,1,0,
				          3,0,0};
int [] edgeLocations3 = {0,1,0,0,
				       0,0,0,0,0,0,
				       0,0,0,0,0,0,
				       1,0,0,0,1,0,
				       1,0,0,0};
int [] horizontalRectangleLocations3={0,1,0,
				                   0,1,0,0,0,
				                   1,0,1,1,0,
				                   1,2,0,1,0,
				                     1,1,0};
int [] verticalRectangleLocations3 = {0,1,1,0,
				                   0,1,1,1,0,0,
				                   1,0,0,0,1,0,
				                   1,0,1,0};
levels[3] = new Map(squareLocations3,edgeLocations3,horizontalRectangleLocations3,verticalRectangleLocations3);//level-20
int [] squareLocations4 = {1,3,0,
				        1,2,3,0,0,
				        0,0,1,0,0,
				          0,0,0};
int [] edgeLocations4 = {1,0,1,0,
				       1,0,0,0,0,0,
				       0,0,0,0,0,0,
				       0,0,0,1,0,0,
				       0,0,0,0};
int [] horizontalRectangleLocations4={1,1,0,
				                   1,1,2,1,0,
				                   1,0,1,0,0,
				                   0,0,1,0,0,
				                     0,0,0};
int [] verticalRectangleLocations4 = {1,1,1,0,
				                   1,1,1,1,1,0,
				                   0,0,1,1,0,0,
				                   0,0,0,0};
levels[4] = new Map(squareLocations4,edgeLocations4,horizontalRectangleLocations4,verticalRectangleLocations4);//level-21
int [] squareLocations5 = {3,3,0,
				        2,0,0,0,0,
				        2,1,0,1,0,
				          0,2,2};
int [] edgeLocations5 = {0,0,1,0,
				       0,1,0,0,1,0,
				       0,1,0,0,0,0,
				       0,0,0,0,0,0,
				       0,0,0,0};
int [] horizontalRectangleLocations5={
					 1,1,0,
                   0,1,1,1,0,
                   0,1,1,0,1,
                   0,1,0,1,0,
                     0,0,0};
int [] verticalRectangleLocations5 = {
		  			1,2,1,0,
                   0,0,1,0,1,0,
                   0,1,1,1,1,0,
                   0,0,0,0};
levels[5] = new Map(squareLocations5,edgeLocations5,horizontalRectangleLocations5,verticalRectangleLocations5);//level-22
int [] squareLocations6 = {3,3,1,
        0,2,0,0,0,
        2,0,0,2,0,
          0,2,0};
int [] edgeLocations6 = {0,0,0,1,
       0,1,0,0,0,1,
       0,0,0,0,0,0,
       0,0,0,0,1,0,
       0,0,0,0};
int [] horizontalRectangleLocations6={
	 1,1,1,
   0,1,1,0,1,
   0,0,1,1,0,
   0,0,0,1,
     0,0,0};
int [] verticalRectangleLocations6= {
		1,2,1,1,
   0,0,1,1,0,1,
   0,0,0,1,1,1,
   0,0,0,0};
levels[6] = new Map(squareLocations6,edgeLocations6,horizontalRectangleLocations6,verticalRectangleLocations6);//level-23
int [] squareLocations7 = {2,0,2,
        0,0,1,3,2,
        0,0,2,3,0,
          0,1,0};
int [] edgeLocations7 = {1,0,1,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
       0,0,0,0,0,1,
       0,0,0,0};
int [] horizontalRectangleLocations7={
	 1,1,0,
   0,0,0,1,0,
   0,0,1,2,1,
   0,0,1,0,1,
     0,1,1};
int [] verticalRectangleLocations7= {
		1,1,1,0,
   0,0,1,0,1,0,
   0,0,0,1,0,1,
   0,1,0,1};
levels[7] = new Map(squareLocations7,edgeLocations7,horizontalRectangleLocations7,verticalRectangleLocations7);//level-24
int [] squareLocations8= {0,0,1,
        0,0,2,3,0,
        0,1,0,3,0,
          0,0,0};
int [] edgeLocations8= {0,0,0,1,
       0,0,0,0,0,0,
       0,0,0,0,0,0,
       0,1,0,0,0,1,
       0,0,0,1};
int [] horizontalRectangleLocations8={
	 0,0,1,
   0,0,1,0,1,
   0,1,1,2,0,
   0,1,1,0,1,
     0,0,1};
int [] verticalRectangleLocations8={
		0,0,1,1,
   0,0,0,1,0,1,
   0,1,1,0,0,1,
   0,0,1,1};
levels[8] = new Map(squareLocations8,edgeLocations8,horizontalRectangleLocations8,verticalRectangleLocations8);//level-25
int [] squareLocations9= {0,0,0,
        0,1,2,1,2,
        0,0,0,0,2,
          0,3,3};
int [] edgeLocations9={0,0,0,0,
       0,0,0,0,0,0,
       0,0,0,0,1,0,
       0,1,0,0,1,0,
       0,1,0,0};
int [] horizontalRectangleLocations9={
	 0,0,0,
   0,1,0,1,0,
   1,0,1,1,0,
   0,1,1,1,0,
     0,1,1};
int [] verticalRectangleLocations9={
		0,0,0,0,
   0,1,1,1,1,0,
   0,1,0,1,0,0,
   0,1,2,1};
levels[9] = new Map(squareLocations9,edgeLocations9,horizontalRectangleLocations9,verticalRectangleLocations9);//level-26
int [] squareLocations10= {2,2,2,
        1,0,0,1,0,
        0,3,0,0,0,
          3,2,1};
int [] edgeLocations10={0,0,0,1,
       0,0,0,0,0,0,
       0,0,0,0,1,0,
       0,0,0,1,0,0,
       1,0,0,0};
int [] horizontalRectangleLocations10={
	 0,0,1,
   1,0,1,1,0,
   0,1,0,1,0,
   1,2,1,0,0,
     1,0,0};
int [] verticalRectangleLocations10={
		0,0,0,1,
   1,1,1,0,1,0,
   1,0,0,1,0,0,
   1,1,0,0};
levels[10] = new Map(squareLocations10,edgeLocations10,horizontalRectangleLocations10,verticalRectangleLocations10);//level-27
int [] squareLocations11= {0,0,0,
        0,3,3,0,0,
        0,2,0,0,1,
          0,1,0};
int [] edgeLocations11={0,0,1,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
       0,0,0,0,0,1,
       0,1,0,0};
int [] horizontalRectangleLocations11={
	 1,1,0,
   0,1,0,1,0,
   0,1,0,0,1,
   0,0,1,0,1,
     0,1,1};
int [] verticalRectangleLocations11={
		0,1,1,0,
   0,1,2,0,1,0,
   0,0,1,0,0,1,
   0,1,0,1};
levels[11] = new Map(squareLocations11,edgeLocations11,horizontalRectangleLocations11,verticalRectangleLocations11);//level-28
int [] squareLocations12= {3,0,0,
        0,3,0,0,1,
        0,0,0,0,1,
          0,0,0};
int [] edgeLocations12={0,0,0,1,
       0,0,0,0,0,1,
       0,0,1,0,0,0,
       0,0,0,0,1,0,
       0,0,0,0};
int [] horizontalRectangleLocations12={
	 1,0,1,
   1,2,1,0,1,
   0,1,0,1,0,
   0,0,0,0,1,
     0,0,0};
int [] verticalRectangleLocations12={
		1,1,1,1,
   0,1,1,1,0,1,
   0,0,0,0,1,1,
   0,0,0,0};
levels[12] = new Map(squareLocations12,edgeLocations12,horizontalRectangleLocations12,verticalRectangleLocations12);//level-29
int [] squareLocations13= {2,2,3,
        0,1,2,3,0,
        0,2,0,0,1,
          0,0,0};
int [] edgeLocations13={0,0,0,1,
       0,1,0,0,0,0,
       1,0,0,0,0,0,
       0,0,0,0,0,1,
       0,0,0,0};
int [] horizontalRectangleLocations13={
	 0,0,1,
   0,1,1,2,1,
   1,1,0,1,0,
   0,0,0,0,1,
     0,0,0};
int [] verticalRectangleLocations13={
		0,0,1,1,
   0,1,1,1,1,1,
   1,0,0,0,1,1,
   0,0,0,0};
levels[13] = new Map(squareLocations13,edgeLocations13,horizontalRectangleLocations13,verticalRectangleLocations13);//level-30
int [] squareLocations14= {0,0,0,
        0,1,2,3,0,
        0,0,1,3,0,
          0,2,0};
int [] edgeLocations14={0,0,0,0,
       0,0,0,0,0,0,
       1,0,0,0,0,1,
       0,1,0,0,0,0,
       0,1,0,0};
int [] horizontalRectangleLocations14={
	 0,0,0,
   0,1,0,1,1,
   1,0,1,2,1,
   0,1,1,1,0,
     0,1,0};
int [] verticalRectangleLocations14={
		0,0,0,0,
   1,1,1,1,0,1,
   0,1,0,0,1,0,
   0,1,0,0};
levels[14] = new Map(squareLocations14,edgeLocations14,horizontalRectangleLocations14,verticalRectangleLocations14);//level-31
int [] squareLocations15= {
	  0,2,0,
        1,1,0,0,0,
        2,2,3,0,0,
          1,3,0};
int [] edgeLocations15={0,0,0,0,
       1,0,1,0,0,0,
       0,0,0,1,0,0,
       0,0,0,0,0,0,
       0,0,1,0};
int [] horizontalRectangleLocations15={
     1,0,0,
   1,1,0,0,0,
   1,1,1,0,0,
   0,1,2,0,0,
     1,1,0};
int [] verticalRectangleLocations15={
    1,0,0,0,
   1,1,1,0,0,0,
   0,0,1,1,0,0,
   1,1,1,0};
levels[15] = new Map(squareLocations15,edgeLocations15,horizontalRectangleLocations15,verticalRectangleLocations15);//level-32
int [] squareLocations16= {
	  0,3,0,
        1,2,3,0,0,
        0,0,0,1,0,
          0,0,0};
int [] edgeLocations16={1,0,1,0,
       1,0,0,0,0,0,
       0,0,0,0,0,0,
       0,0,0,0,1,0,
       0,0,0,0};
int [] horizontalRectangleLocations16={
     1,1,0,
   1,1,2,1,0,
   1,0,1,0,0,
   0,0,0,1,0,
     0,0,0};
int [] verticalRectangleLocations16={
    1,1,1,0,
   1,1,1,1,1,0,
   0,0,0,1,1,0,
   0,0,0,0};
levels[16] = new Map(squareLocations16,edgeLocations16,horizontalRectangleLocations16,verticalRectangleLocations16);//level-33
int [] squareLocations17= {
	  2,1,0,
        0,0,3,0,0,
        0,2,3,0,1,
          0,1,0};
int [] edgeLocations17={0,0,1,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
       0,0,0,0,0,1,
       0,1,0,0};
int [] horizontalRectangleLocations17={
     1,1,0,
   0,1,0,1,0,
   0,1,2,0,1,
   0,0,1,0,1,
     0,1,1};
int [] verticalRectangleLocations17={
    0,1,1,0,
   0,1,0,0,1,0,
   0,0,1,0,0,1,
   0,1,0,1};
levels[17] = new Map(squareLocations17,edgeLocations17,horizontalRectangleLocations17,verticalRectangleLocations17);//level-34
    }

    public Map[] getLevels() {
        return levels;
    }
}
