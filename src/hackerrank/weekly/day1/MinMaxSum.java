package hackerrank.weekly.day1;

import java.util.Comparator;
import java.util.List;

public class MinMaxSum {
    public static void main(String[] args) {
        List<Integer> arr= List.of(1,2,3,4,5,8,9);
        long minSum= arr.stream().mapToLong(w->w.longValue()).boxed().limit(5).filter(n->n>=1&&n<=Math.pow(10,9)).sorted(Comparator.reverseOrder()).skip(1).reduce(Long::sum).get();
        long maxSum= arr.stream().mapToLong(w->w.longValue()).boxed().limit(5).filter(n->n>=1&&n<=Math.pow(10,9)).sorted().skip(1).reduce(Long::sum).get();
        System.out.println(minSum + "" + maxSum);
    }
}
