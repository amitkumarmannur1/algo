package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        mergeIntervals.merge(new int[][]{{1,5},{2,7},{9,12},{11,11}});
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a, b) -> a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1 ; i<intervals.length; i++) {
            int[] lastInterval = list.get(list.size()-1);
            int[] currentInterval = intervals[i];
            if(lastInterval[1] < currentInterval[0]) //no overlap
                list.add(currentInterval);
            else
                lastInterval[1]  = Math.max(lastInterval[1],currentInterval[1]);
        }

        list.forEach(a-> System.out.println(Arrays.toString(a)));
        return list.toArray(new int[list.size()][2]);
    }
}
