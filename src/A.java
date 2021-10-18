import java.time.LocalDate;

public class A {
    private static int a;

    public static void main1(String[] args) {
        int a = 5;
        System.out.println(f(a));
        System.out.println(f(a));
        System.out.println(a);
    }

    public static int f(int x) {
        a++;
        return a + x;
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());


        //obj = (String) Object::toString;

       // System.out.println(1 < 2 < 3 );

    }

    private class C {
        
    }
}