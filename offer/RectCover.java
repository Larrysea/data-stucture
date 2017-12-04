package offer;

/**
 * Created by Larry-sea on 2017/2/20.
 * <p>
 * 剑指offer上面的距形覆盖问题
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {


    /**
     * @param target 代表这个2*n矩形的高度
     * @return 返回有多种填充方案
     */
    public int RectCover(int target){


        if (target  == 2) {
            return 2;
        } else if (target  == 1) {
            return 1;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }

    }


}
