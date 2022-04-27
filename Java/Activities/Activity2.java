package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] a={19, 66, 10, 54, -11, 10};
        int temp=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==10)
            {
                temp=temp+a[i];

            }

        }
        System.out.println("Temp value is"+temp);
        if(temp!=30)
        {
            System.out.println("false");
        }
        else
        {
            System.out.println("true");
        }

    }
}
