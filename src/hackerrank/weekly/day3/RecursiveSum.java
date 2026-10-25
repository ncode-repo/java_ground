package hackerrank.weekly.day3;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RecursiveSum {
    public static void main(String[] args) {
        Integer x= 9875;

        //List<String> x1 = Stream.of(x).reduce(n->n+n/n.toString().length()).collect(Collectors.toList());
        //System.out.println(x1);
        int asInt = IntStream.of(x).reduce((a,b)->a+b).getAsInt();
        System.out.println(asInt);
        String s=Stream.of(String.valueOf(x).split(""))
                        .reduce((a,b)->String.valueOf(Integer.valueOf(a)+Integer.valueOf(b)))
                        .get();
        System.out.println("s="+s);
        int result= recFun(111,3);
        long result1= recFun1("1",1);
        int res= streamSum("9875",3);
        System.out.println("result=" +res);


        int findSum= findSum1(9875,3);

        System.out.println("findSum=" +findSum);
    }

    static int findSum1(int N, int k) {
        String num = new String();
        for (int i = 0; i < k; i++) {
            num += N;
        }
        return findSum2(Long.valueOf(num));
    }
    static int findSum2(Long N)
    {
        Long no= Long.valueOf(N);
        if(no<10)
            return no.intValue();

        Long sum = 0l;
        while(no>0){
            sum += no%10;
            no= no/10;
        }
        return findSum2(sum);
    }

    private static int streamSum(String n, int k) {
        String num=new String();
        for (int i = 0; i <k ; i++) {
            num+=n;
        }
        Long sum = num.chars().map(Character::getNumericValue).mapToLong(Long::valueOf).sum();
        return sum.intValue();
    }
    private static int recFun1(String n, int k) {
        String num=new String();
        for (int i = 0; i <k ; i++) {
            num+=n;
        }
        Long result= recFun2(Long.valueOf(num),0);

        return result.intValue();
    }

    public static Long recFun2(Long x, int sum) {
        Long y = sum+ x % 10;
        x = x / 10;
        if(x>0)
            y=recFun2(x,y.intValue());
        else if(y>9)
            y=recFun2(y,0);
        return y;
    }
    public static int recFun(int x,int k){
        int num=0;
        int len= String.valueOf(x).length();
        for (int i = 0,div=10; i < len; i++) {
            num+=x%div;
            x=x/div;
            if(i==len-1 && x==0){
                len=String.valueOf(num).length();
                if(len>1) {
                    x = num;
                    num = 0;
                    i = -1;
                }
            }
        }
        num=num*k;
        if(num>9){
            num=recFun(num,1);
        }
        return num;
    }
}
