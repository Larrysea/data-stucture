package testproblem;

/**
 * Created by Larry-sea on 2017/3/8.
 */
public class TestTryCatch {

    public static void main(String[] args) {
        System.out.println(test());
    }


    public static int test() {
        int i=0;
        try {
            System.out.println("return之前"+i);
            return ++i;
        } catch (Exception e) {


        } finally {
            ++i;
            System.out.println("finally中执行"+i);
        }
        return i;
    }

}
