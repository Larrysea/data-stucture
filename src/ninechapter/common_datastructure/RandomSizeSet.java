package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 任意大小的set
 *
 * @author
 * @create 2018-04-09 上午12:23
 **/
public class RandomSizeSet {


    public static void main(String[] args) {
// Init an empty set.
        RandomSizeSet randomSet = new RandomSizeSet();

//        randomSet.insert(1);

        randomSet.remove(2);

//        randomSet.insert(2);

        PrintUtil.print(randomSet.getRandom() + "");

        randomSet.remove(1);

        PrintUtil.print(randomSet.insert(2) + "");

        PrintUtil.print(randomSet.getRandom());
    }

    private Set<Integer> set;

    public RandomSizeSet() {
        // do intialization if necessary
        set = new HashSet<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        return set.add(val);
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        return set.remove(val);
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        Object[] array = set.toArray();
        Random random = new Random();
        if (array.length > 0) {
            return (int) array[random.nextInt(array.length)];
        }
        return -1;
    }
}

