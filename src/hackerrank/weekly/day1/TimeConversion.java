package hackerrank.weekly.day1;

public class TimeConversion {
    public static void main(String[] args) {
        String input = "12:05:45pm";
        String [] splits= input.toLowerCase().split(":");

        if(splits.length==3){
            String ampm=splits[2];
            if(ampm.endsWith("am") || ampm.endsWith("pm")){
                int hr=Integer.parseInt(splits[0]);
                int min=Integer.parseInt(splits[1]);
                int sec=0;
                if (hr<1) return;
                if(ampm.contains("pm")){
                    sec=Integer.parseInt(splits[2].replace("pm",""));
                    hr= hr==12?hr:hr+12;
                }else{
                    hr= hr==12?0:hr;
                    sec=Integer.parseInt(splits[2].replace("am",""));
                }
                if(hr>=0 && hr<=24 && min>=0 && min<=60 && sec >=0 && sec<=60) {
                    String sHr = hr > 9 ? String.valueOf(hr) : String.valueOf("0" + hr);
                    String sMin = min > 9 ? String.valueOf(min) : String.valueOf("0" + min);
                    String sSec = sec > 9 ? String.valueOf(sec) : String.valueOf("0" + sec);
                    String converted = String.format("%s:%s:%s", sHr, sMin, sSec);
                    System.out.println(converted);
                }
            }
        }

    }
}
