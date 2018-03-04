package ninechapter.binarysearch;

import data_stucture.PrintUtil;

/**
 * 找出svn提交的第一个坏的版本
 *
 * @author
 * @create 2018-01-20 下午9:55
 **/
public class IsBadVersion {


    public static void main(String[] args) {

        PrintUtil.print(findFirstBadVersion(20));
    }


    public static int findFirstBadVersion(int n) {

        if (n < 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        // write your code here
        int start = 1;
        int end = n;

        //通过二分法来进行范围确定，不断来缩小范围，最后来确定第一个错误版本
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }

        if (SVNRepo.isBadVersion(end)) {
            return end;
        }

        return -1;
    }


    static class SVNRepo {
        int badVersion = 3;

        public static boolean isBadVersion(int k) {
            if (k >= 3) {
                return true;
            } else {
                return false;
            }
        }
    }


}
