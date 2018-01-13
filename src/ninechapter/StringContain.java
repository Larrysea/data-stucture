package ninechapter;

import data_stucture.PrintUtil;



//lintcode 13 题
public class StringContain {


    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    private static int strStr(String source, String target) {
        if (source == null || target == null ) {
            return -1;
        }
        if(target.length() == 0 && source.length() == 0)
        {
           return 0;
        }
        if (target.length() > source.length()) {
            return -1;
        }
        return source.indexOf(target);
    }

    public static void main(String[] args) {
        strStr(null, null);
        PrintUtil.print(strStr("fasdfas", ""));
    }

}
