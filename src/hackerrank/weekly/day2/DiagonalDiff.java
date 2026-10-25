package hackerrank.weekly.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DiagonalDiff {
    public static void main(String[] args) {
        List<List<Integer>> arr= List.of(List.of(1,2,3),List.of(4,5,6),List.of(17,8,9));
        int len=arr.size();

        //version 1
        Integer v1sum1=0,v1sum2=0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i==j)
                    v1sum1 += arr.get(i).get(j);
                if(j==0)
                    v1sum2+=arr.get(i).get(len-1-i);
            }
        }
        System.out.println(v1sum1+" "+v1sum2);
        System.out.println("legacy diff="+ Math.abs(v1sum1-v1sum2));

        //version 2
        int[][] ints = arr.stream()
                .map(x -> x.stream().mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
        int v2sum1 = IntStream.range(0, ints.length).map(i -> ints[i][i]).sum();
        int v2sum2 =IntStream.range(0,ints.length).map(i -> ints[i][ints.length-1-i]).sum();

        System.out.println("version2: to multi Array + lambda:: diff="+ Math.abs(v2sum1-v2sum2));

        //version3
        int v3sum1 = IntStream.range(0, ints.length).map(i -> arr.get(i).get(i)).sum();
        int v3sum2 = IntStream.range(0, ints.length).map(i -> arr.get(i).get(len-1-i)).sum();
        System.out.println("version3: lambda:: diff="+ Math.abs(v3sum1-v3sum2));

        //version last
        int sum = IntStream.range(0, ints.length).map(i -> arr.get(i).get(i) - arr.get(i).get(len - 1 - i)).sum();
        System.out.println("Last way:"+Math.abs(sum));
    }
}
