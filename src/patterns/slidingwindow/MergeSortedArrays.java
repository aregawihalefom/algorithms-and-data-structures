package patterns.slidingwindow;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        // Two pointers
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[m+n];

        while(i< m && j< n){

            if(nums1[i] <= nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];
        }

        while(i < m) merged[k++] = nums1[i++];
        while(j < n) merged[k++] = nums2[j++];

        nums1 = merged;

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        mergeSortedArrays.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3);
    }
}
