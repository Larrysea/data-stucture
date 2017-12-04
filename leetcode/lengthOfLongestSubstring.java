package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Larry-sea on 2016/12/9.
 *
 *
 *
 */
public class lengthOfLongestSubstring {


    /*
    *
    *
    * 获取最长的子字符串长度
    *
    *
    * 时间复杂度O（n2）
    * */
    static public int getLongestSubStringLength(String parentString) {
        HashMap<Character, Integer> stringMap = new HashMap<>();
        int maxLength = 0;        //最大长度
        for (int position = 0; position < parentString.length(); position++) {
            for (int nextPosition = position; nextPosition < parentString.length(); nextPosition++) {
                if (!stringMap.containsKey(parentString.charAt(nextPosition))) {
                    stringMap.put(parentString.charAt(nextPosition), nextPosition);
                    if (stringMap.size() > maxLength) {
                        maxLength = stringMap.size();
                    }
                } else {
                    stringMap.clear();
                    break;
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return maxLength;
    }


      /*
        时间复杂度为O(n)

        可以实现但是使用到了hashmap会比较占用内存没有下面那个方法发只使用了一个String就解决这个问题

       */

    static public int betterGetLongestSubString(String parentString) {

        String resultSring = "";     //最长的字符串string
        int maxLength = 0;          //保存的上一次最长的长度
        HashMap<Character, Integer> stringMap = new HashMap<>();
        for (int position = 0; position < parentString.length(); position++) {
            if (!stringMap.containsKey(parentString.charAt(position))) {
                stringMap.put(parentString.charAt(position), position);
                resultSring += parentString.charAt(position);
                if (stringMap.size() > maxLength) {
                    maxLength = stringMap.size();
                }
            } else {
                stringMap.clear();
                stringMap.put(parentString.charAt(position), position);
                if (stringMap.size() > maxLength) {
                    maxLength = stringMap.size();
                }
            }

        }
        return maxLength;
    }

    /**
     *
     * Accepted
     * @param parentString
     * @return
     */
   static public int betterMaxLengestOfSubString(String parentString)
    {

        String resultString="";
        int maxLength=0;
        for (int position = 0; position < parentString.length(); position++) {
            if (-1==resultString.indexOf(parentString.charAt(position))) {
                resultString += parentString.charAt(position);
            } else {

                resultString=resultString.substring(resultString.indexOf(parentString.charAt(position))+1);
                resultString += parentString.charAt(position);
            }

            if (resultString.length() > maxLength) {
                maxLength = resultString.length();
            }
        }
        return maxLength;

    }

}
