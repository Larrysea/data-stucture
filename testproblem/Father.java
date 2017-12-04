

package testproblem;

/**
 * Created by Larry-sea on 2017/1/24.
 */
public class Father {
    public Father() {
        System.out.println("i am father.");
    }
    public void read() {
        System.out.println("Father is reading.");
    }
    public static void main(String[] args) {
      /*  Father father = new Son();
        father.read();*/
        int i = 999;
        i--;
        ++i;
        System.out.println( i++ );
    }
};
class Son extends Father {
    public Son() {
        System.out.println("i am Son.");
    }
    public void read() {
        System.out.println("Son is reading.");
    }
};
