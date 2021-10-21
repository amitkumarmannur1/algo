package facebook;

public class MergeIntervalsWithoutSort {

    public int[][] merge(int[][] intervals) {
        int nMerged = 1;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int m0 = interval[0];
            int m1 = interval[1];
            int nRemain = 0;
            for (int j = 0; j < nMerged; j++) {
                int[] candidate = intervals[j];
                int c0 = candidate[0];
                int c1 = candidate[1];
                if (c1 < m0) {
                    nRemain++;
                } else if (m1 < c0) {
                    intervals[nRemain++] = interval;
                    interval = candidate;
                } else {
                    if (c0 < m0) interval[0] = m0 = c0;
                    if (c1 > m1) interval[1] = m1 = c1;
                }
            }
            intervals[nRemain++] = interval;
            nMerged = nRemain;
        }

        int[][] result = new int[nMerged][];
        System.arraycopy(intervals, 0, result, 0, nMerged);
        return result;
    }
}
