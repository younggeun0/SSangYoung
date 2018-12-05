package date181126;

public class Test {

    public void swap(int i, int j) {
        int temp = 0;
        temp = i;
        i = j;
        j = temp;
        System.out.println("i = "+i+", j = "+j);
    }

    public static void main(String[] args) {
    
        int i=100, j=300;
        System.out.println(i+" "+j); // 100 300

        Test t = new Test();
        t.swap(i,j);

        System.out.println(i+" "+j); // 100 300
    }
}