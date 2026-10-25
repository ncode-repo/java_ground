package algo.search.bts;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        //divide arr
        //chk  if mid of arr val == target, return
        // if its less, new arr= mid+1 to arr len, else 0 to mid-1
       /* int mid= nums.length/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]<target) return search(Arrays.copyOfRange(nums,mid,nums.length),target);
        else return search(Arrays.copyOfRange(nums,0,mid),target);*/

        /*int size=nums.length;
        int mid=0;
        for(int i=0;i<size;i++){
            mid= size/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) i=mid+1;
            else size=mid-1;
        }*/
        int start=0, mid=nums.length/2, end=nums.length;
        while (start<=end){
            mid=(start+end)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return -1;
    }
    public static int search1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target) return mid;
            else if ( nums[mid] < target) i = mid + 1;
            else j = mid - 1;
        }

        return -1;
    }
    static int binarySearch(int arr[],  int x)
    {
        int l=0; int r=arr.length;
        while (l <= r) {
            int mid = (l + r) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x) {
                return mid;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                // so we decrease our r pointer to mid - 1
            } else if (arr[mid] > x) {
                r = mid - 1;

                // Else the element can only be present
                // in right subarray
                // so we increase our l pointer to mid + 1
            } else {
                l = mid + 1;
            }
        }

        // We reach here when element is not present
        //  in array
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] intArr = IntStream.range(1, 100).toArray();
        var cur=System.nanoTime();
        int pos= search(intArr,74);
        System.out.println("Completed in="+(System.nanoTime()-cur));
//        int pos= binarySearch(nums,4);
        System.out.println("target num found at="+pos);

         cur=System.nanoTime();
         pos= search1(intArr,74);
        System.out.println("Completed in="+(System.nanoTime()-cur));
        System.out.println("target num found at="+pos);
    }
}
