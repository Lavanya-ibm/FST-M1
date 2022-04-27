package activities;



interface Addable{
        int add(int num1,int num2);
}
    public class Activity12 {
        public static void main(String[] args) {

            Addable obj = (num1,num2) -> (num1+num2);
            System.out.println(obj.add(100,20));
                Addable obj1 = (int num1,int num2) -> {
                    return (num1+num2);
            };

            System.out.println(obj1.add(10,20));
        }
    }

