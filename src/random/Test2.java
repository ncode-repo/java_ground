package random;
import java.util.*;

public class Test2 {
    public static void main(String[] argv) {
        //1. Two Sum
//        int[] nums =  {3, 2, 4};
//        int target= 6;
//        System.out.println(Arrays.toString(twoSum(nums,target)));

        //2. 1st unique character in a string
//        String s = "leetcode";
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seenMap.containsKey(complement)) {
                return new int[]{seenMap.get(complement), i};
            }
            seenMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int firstUniqChar(String s){
        Map<Character, Integer> charCountMap= new HashMap<>();

        for(char c: s.toCharArray()){
            charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(charCountMap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
