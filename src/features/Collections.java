package features;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collections {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Baeldung");
        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            set.add("Awesome");
            it.next();
        }
    }
}
