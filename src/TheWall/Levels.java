package TheWall;
/**
 * @author Erdem Ege Marasli
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
 * This class contains levels for classical mode, chalange mode and story mode.
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
int [] squareLocations18= {
	  1,0,0,
        0,0,2,0,0,
        0,3,3,1,0,
          0,1,0};
int [] edgeLocations18={1,0,0,0,
       0,0,0,0,0,0,
       0,0,0,0,0,0,
       1,0,0,0,1,0,
         1,0,0,0};
int [] horizontalRectangleLocations18={
     1,0,0,
   0,1,0,0,0,
   1,0,1,1,0,
   1,0,0,1,0,
     1,1,0};
int [] verticalRectangleLocations18={
    1,1,0,0,
   0,1,1,1,0,0,
   1,0,2,0,1,0,
   1,0,1,0};
levels[18] = new Map(squareLocations18,edgeLocations18,horizontalRectangleLocations18,verticalRectangleLocations18);//level-35
int [] squareLocations19= {
	  1,3,3,
        0,0,0,0,0,
        0,0,1,0,0,
          0,0,0};
int [] edgeLocations19={1,0,0,0,
       1,0,1,0,0,0,
       0,0,0,0,0,0,
       0,0,1,0,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations19={
     1,1,1,
   1,0,1,1,0,
   0,1,0,1,0,
   0,0,1,0,0,
     0,0,0};
int [] verticalRectangleLocations19={
    1,1,2,0,
   1,1,0,1,0,0,
   0,0,1,1,1,0,
   0,0,0,0};
levels[19] = new Map(squareLocations19,edgeLocations19,horizontalRectangleLocations19,verticalRectangleLocations19);//level-36
int [] squareLocations20= {
	  2,1,2,
        0,0,0,0,0,
        0,0,3,0,2,
          0,3,1};
int [] edgeLocations20={0,0,0,0,
       0,1,0,0,0,0,
       0,0,0,0,0,0,
       0,1,0,0,0,0,
         0,1,0,1};
int [] horizontalRectangleLocations20={
     0,1,0,
   0,1,0,1,0,
   0,1,0,1,0,
   0,1,2,1,0,
     0,1,1};
int [] verticalRectangleLocations20={
    0,1,1,0,
   0,1,0,0,1,0,
   0,1,0,1,0,0,
   0,1,1,1};
levels[20] = new Map(squareLocations20,edgeLocations20,horizontalRectangleLocations20,verticalRectangleLocations20);//level-37
int [] squareLocations21= {
	  0,0,0,
        0,2,2,0,0,
        0,1,3,1,0,
          2,3,0};
int [] edgeLocations21={0,0,0,0,
       0,0,1,0,0,0,
       0,0,0,0,0,0,
       0,0,0,0,0,1,
         0,1,0,1};
int [] horizontalRectangleLocations21={
     0,0,0,
   0,1,0,1,0,
   0,1,1,0,1,
   0,1,2,0,1,
     0,1,1};
int [] verticalRectangleLocations21={
    0,0,0,0,
   0,0,1,1,1,1,
   0,1,0,0,0,1,
   0,1,1,1};
levels[21] = new Map(squareLocations21,edgeLocations21,horizontalRectangleLocations21,verticalRectangleLocations21);//level-38
int [] squareLocations22= {
	  1,2,2,
        0,2,0,1,0,
        0,3,3,2,0,
          0,0,0};
int [] edgeLocations22={
	 0,1,0,1,
       0,0,0,0,0,0,
       0,0,0,0,1,0,
       0,0,0,1,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations22={
     1,0,1,
   0,1,1,1,0,
   0,1,0,1,0,
   0,1,1,0,1,
     0,0,0};
int [] verticalRectangleLocations22={
    1,1,0,1,
   0,0,1,1,1,0,
   0,1,2,1,0,0,
   0,1,0,0};
levels[22] = new Map(squareLocations22,edgeLocations22,horizontalRectangleLocations22,verticalRectangleLocations22);//level-39
int [] squareLocations23= {
	  0,3,3,
        0,1,0,2,0,
        0,0,0,1,0,
          0,2,2};
int [] edgeLocations23={
	 0,1,0,0,
       0,1,0,0,1,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations23={
     0,1,1,
   0,1,0,1,0,
   0,1,1,1,0,
   1,0,1,1,0,
     0,0,0};
int [] verticalRectangleLocations23={
    0,1,2,1,
   0,1,0,1,0,0,
   0,1,1,1,1,0,
   0,0,0,0};
levels[23] = new Map(squareLocations23,edgeLocations23,horizontalRectangleLocations23,verticalRectangleLocations23);//level-40
int [] squareLocations24= {
	  0,0,0,
        0,0,1,0,0,
        3,3,0,0,0,
          1,0,1};
int [] edgeLocations24={
	 0,0,0,0,
       0,0,0,1,0,0,
       1,0,0,0,1,0,
       0,0,0,0,0,0,
         1,0,0,0};
int [] horizontalRectangleLocations24={
     0,0,0,
   0,1,1,0,0,
   1,0,0,1,0,
   1,1,1,0,1,
     1,0,1};
int [] verticalRectangleLocations24={
    0,0,0,0,
   0,1,0,1,0,0,
   1,2,0,0,1,0,
   1,1,1,1};
levels[24] = new Map(squareLocations24,edgeLocations24,horizontalRectangleLocations24,verticalRectangleLocations24);//level-41
int [] squareLocations25= {
	  0,0,0,
        0,0,0,0,1,
        0,0,3,2,0,
          0,3,1};
int [] edgeLocations25={
	 0,0,0,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
       0,0,0,0,0,1,
         0,1,0,1};
int [] horizontalRectangleLocations25={
     0,0,0,
   0,0,0,0,1,
   0,0,1,0,1,
   0,1,2,1,1,
     0,1,1};
int [] verticalRectangleLocations25={
    0,0,0,0,
   0,0,0,0,1,1,
   0,1,1,1,1,1,
   0,1,1,1};
levels[25] = new Map(squareLocations25,edgeLocations25,horizontalRectangleLocations25,verticalRectangleLocations25);//level-42
		    
int [] squareLocations26={
	  2,1,0,
        0,3,3,2,0,
        0,0,0,1,0,
          0,2,2};
int [] edgeLocations26={
	 0,1,0,0,
       0,1,0,0,1,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
         0,0,0,1};
int [] horizontalRectangleLocations26={
     0,1,1,
   0,1,0,1,0,
   0,1,1,1,0,
   1,0,1,1,0,
     0,0,0};
int [] verticalRectangleLocations26={
    0,1,0,1,
   0,1,2,1,0,0,
   0,1,1,1,1,0,
   0,0,0,0};
levels[26] = new Map(squareLocations26,edgeLocations26,horizontalRectangleLocations26,verticalRectangleLocations26);//level-43
		    
int [] squareLocations27= {
	  1,3,0,
        0,2,3,0,0,
        1,2,0,0,0,
          0,0,0};
int [] edgeLocations27={
	 1,0,1,0,
       1,0,0,0,0,0,
       0,0,0,0,0,0,
       0,1,0,0,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations27={
     1,1,0,
   1,1,2,1,0,
   1,0,1,0,0,
   1,0,0,0,0,
     0,0,0};
int [] verticalRectangleLocations27={
    1,1,1,0,
   1,1,1,1,1,0,
   1,1,0,0,0,0,
   0,0,0,0};
levels[27] = new Map(squareLocations27,edgeLocations27,horizontalRectangleLocations27,verticalRectangleLocations27);//level-44
int [] squareLocations28= {
	  1,2,0,
        2,0,0,1,0,
        1,3,3,2,0,
          0,0,0};
int [] edgeLocations28={
	 0,1,0,0,
       0,0,0,0,1,0,
       0,0,0,0,0,0,
       0,0,0,1,0,0,
         0,1,0,0};
int [] horizontalRectangleLocations28={
     1,0,0,
   1,0,1,1,0,
   1,0,0,1,0,
   1,0,1,0,0,
     1,0,0};
int [] verticalRectangleLocations28={
    1,1,0,0,
   0,1,0,1,1,0,
   1,0,2,1,0,0,
   1,1,0,0};
levels[28] = new Map(squareLocations28,edgeLocations28,horizontalRectangleLocations28,verticalRectangleLocations28);//level-45
int [] squareLocations29= {
	  0,0,0,
        0,0,0,2,1,
        0,0,1,3,3,
          0,0,2};
int [] edgeLocations29={
	 0,0,0,1,
       0,0,0,0,0,1,
       0,0,0,0,0,0,
       0,0,1,0,0,1,
         0,0,0,0};
int [] horizontalRectangleLocations29={
     0,0,1,
   0,0,0,1,1,
   0,0,1,1,1,
   0,0,1,1,1,
     0,0,1};
int [] verticalRectangleLocations29={
    0,0,1,1,
   0,0,0,0,1,1,
   0,0,1,1,2,1,
   0,0,0,1};
levels[29] = new Map(squareLocations29,edgeLocations29,horizontalRectangleLocations29,verticalRectangleLocations29);//level-46
int [] squareLocations30= {
	  1,1,0,
        2,0,0,0,0,
        3,3,2,2,0,
          0,0,0};
int [] edgeLocations30={
	 1,0,1,0,
       0,0,0,0,1,0,
       0,0,0,1,0,0,
       0,0,0,0,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations30={
     1,1,0,
   1,0,1,1,0,
   1,0,1,0,0,
   1,1,0,0,0,
     0,0,0};
int [] verticalRectangleLocations30={
    1,1,1,0,
   0,1,0,1,1,0,
   1,2,1,0,0,0,
   1,0,0,0};
levels[30] = new Map(squareLocations30,edgeLocations30,horizontalRectangleLocations30,verticalRectangleLocations30);//level-47
int [] squareLocations31= {
	  2,2,0,
        0,1,0,0,0,
        3,3,0,1,0,
          0,2,2};
int [] edgeLocations31={
	 0,0,1,0,
       0,0,0,0,1,0,
       1,0,0,0,0,1,
       0,0,0,0,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations31={
     0,1,0,
   0,1,1,1,0,
   1,0,1,0,1,
   1,1,0,1,0,
     0,0,0};
int [] verticalRectangleLocations31={
    0,0,1,0,
   0,1,0,0,1,0,
   1,2,1,1,1,1,
   0,0,0,0};
levels[31] = new Map(squareLocations31,edgeLocations31,horizontalRectangleLocations31,verticalRectangleLocations31);//level-48

int [] squareLocations32= {
	  0,0,1,
        1,3,3,2,0,
        0,0,0,0,0,
          0,0,0};
int [] edgeLocations32={
	 0,0,0,0,
       0,0,0,0,1,0,
       1,0,0,0,0,0,
       0,1,0,1,0,0,
         0,0,0,0};
int [] horizontalRectangleLocations32={
     1,0,1,
   1,0,1,1,0,
   1,0,1,0,0,
   0,1,1,0,0,
     0,0,0};
int [] verticalRectangleLocations32={
    1,1,1,1,
   1,0,2,1,0,0,
   0,1,1,1,0,0,
   0,0,0,0};
levels[32] = new Map(squareLocations32,edgeLocations32,horizontalRectangleLocations32,verticalRectangleLocations32);//level-49		    
    }
    public Map[] getLevels() {
        return levels;
    }
}
