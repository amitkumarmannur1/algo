package salesforce;

public class OverlappingRectangule {
    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[] {0,0,2,2},new int[]{1,1,3,3}));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
        //       Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
        return  rec1[2] > rec2[0] &&// left
                rec1[3] > rec2[1] && // bottom
                rec1[0] < rec2[2] &&   // right
                rec1[1] < rec2[3];  // top
      //rec1   //[x1, y1, x2, y2]
      //rec1  // 0    1   2   3
      //rec2  //[x1, y1, x2, y2]
     // rec2  // 0    1   2   3
    }
}
