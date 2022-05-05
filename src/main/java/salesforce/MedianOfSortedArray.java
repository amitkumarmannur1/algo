package salesforce;

public class MedianOfSortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4},new int[]{ 5,6}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int m = (nums1.length + nums2.length)/2;
        boolean isEven = (nums1.length + nums2.length)%2 ==0;
        int prev=0;
        while(i<nums1.length || j< nums2.length || k<=m){ // here k<=m will make us run only till half loop or half length
            int cur = 0;

            if(i<nums1.length && j< nums2.length){
                if(nums1[i]<nums2[j]){
                    cur = nums1[i++];
                }else{
                    cur = nums2[j++];
                }
            }else if(i<nums1.length){
                cur = nums1[i++];
            }else if(j< nums2.length){
                cur = nums2[j++];
            }


            if(k++==m){
                if(isEven){
                    return (cur + prev)/2.0;
                }
                return cur;
            }
            prev = cur;
        }
        return 0;
    }
}
