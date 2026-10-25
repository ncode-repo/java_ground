package hackerrank.weekly.day2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> a = List.of(1,2,3,4,3,2,1);
        int n=a.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).collect(Collectors.toList()).stream().findAny().get();
        System.out.println(n);
    }
}
