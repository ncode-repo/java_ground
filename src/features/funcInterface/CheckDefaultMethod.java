package features.funcInterface;

public class CheckDefaultMethod implements FuncInterface1,FuncInterface2{

    @Override
    public String method1(String from) {
        return "CheckDefaultMethod::method1::"+from;
    }

    @Override
    public void method2() {
        //FuncInterface1.super.method2();
        System.out.println("inside method2()");
    }

    public static void main(String[] args) {
        CheckDefaultMethod c= new CheckDefaultMethod();
        System.out.println(c.method1("CheckDefaultMethod"));
        c.method2();


        FuncInterface1 i1= new CheckDefaultMethod();
        System.out.println(i1.method1("FuncInterface1"));
        i1.method2();
        FuncInterface1.method3();

        FuncInterface2 i2= new CheckDefaultMethod();
        System.out.println(i1.method1("FuncInterface2"));
        i2.method2();
    }
}
