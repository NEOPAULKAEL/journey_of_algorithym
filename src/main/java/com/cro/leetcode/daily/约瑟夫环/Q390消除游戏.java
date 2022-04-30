package com.cro.leetcode.daily.约瑟夫环;

/**
 * @author cro
 * @description https://leetcode-cn.com/problems/elimination-game/
 */
public class Q390消除游戏 {
    class Solution {
        //https://leetcode-cn.com/problems/elimination-game/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-k2uj/
        public int lastRemaining(int n) {
            // 每回合更新头部位置
            int head = 1;
            // 每次的步进
            int step = 1;
            // 从左边开始消除
            boolean left = true;
            // n==1 的时候 只剩一个元素
            while (n>1){
                // 当n%2==1 或者 左边开始的时候 需要移动head
                // 奇数个 从右边开始消除 第一个总会被消除掉
                if (n%2 != 0 || left){
                    // head根据当前步进 移动位置
                    head += step;
                }
//                step *= 2; step*2
                step <<= 1;
                // n/2
                n >>= 1;
                left = !left;
            }
            return head;
        }
    }

    /**
     *
     * // todo 存在问题
     */
    class Solution2 {
        public int lastRemaining(int n) {
//            1-N之间的所有整数
//            先左边按照1步间隔消除（第一个一定消除）
//            再从右边按照一步间隔消除
            return elimination(n, true, 1, 1);
        }

        /**
         *
         * @param n 总数
         * @param left 是否左边开始
         * @param head 头指向的位置
         * @param step 步进
         * @return
         */
        public int elimination(int n, boolean left, int step, int head){
            // 只剩一个元素 找到了 返回
            if (n == 1){
                return head;
            }
            // 从左边消除
            if (left){
                // head 右移一位
                head += step;
                //步进 *2
                step *= 2;
                // n总数 = n/2
                n /= 2;
                // 反转位置
                left = !left;
            }else if (!left && n%2 == 1){
                // 如果是从右边开始 并且总数是奇数个 这个时候 第一个元素肯定会被消除
                // 所以head需要移动一位
                // head 右移一位
                head += step;
                //步进 *2
                step *= 2;
                // n总数 = n/2
                n /= 2;
                // 反转位置
                left = !left;
            }else {
                //步进 *2
                step *= 2;
                // n总数 = n/2
                n /= 2;
                // 反转位置
                left = !left;
            }
            // 进入下一步
            elimination(n, left, step, head);
            return head;
        }
    }

}
