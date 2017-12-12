package testproblem;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/1/22.
 */
public class DeleteRepeatNode extends Object{
    static ArrayList<Integer> orderList;

   static  public List<Integer> deleteRepeatNode(ArrayList<Integer> arrayList) throws Exception {

        if (arrayList == null) {
            throw new Exception("arrayList cant empty");
        }
        int lastNodeValue = arrayList.get(0);
        for (int position = 1; position < arrayList.size(); position++) {
            //因为是排序链表所以相等的值只有可能出现在相邻的位置，然后如果和前一个相等则依次删除
            while (lastNodeValue == arrayList.get(position)) {
                arrayList.remove(position);
            }
            lastNodeValue = arrayList.get(position);
        }
        return arrayList;
    }

    public static void main(String [] args)
    {

        orderList=new ArrayList<Integer>();
        orderList.add(1);
        orderList.add(2);
        orderList.add(3);
        orderList.add(3);
        orderList.add(3);
        orderList.add(4);
        orderList.add(4);
        orderList.add(5);
        try {
            deleteRepeatNode(orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("我是finally");
        }
    }




}
