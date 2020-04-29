package leetcode;

/**
 * 5.最长回文串,@see {https://leetcode-cn.com/problems/longest-palindromic-substring}
 *
 * @author yanmingkun
 * @date 2020-04-23 10:42
 */
public class LongestPalindrome {
    /**
     * 判断当前字符串是否是回文串
     *
     * @param s
     * @return
     */
    public static boolean IfPalindrome(String s) {
        int len = s.length();
        int i = 0;
        while (s.charAt(i) == s.charAt(len - i)) {
            if (i == len - i || i + 1 == len - i) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * 算法一：动态规划算法,时间复杂度为O(n2),空间复杂度O(n2)
     * <p>
     * 算法：d[l][r]=true==>s[l]==s[i]&&d[l+1][r-1]==true
     * <p>
     *
     * @param s 输入字符串
     * @return
     */
    public static String dynamicPrograming(String s) {
        int len = s.length();
        if (s == null || len < 2) {
            return s;
        }
        int maxlength = 1;
        int maxLeft = 0;
        int maxright = 0;
        //二维数组
        boolean[][] dp = new boolean[len][len];

        /**
         * 先判断回文串去掉首尾的如果是回文串，只需要判断首尾字符相等
         */
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (r - l <= 2 && s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = true;
                }
                if (dp[l + 1][r - 1] && s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = true;
                }
                if (dp[l][r] && r - l + 1 > maxlength) {
                    maxlength = r - l + 1;
                    maxLeft = l;
                    maxright = r;
                }
            }

        }
        return s.substring(maxLeft, maxright + 1);
    }

    /**
     * 算法二： 中心扩散算法,时间复杂度为O(n2),空间复杂度O(1)
     * <p>
     * 算法：d[l][r]=true==>s[l]==s[i]&&d[l+1][r-1]==true
     * <p>
     *
     * @param s
     * @return
     */
    public static String centerExpend(String s) {
        int strLen = s.length();
        int len = 1;
        int left = 0;
        int right = 0;
        int maxLen = 1;
        int maxStart = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left > 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left > 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }

        }

        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static void main(String[] args) {
        String str = "asdghgdas";
        System.out.printf("输入字符串=%s，输出最长回文串=%s", str, dynamicPrograming(str));
        System.out.println();
        System.out.printf("输入字符串=%s，输出最长回文串=%s", str, centerExpend(str));

    }
}
