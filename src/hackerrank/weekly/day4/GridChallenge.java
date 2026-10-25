package hackerrank.weekly.day4;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GridChallenge {
    public static void main(String[] args) {

        List<String> grid= List.of("ebacd", "fghij", "olmkn", "trpqs","xywuv");
        //List<String> grid= List.of("acd", "hij", "mkn", "pqs","wuv");
        System.out.println(gridChallenge(grid));
    }

    public static String gridChallenge(List<String> grid) {
        List<String> sorted = grid.stream().map(str -> Stream.of(str.split("")).sorted().collect(Collectors.joining())).collect(Collectors.toList());
        boolean colSorted=true;

        for (int j = 0; j < sorted.get(0).length(); j++) {
            for (int i = 0; i < sorted.size()-1; i++) {
                if(sorted.get(i).charAt(j)>sorted.get(i+1).charAt(j)){
                    colSorted=false;
                    break;
                }
            }
            if(!colSorted){
                break;
            }
        }
        return colSorted?"YES":"NO";
    }
}
