package features.funcInterface;

public interface FuncInterface1 {
    String method1(String from);
    default void method2(){
        System.out.println("FuncInterface1::method2");
    }
    static void method3(){
        System.out.println("FuncInterface1::method3");
    }
}
