package testproblem;

/**
 * Created by Larry-sea on 2017/1/22.
 */
public class Singleton {

    //声明一个唯一的静态实例
    private static Singleton instance;

    /**
     * 私有化构造函数使得无法通过构造函数创建实例
     */
    private Singleton() {
    }


    /**
     * @return 返回本类的一个唯一实例
     */
    static Singleton getInstance() {
        //加上这一层判断是为了性能，因为加锁会对程序的效率有影响，所以多一层判断避免无谓的消耗
        if (instance == null) {
            //加上锁保证多线程下也能够保证唯一实例
            synchronized (Singleton.class) {
                if (instance == null)
                    //当实例为空时实例化一个实例
                    instance = new Singleton();
            }
        }
        return instance;
    }


}
