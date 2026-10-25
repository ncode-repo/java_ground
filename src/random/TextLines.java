package random;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TextLines {
    public static void main(String[] args) {
        String str="Already Asked For A Grade-A.";

        //count char 'A'
        Map<String, Long> a = Arrays.stream(str.split(""))
                .filter(s -> s.equals("A"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.printf("No of="+a);

        countDeletion("ABCABC");

        longestSubstringEvenLen("This is longest aabb tttthhhh");
    }
    //to count minimum deletions required so that there are no consecutive characters left
    static int countDeletion(String str){
        String[] arr=str.split("");
        var count = (int) IntStream.range(0, arr.length - 2).filter(i -> arr[i].equals(arr[i + 1])).count();

        System.out.println("\ncountDeletion="+count);
//        Arrays.stream(str.split("")).filter(c->c)
        return count;
    }
    static String longestSubstringEvenLen(String str){
        String[] arr=str.split(" ");
        String res="";
        List<Map.Entry<String, Long>> collect = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() % 2 == 0)
                .collect(Collectors.toList());
        System.out.printf("----"+collect);
        /*for (int i = 0; i < arr.length; i++) {
            String[] word=arr[i].split("");
            for (int j = 0; j <word.length; j++) {
                List<Map.Entry<String, Long>> collect = Arrays.stream(word)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(m -> m.getValue() % 2 == 0).collect(Collectors.toList());
                String key = collect.stream()
                        .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                        .get().getKey();

            }
        }*/
        System.out.printf("longestSubstringEvenLen="+res);
        return res;
    }
}
