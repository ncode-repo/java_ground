package hackerrank.challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextQuery {

    static void textQueries2(String[] sentences, String[] queries) {
        // Split the sentences into terms and map them by index
        Map<Integer, Set<String>> sentencesSplit = new HashMap<>();
        IntStream.range(0, sentences.length).forEach(j -> {
            String[] splitSentence = sentences[j].split(" ");
            Set<String> sentenceSet = new HashSet<>();
            sentencesSplit.put(j, sentenceSet);
            Collections.addAll(sentenceSet, splitSentence);
        });

        // Split the query into terms and map them by index
        Map<Integer, String[]> queriesSplit = IntStream.range(0, queries.length).boxed().collect(Collectors.toMap(i -> i, i -> queries[i].split(" "), (a, b) -> b));

        for (int i = 0; i < queries.length; i++) {
            String found = null;
            for (int j = 0; j < sentences.length; j++) {
                String[] splitQuery = queriesSplit.get(i);
                Set<String> sentenceStringList = sentencesSplit.get(j);
                boolean notFound = false;
                for (int k = 0; k < splitQuery.length; k++) {
                    if (!sentenceStringList.contains(splitQuery[k])) {
                        notFound = true;
                        break;
                    }
                }
                if (!notFound) {
                    if (found == null) {
                        found = "" + j;
                    } else {
                        found += " " + j;
                    }
                }
            }
            if (found == null) {
                found = "-1";
            }
            System.out.println(found);
        }
    }


    public static void main(String[] args) {
        String[] sentences = {"jim likes mary", "kate likes tom", "tom does not like jim"};
        String[] queries = {"jim tom", "likes", "nope"};

        textQueries2(sentences, queries);
    }
}