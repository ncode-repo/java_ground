package features.funcInterface;

public interface FuncInterface2 {
    String method1(String from);
    default void method2(){
        System.out.println("FuncInterface2::method2");
    }
}
