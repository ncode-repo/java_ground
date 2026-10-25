package patterns;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        checkSerialization();
        checkReflection();
        checkCloning();

    }
    public static void checkCloning() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        Singleton instanceOne = Singleton.getInstance();
        Singleton instanceTwo = (Singleton) instanceOne.clone();
        System.out.println("Checking clone");
        System.out.println("Hashcode of Object 1: " + instanceOne.hashCode());
        System.out.println("Hashcode of Object 2: " + instanceTwo.hashCode());
    }
    public static void checkSerialization()throws IOException, ClassNotFoundException {
        Singleton instanceOne = Singleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
        Singleton instanceTwo = (Singleton) in.readObject();
        in.close();
        System.out.println("Checking Serialization");
        System.out.println("Hashcode of Object 1: " + instanceOne.hashCode());
        System.out.println("Hashcode of Object 2: " + instanceTwo.hashCode());
    }
    public static void checkReflection() {
        Singleton instanceOne = Singleton.getInstance();
        Singleton instanceTwo = null;
        try {
            Constructor constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            instanceTwo = (Singleton) constructor.newInstance();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Checking Reflection");
        System.out.println("Hashcode of Object 1: " + instanceOne.hashCode());
        System.out.println("Hashcode of Object 2: " + instanceTwo.hashCode());
    }
}