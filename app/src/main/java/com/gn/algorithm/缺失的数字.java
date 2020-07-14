package com.gn.algorithm;

public class 缺失的数字 {
    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例 1:
     *
     * 输入: [0,1,3]
     * 输出: 2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println("result:" + missingNumber1(nums));
    }

    /**
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int result = 0;
        if (nums[0] != 0) { //针对{1}的情况
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                if (i == nums.length - 1) { // 针对{0},{0,1}等没有最后一个数的情况
                    return nums.length;
                } else {
                    continue;
                }
            } else { // 在中间缺失一个数的情况
                return i;
            }
        }
        return result;
    }

    public static int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }



}
