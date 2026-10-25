package random;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MostlyAsked20 {
    public static void main(String[] args) {
        //no. is prime or not
        System.out.println("is prime="+isPrime(12));

        //print duplicate no.s
        int[] nums= {2,3,1,5,3,7,3,5,2};
        System.out.println("duplicates="+ findDuplicateNos(nums));

        //check palindrome
        String s1="1221";
        System.out.println("is palindrome="+checkPalindrome(s1));

        //print duplicate str
        String[] strs={"ajay", "santosh","kiran","jay","santosh","amar","jay"};
        System.out.println("duplicate strs="+duplicateStrings(strs));

        //find min, max no. in array
        printMinMax(nums);

        //find 2nd highest && 2nd lowest no. in array
        System.out.println("2nd highest no.="+secondHighest(nums));
        System.out.println("2nd lowest no.="+secondLowest(nums));

    }

    private static int secondLowest(int[] nums) {
        Integer integer = IntStream.of(nums).boxed().sorted().skip(1).findAny().get();

        return integer;
    }

    private static int secondHighest(int[] nums) {
        Integer integer = IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).skip(1).findAny().get();
        return integer;
    }


    private static void printMinMax(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        //int max = Arrays.stream(nums).max().getAsInt();
        int max = Arrays.stream(nums).boxed().min(Comparator.reverseOrder()).get();
        System.out.println("Min()="+min +" Max()="+max);

        min=Arrays.stream(nums).boxed().reduce((a,b)->a<b?a:b).get();
        max=Arrays.stream(nums).boxed().reduce(Integer::max).get();
        System.out.println("Min by stream="+min +" Max by stream="+max);

    }

    private static List<String> duplicateStrings(String[] strs) {
        List<String> collect = Arrays.stream(strs)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect;
    }

    private static boolean checkPalindrome(String s1) {
        String rev = Arrays.stream(s1.split("")).reduce((i1, i2) -> i2 + i1).get();
        System.out.println("reverse str="+rev);
        return s1.equals(rev);
    }

    private static List<Integer> findDuplicateNos(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        return collect;

    }

    private static boolean isPrime(int i) {
        if(i==0 || i==1) return false;
        if(i==2) return true;
        boolean isPrime= IntStream.rangeClosed(2,i/2).noneMatch(x->i%x==0);
        return isPrime;
    }
}
