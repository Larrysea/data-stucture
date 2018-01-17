package ninechapter;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;
import data_stucture.PrintUtil;

import java.lang.reflect.Array;
import java.util.*;

public class SubSets {

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> intList=new ArrayList();
        for(int index=0;index<nums.length;index++)
        {
            intList.add(nums[index]);
        }
         Collections.sort(intList);
        // write your code here
        if (intList.size() == 0) {
            return null;
        }
        Set<List<Integer>> result = new LinkedHashSet<>();

        //添加一个空的集合
        result.add(new ArrayList<>());

        //包含整个数组的一个集合
        List<Integer> allList = new ArrayList<Integer>();
        //数组中每个单独的数是一个集合
        for (int i = 0; i < intList.size(); i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(intList.get(i));
            //添加单个数组的集合
            result.add(list);
            //整个数组集合中添加元素
            allList.add(intList.get(i));
        }
        //将整个数组集合添加到结果中
        result.add(allList);

        for (int firstNumberIndex = 0; firstNumberIndex < intList.size(); firstNumberIndex++) {
            for (int secondNumberIndex = firstNumberIndex + 1; secondNumberIndex < intList.size(); secondNumberIndex++) {
                ArrayList<Integer> subSets = new ArrayList<>();
                subSets.add(intList.get(firstNumberIndex));
                subSets.add(intList.get(secondNumberIndex));
                if (!result.contains(subSets)) {
                    result.add(subSets);
                }
            }

        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        resultList.addAll(result);
        return resultList;
    }


    //主函数
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        int nums1[] = {0};
        int nums2[]={4,1,0};
        int nums3[]={1,2,3,4};
//        PrintUtil.print(subsets(nums));
        PrintUtil.print(subsets(nums2));

    }


}
