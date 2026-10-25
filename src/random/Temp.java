package random;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Temp {
    public static void main(String[] args) {
        validateRequests();
    }


    public static List<Integer> validateRequests() {
        List<String> blacklisted_ips= List.of("*111.*","123.*","34.*");
        List<String> requests= List.of("123.1.23.34","121.1.23.34","121.1.23.34",
                "34.1.23.34","121.1.23.34","12.1.23.34","121.1.23.34");

        List<String> blackIps = new ArrayList<>();
        List<Integer> resultList= new ArrayList<>();
        for(String str: blacklisted_ips){
            str=str.replace("*", "").replace(".", "");
            blackIps.add(str);
        }
        System.out.println(blackIps);

        IntStream.range(0, requests.size()).forEach(j->blackIps.stream().filter(s->requests.get(j).contains(s)).findAny()
                .ifPresentOrElse(v->resultList.add(j, 1), ()->resultList.add(j, 0)));

        List<String> collect = requests.stream()
                .flatMap(r -> blackIps.stream()
                        .filter(b -> b.equals(r))).collect(toList());
        System.out.println(collect);

        return resultList;
    }
}
