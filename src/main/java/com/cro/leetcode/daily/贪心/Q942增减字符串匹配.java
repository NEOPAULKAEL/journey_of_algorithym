package com.cro.leetcode.daily.贪心;

/**
 * 贪心+双指针
 * 贪心三个条件： 1.最优子结构 规模较大的问题由规模较小的子问题组成，规模较大的问题的解只有其中一个规模较小的子问题决定
 * 2.无后效性：后面的解不会影响之前已经解出来的
 * 3.从局部最优可以得到全局最优
 *
 *  'I' perm[i]<perm[i+1]
 *  'D' perm[i]>perm[i+1]
 *  --> 如果第一个字符为I，我们就给perm[0]赋值0，此时取数范围变成[1,n]，无论给哪个，都成立
 *  --> 如果第一个字符为D，perm[0]=n,此时范围变成[0,n-1],后续依旧成立
 *  --> 当字符为I时，就把当前最小的值付给这一位
 *  --> 当字符为D时，就把当前最大的值赋给这一位
 *  到了结尾的时候 min == max,我们只需要填充最后一位就好了
 * @author cro
 * @description https://leetcode.cn/problems/di-string-match/
 */
public class Q942增减字符串匹配 {
    class Solution {
        public int[] diStringMatch(String s) {
            int n = s.length(), min = 0, max = n;
            int[] ans = new int[n + 1];
            for (int i = 0; i < n; i++) {
                ans[i] = s.charAt(i) == 'I' ? min++ : max--;
            }
            ans[n] = min;
            return ans;
        }
    }
}
