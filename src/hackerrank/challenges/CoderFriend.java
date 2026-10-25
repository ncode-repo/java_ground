package hackerrank.challenges;

import java.util.Arrays;
import java.util.Map;

public class CoderFriend {

    public static void winner(String erica, String bob){
        Map<String,Integer> wt = Map.of("E",1,"M",3,"H",5);
        int e,b=0;
        e = Arrays.stream( erica.split("")).mapToInt(wt::get).sum();
        b = Arrays.stream( bob.split("")).mapToInt(wt::get).sum();

        if(e>b) {
            System.out.println("Erica");
        } else if(b>e) {
            System.out.println("Bob");
        }else{
            System.out.println("Tie");
        }

        /*Arrays.stream(erica.split("")).collect()
                .reduce(s->
                {
                    if(wt.containsKey(s))
                        e=e+wt.get(s);
                });*/
    }

    public static void main(String[] args) {
            winner("EHEH", "EHH");
    }
}
