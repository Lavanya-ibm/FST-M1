package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> s=new HashSet<String>();
        s.add("abc");
        s.add("zabc");
        s.add("yabc");
        s.add("xabc");
        System.out.println("elements in hashset"+s);
        System.out.println("size of elements in hashset"+s.size());
        System.out.println("remove an element in hashset"+s.remove("yabc"));
        System.out.println("removing element not in hashset"+s.remove("fgh"));
        System.out.println("contains item in hashset"+s.contains("xabc"));
        System.out.println("updated hashset"+s);


    }
}
