package com.cro.leetcode.daily.蓄水池抽样;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author cro
 * @description https://leetcode-cn.com/problems/random-pick-index/
 */
public class Q398随机数索引 {
    /**
     * hash表预处理
     * 有点暴力的解法
     */
    class Solution1 {
        HashMap<Integer, List<Integer>> map;
        Random random = new Random();
        public Solution1(int[] nums) {
            // 初始化
            map = new HashMap<Integer, List<Integer>>();
            // 遍历数组
            for (int i = 0; i < nums.length; i++) {
                // 如果该元素第一次出现
                if (!map.containsKey(nums[i])){
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    map.put(nums[i], index);
                }else{
                    // 该元素不是第一次出现
                    // 把索引添加到value中
                    map.get(nums[i]).add(i);
                }
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

    /**
     * 蓄水池解法
     */
    class Solution {
        int[] nums;
        Random random;
        public Solution(int[] nums) {
            // 初始化
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {
            //  记录有多少个符合要求的值
            // res 记录选中的值 最开始没有选中 -1
            int count = 0, res = -1;
            // 遍历当前数组
            for (int i = 0; i < nums.length; i++) {
                // 如果不是需要的数 跳过
                if (nums[i]!=target) continue;
                // 符合要求 增加总数
                count++;
                // 如果随机数产生的为0 替换掉res
                // 被选中的概率为 1/count
                // 选中索引
                if (random.nextInt(count) == 0) res = i;
            }
            return res;
        }
    }
}
