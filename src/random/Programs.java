package random;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class Programs {

	public static void main(String[] args) {
		String string = "IloveProgramming&entrepreneurship";

		// count the occurrence of each char in str
		Map<String, Long> occurrence = Arrays.stream(string.split(""))
				.collect(Collectors.groupingBy(Function.identity(), counting()));
		// System.out.println(occurrence);

		// Find all duplicate elements in str
		List<String> duplicate = Arrays.stream(string.split(""))
				.collect(Collectors.groupingBy(Function.identity(), counting())).entrySet().stream()
				.filter(a -> a.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
//		 System.out.println(duplicate);

		// Find non-repeat occurrences from string
		List<String> unique = Stream.of(string)
				.collect(Collectors.groupingBy(Function.identity(), counting())).entrySet().stream()
				.filter(a -> a.getValue() == 1).map(Entry::getKey).collect(Collectors.toList());
//		System.out.println(unique);

		// find 2nd highest number
		int[] numbers = { 5, 2, 33, 6, 1, 7, 3, 39, 2, 11 };
		Set<Integer> set = new HashSet<>();int dup=0;
		for (int i = 0; i < numbers.length; i++) {
			if(set.add(numbers[i])==false)
					dup= numbers[i];
		}
		System.out.println("duplicate number==="+dup);


		int result = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		// System.out.println(result);
		//addition
		int max = Arrays.stream(numbers).reduce(Integer::max).getAsInt();
		System.out.println("Max of number: "+max);
		int add = Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
		System.out.println("Addition of number: "+add);

		// Longest str from giver arr
		String[] strArr = { "java", "technology", "microservices" };
		String longest = Arrays.stream(strArr).reduce((a, b) -> a.length() > b.length() ? a : b).get();
		System.out.println(longest);

		// find nums starts with -
		List<String> starts1 = Arrays.stream(numbers).boxed().map(s -> s + "").filter(n -> n.startsWith("3"))
				.collect(Collectors.toList());
		System.out.println(starts1);

		//find the duplicate names and count in ArrayList
		List<String> lstName= List.of("Amar","Vijay","Nilesh","Jay","Amar","Nilesh","Jay","Jay");
		Map<String, Long> collectDuplicate = lstName.stream().collect(Collectors.groupingBy(Function.identity(), counting()));
		System.out.println("byStream duplicate names: "+ collectDuplicate);

		//remove the duplicates from the given string input
		String str= "Red bird Yellow bird vegs Blue bird ocean";
//		String str ="aabbccdd  eeff";
		System.out.println("input: "+str);
		String collect = Arrays.stream(str.split(" ")).distinct().collect(Collectors.joining(" "));
		System.out.println("dup words removed: "+collect);

		//sort hashmap
		System.out.println("sortHashMap");
		Map sortHashMap = Map.of(4,"four",2,"two",1,"one",5,"five");
		System.out.println("before: "+sortHashMap);
//		TreeMap map = new TreeMap(sortHashMap);
//		System.out.println("after: "+map);
		sortHashMap.entrySet()
				.stream()
				.sorted(Entry.comparingByKey())
				.forEach(System.out::println);

		//Write a program to check the palindrome
		System.out.println("check the palindrome");
		String str1= "abaa";
		String str2= "madam";
		StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb2 = new StringBuilder(str2);
		System.out.printf("%s is palindrome: %s\n",str1,sb1.reverse().toString().equals(str1));
		System.out.printf("%s is palindrome: %s\n",str2,sb2.reverse().toString().equals(str2));

		String revStr= "Reversed String";
//		revStr = Stream.of(revStr).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining());
//		revStr=revStr.chars().mapToObj(c->String.valueOf((char)c)).reduce((a,b)->b+a).orElse("");
//		System.out.println(revStr);
		String collect1 = Stream.of(revStr).reduce((a, b) -> b + a).stream().collect(Collectors.joining());
		System.out.println("collect1="+collect1);

		int n=20;
		for (int i = 1; i <n ; i++) {
			boolean multiple3=false,multiple5=false;
			if(i%3==0 ){
				multiple3=true;
			} if(i%5==0){
				multiple5=true;
			}
			if(multiple3 && multiple5){
				System.out.println("FizzBuzz");
			}else if(multiple3){
				System.out.println("Fizz");
			}else if(multiple5){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
		}

	}
}
