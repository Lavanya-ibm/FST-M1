package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer,String> colors= new HashMap<Integer, String>();
        colors.put(1,"red");
        colors.put(2,"red");
        colors.put(3,"blue");
        colors.put(4,"green");
        colors.put(5,"yellow");
        System.out.println(" hashmap:"+colors);
      colors.remove(3);
        System.out.println("green is available in hashmap or not: "+colors.containsValue("green"));
        System.out.println("size of hashmap after removing:"+colors.size());



    }
}
