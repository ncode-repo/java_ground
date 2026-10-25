package random;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;


public class Numeric {
    public static void main(String[] args) {
        //finding missing number
        int[] nums= {3,2,1,5,6,4,7,9};
        int max = Arrays.stream(nums).max().getAsInt();
        //method 1
        int expectedSum=max*(max+1)/2;
        int actualSum=Arrays.stream(nums).sum();
        System.out.println("method2::missing num="+(expectedSum-actualSum));

        //method 2
        List<Integer> numsList = Arrays.stream(nums).sorted().boxed().collect(toList());
        for (int i = 1,j=0; i <= max; i++,j++) {
            if (numsList.get(j) != i) {
                System.out.println("method1::missing=" + i);
                break;
            }
        }

        //find odd numbers
        List<Integer> oddNums = Arrays.stream(nums).boxed().filter(n -> n % 2 != 0).collect(toList());
        System.out.printf("Odd nums="+oddNums);


        //find 1st unique number from array
//        int[] arr1={2,3,4,3,2,5,6};
//        int[] arr1={2,3,2,3,2,3,6};
//        int[] arr1={2,3,4,4,2,2,3};
        int[] arr1={4, 10, 5, 4, 2, 10};
        int aLong = Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1).map(Map.Entry::getKey)
                .findFirst().orElse(-1);
        System.out.println("1st unique from arr="+aLong);


    }
}
