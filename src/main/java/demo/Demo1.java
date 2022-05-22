package demo;

public class Demo1 {
    //"add two ints."
    public static int add(int a, int b) {
        return a + b;
    }

    // "prints the contents of an array to standard out."
    public static void print(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
