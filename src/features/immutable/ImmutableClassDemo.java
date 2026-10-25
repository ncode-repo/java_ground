package features.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableClassDemo {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        
        Address address1 = new Address("s1", "c1");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("123345");
        phoneNumbers.add("456789");
        Map<String, String> metadata = new HashMap<>();
        metadata.put("hobby", "Watching Movies");
        Employee e = new Employee("John", 23, address1, phoneNumbers, metadata);

        // modifications
        e.getAddress().setCity("c3");
        e.getAddress().setStreet("s3");
        e.getPhoneNumbers().add("1234");
        e.getMetadata().put("skill", "Java");
        e.getMetadata().put("designation", "HR");

        System.out.println(e.getEmpName());
        System.out.println(e.getAge());
        System.out.println(e.getAddress());
        System.out.println(e.getPhoneNumbers());
        System.out.println(e.getMetadata());

    }
}