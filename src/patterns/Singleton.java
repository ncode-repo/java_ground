package patterns;

import java.io.Serializable;

public class Singleton implements Serializable {
    private static Singleton INSTANCE;

    private Singleton(){
        if(INSTANCE !=null){
            throw new RuntimeException("broken!");
        }
    }

    public static Singleton getInstance(){
        if(INSTANCE ==null) {
            synchronized(Singleton.class){
                if(INSTANCE ==null) {
                    INSTANCE= new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public Object readResolve() {
        return INSTANCE;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
