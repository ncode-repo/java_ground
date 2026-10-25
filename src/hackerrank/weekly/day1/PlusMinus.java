package hackerrank.weekly.day1;

import java.text.DecimalFormat;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        plusMinus();
    }

    public static void plusMinus() {
        List<Integer> arr = List.of(1, 3, 4, 4, 5, 07, 06);
        float pos = 0, neg = 0, zer = 0;
        int size = arr.size();
        if (size > 0 && size <= 100) {
            for (Integer n : arr) {
                if (n >= -100 && n <= 100) {
                    if (n > 0) {
                        pos++;
                    } else if (n < 0) {
                        neg++;
                    } else {
                        zer++;
                    }
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println(df.format(pos / size));
        System.out.println(df.format(neg / size));
        System.out.println(df.format(+zer / size));
    }
}