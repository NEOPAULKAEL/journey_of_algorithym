package com.cro.leetcode.daily;

/**
 * @author cro
 * @description https://leetcode.cn/problems/largest-triangle-area/
 */
public class Q812最大三角形 {
    class Solution {
        public double largestTriangleArea(int[][] points) {
            //三重循环
            double res = 0;
            int n = points.length;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i+1; j < n - 1; j++) {
                    for (int k = j+1; k < n; k++) {
                        // 取出选择的三个点
                        int[] a = points[i];
                        int[] b = points[j];
                        int[] c = points[k];
                        int x1 = a[0],y1 = a[1];
                        int x2 = b[0],y2 = b[1];
                        int x3 = c[0],y3 = c[1];
                        res = Math.max(res,
                                0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
                    }
                }
            }
            return res;
        }
    }
}
