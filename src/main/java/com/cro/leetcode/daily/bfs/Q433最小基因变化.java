package com.cro.leetcode.daily.bfs;

import java.util.*;

/**
 * @author cro
 * @description https://leetcode.cn/problems/minimum-genetic-mutation/
 */
public class Q433最小基因变化 {
    public class Solution {
        // 能进行变更的基因
        char[] items = {'A', 'C', 'G', 'T'};

        public int minMutation(String start, String end, String[] bank) {
            // set转存bank
            Set<String> banks = new HashSet<>(bank.length);
            for (String s : bank) {
                banks.add(s);
            }
            // 从 start 开始 每次变更一个位置
            // 边界条件 ： 1.合法 - 在bank中 2.bank中有剩余 3.end不在bank中
            // BFS 用队列
            Deque<String> d = new ArrayDeque<>();
            // 记录每一个合法的'变异' 位置和到达需要的'变异'次数
            HashMap<String, Integer> map = new HashMap<>();
            // 加入初始位点
            d.add(start);
            map.put(start, 0);
            // 开始bfs遍历
            while (!d.isEmpty()) {
                int size = d.size();
                while (size-- > 0) {
                    String s = d.poll();
                    char[] chars = s.toCharArray();
                    int step = map.get(s);
                    for (int i = 0; i < chars.length; i++) {
                        // 开始'变异'
                        for (char c : items) {
                            // 如果基因相同（无需变异） 跳过
                            if (c == chars[i]) continue;
                            // 产生变异
                            char[] clone = chars.clone();
                            clone[i] = c;
                            String newGen = new String(clone);
                            // 是否合法 不合法 跳过
                            if (!banks.contains(newGen)) continue;
                            // 如果已经记录过变异 跳过
                            if (map.containsKey(newGen)) continue;
                            // 判断是否到达终点
                            if (end.equals(newGen)) return step + 1;
                            //合法变异
                            // 一定要step+1 或者++step step++的时候 放入之后才会加一
                            map.put(newGen, step+1);
                            d.add(newGen);
                        }
                    }
                }
            }
            return -1;

        }
    }
}
