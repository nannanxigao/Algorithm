package com.gn.algorithm;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */

    public static void main (String[] args) {

        int[] nums = {3,3};

        System.out.println(toString(twoSum2(nums, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] results = new int[2];

        for (int i = 0; i < nums.length; i++) { //循环极限为(n^2-n)/2
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        results[0] = nums[i];
                        results[1] = nums[j];
                        i = nums.length;
                        break;
                    }
                }
        }

        return results;
    }

    public static int[] twoSumMap(int[] nums, int target) {
        int [] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                if (map.get(target - nums[i]) != i) {
                    results[0] = i;
                    results[1] = map.get(target - nums[i]);
                }
            }
        }

//        for (int i : map.keySet()) {  错误 map去重了 如果是【3，3】就错了
//            if (map.get(target - i) != null) {
//                if (map.get(target - i) != map.get(i)) {
//                    results[0] = map.get(target - i);
//                    results[1] = map.get(i);
//                }
//            }
//        }

        return results;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }


        // // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        return indexs;
    }


    public static String toString(int[] nums) {

        StringBuilder sb = new StringBuilder();

        for (int i : nums) {
            sb.append(i);
        }

        return sb.toString();
    }
}
