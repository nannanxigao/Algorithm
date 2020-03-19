package com.gn.algorithm;

public class 字符串压缩 {
    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * <p>
     * 示例1:
     * <p>
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * 示例2:
     * <p>
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/compress-string-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {


        System.out.println(compressString(""));

    }


    public static String compressString(String S) {
        if (S.equals("")) {
            return "";
        }

        int j = 1;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                sb.append(chars[i - 1]).append(j);
                j = 0;

            }
            j++;
        }

        sb.append(chars[chars.length - 1]).append(j);

        if (sb.length() < chars.length) {
            return sb.toString();
        } else {
            return String.valueOf(chars);
        }
    }

}
