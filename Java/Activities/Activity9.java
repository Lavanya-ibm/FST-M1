package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<String>();
        a.add("cxyz");
        a.add("dxyz");
        a.add("exyz");
        a.add("fxyz");
        a.add("gxyz");

        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).toString());
        }
        System.out.println("3rd name in the ArrayList"+a.get(3));
        System.out.println("name exists in the ArrayList"+a.contains("xyz"));
        System.out.println("number of names in the ArrayList"+a.size());
        System.out.println("remove a name from the list"+a.remove(3));

            System.out.println(a.size());


    }



}
