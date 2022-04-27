package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> lis=new ArrayList<Integer>();
        Random rm=new Random();
        System.out.print("Enter integers please ");
        System.out.println("(EOF or non-integer to terminate): ");

        while(sc.hasNextInt()) {
            lis.add(sc.nextInt());
        }

        Integer nums[] = lis.toArray(new Integer[0]);
        int index = rm.nextInt(nums.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);

        sc.close();
    }
}
