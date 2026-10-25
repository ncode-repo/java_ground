package hackerrank.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ContextSearch {

    public static void main(String[] args) {
        List<String> products = List.of("Cement","Ceramic","Camera","Cameron",
                                        "Lens","Lame","Laptop","Pen","Pentagon","Paper","Pot","Pipe");

        List<List<String>> result= contextSearch_stream(products,"Camera");
        System.out.println(result);
        result= contextSearch_old(products,"Camera");
        System.out.println(result);
    }

    private static List<List<String>> contextSearch_stream(List<String> products, String search) {
        List<List<String>> resultList;
        String[] str= search.split("");

        /*resultList = IntStream.range(0, str.length)
                .mapToObj(i -> products.stream().sorted().filter(prod -> search.substring(0, i + 1).length() <= prod.length() &&
                                prod.substring(0, i + 1).equals(search.substring(0, i + 1)))
                        .limit(3)
                        .collect(Collectors.toList())).collect(Collectors.toList());*/
        resultList = IntStream.range(0, str.length)
                .mapToObj(i -> products.stream().sorted().filter(prod -> search.substring(0, i + 1).length() <= prod.length() &&
                                prod.substring(0, i + 1).equals(search.substring(0, i + 1)))
                        .limit(3)
                        .collect(Collectors.toList())).collect(Collectors.toList());


        return resultList;
    }
    private static List<List<String>> contextSearch_old(List<String> products, String search) {
        List<List<String>> resultList= new ArrayList<>();
        List<String> sortedProds = products.stream().sorted().collect(Collectors.toList());
        String[] str= search.split("");
        for (int i = 0; i < str.length; i++) {
            List<String> list = new ArrayList<>();
            for (String sortedProd : sortedProds) {
                if (list.size()<3 && i<sortedProd.length() &&
                        sortedProd.substring(0, i + 1).equals(search.substring(0, i + 1))) {
                    list.add(sortedProd);
                }
            }
            if(list.size()>0){
                resultList.add(list);
            }
        }
        return resultList;
    }
}
