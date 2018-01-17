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
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0 && source.length() == 0) {
            return 0;
        }
        if (target.length() > source.length()) {
            return -1;
        }
        return source.indexOf(target);
    }

    public static void main(String[] args) {
        strStr(null, null);
        PrintUtil.print(strStrII("fasdfas", ""));
        PrintUtil.print(strStrII("fasdfas", "f"));

        int i=0;
        for( i=0;i<10;i++)
        {

        }

        System.out.println("i"+i);
    }


    private static int strStrII(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0 && source.length() == 0) {
            return 0;
        }
        if (target.length() > source.length()) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(0)) {
                int sourceIndex = i;
                if (target.length() > 1) {
                    for (int j = 0; j < target.length(); ) {
                        if (source.charAt(sourceIndex) == target.charAt(j)) {
                            sourceIndex++;
                            j++;
                        } else {
                            break;
                        }
                        if (j == target.length() - 1) {
                            return i;
                        }
                    }
                } else {
                    return i;
                }
            }
        }
        return -1;
    }


    private static int strStrIII(String source,String target)
    {
        if(source==null||target==null)
        {
            return -1;
        }
        for(int i=0;i<source.length()-target.length()+1;i++)
        {
            int j=0;
            for(;j<target.length();j++)
            {
                if(source.charAt(i+j)!=target.charAt(j))
                {
                    break;
                }
            }
            if(j==target.length())
            {
                return i;
            }

        }
        return -1;

    }


}
