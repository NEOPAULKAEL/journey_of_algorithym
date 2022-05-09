package com.cro.leetcode.daily.bfs;

import java.util.*;

/**
 * BFS / 双向BFS
 *
 * @author cro
 * @description https://leetcode-cn.com/problems/word-ladder/
 */
public class Q127词语接龙 {
    /**
     * 双向BFS
     */
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 列表转换到hash表中 快速判断词是否合法
            Set<String> words = new HashSet<>(wordList.size());
            // 去掉起始的值
            words.remove(beginWord);
            for (String s : wordList) words.add(s);
            if(!words.contains(endWord)) return 0;
            // 两个列表记录每次变换的单词
            Set<String> beginVisted = new HashSet<>();
            Set<String> endVisted = new HashSet<>();
            // 记录走过的路径
            Set<String> visited = new HashSet<>();
            // 记录开头 和 结尾
            beginVisted.add(beginWord);
            endVisted.add(endWord);
            visited.add(beginWord);
            visited.add(endWord);
            int step=0;
            while (!beginVisted.isEmpty() && !endVisted.isEmpty()){
                // 先看那一边的遍历次数更少
                // 假设 beginVistied是最少的哪一个
                if (beginVisted.size() > endVisted.size()){
                    Set<String> tmp = beginVisted;
                    beginVisted = endVisted;
                    endVisted = tmp;
                }
                // 进行单词的遍历
                Set<String> nextLevelVisited = new HashSet<>();
                for (String word : beginVisted){
                    char[] chars = word.toCharArray();
                    for (int i =0;i<word.length();i++){
                        char orignalChar = chars[i];
                        for (char c= 'a';c<='z';c++){
                            if (orignalChar == c) continue;
                            chars[i] =c;
                            String nextWord = new String(chars);
                            if (!words.contains(nextWord)) continue;
                            if (endVisted.contains(nextWord)) return step+1;
                            if (visited.contains(nextWord)) continue;
                            nextLevelVisited.add(nextWord);
                            visited.add(nextWord);
                        }
                        chars[i] = orignalChar;
                    }
                }
                beginVisted = nextLevelVisited;
                step++;
            }
            return 0;
        }
    }

    /**
     * BFS
     */
//    class Solution {
//        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            // 列表转换到hash表中 快速判断词是否合法
//            Set<String> words = new HashSet<>(wordList.size());
//            // 去掉起始的值
//            words.remove(beginWord);
//            for (String s : wordList) words.add(s);
//            // 队列记录需要遍历的元素
//            Deque<String> q = new ArrayDeque<>();
//
//            // 记录走过的节点 单词：变成这个单词的步数
//            Set<String> visited = new HashSet<>();
//            // 记录开头 和 结尾
//            q.add(beginWord);
//            visited.add(beginWord);
//            // 记录改变步数 开始为1 包含起点！
//            int step = 1;
//            while (!q.isEmpty()) {
//                // 记录q的size 因为出队入队长度会一直变化
//                int sz = q.size();
//                for (int i = 0; i < sz; i++) {
//                    // 取出第一个 队列先进先出
//                    String s = q.pollFirst();
//                    char[] chars = s.toCharArray();
//                    // 对每一位进行改变
//                    for (int j = 0;j<endWord.length();j++){
//                        char originalChar = chars[j];
//                        // 每一个位置 都可以在a-z之间变化
//                        for (char k = 'a'; k<='z';k++){
//                            // 如果当前位字符没有变化
//                            if (originalChar == k) continue;
//                            // 改变当前位置
//                            chars[j] = k;
//                            String nextWord = new String(chars);
//                            // 如果新组成的单词不在字典中
//                            if (!words.contains(nextWord)) continue;
//                            // 如果变换到了结尾
//                            if (endWord.equals(nextWord)) return step + 1;
//                            // 如果当前单词已经访问过
//                            if (visited.contains(nextWord)) continue;
//                            // 新的单词合法 且 没有访问过
//                            q.addLast(nextWord);
//                            // 标记为已经访问
//                            visited.add(nextWord);
//                        }
//                        // 一个位置更换为所有字符后
//                        // 把当前位置还原回去(因为一次只能改变一个字符)
//                        chars[j] = originalChar;
//                    }
//                }
//                // 在这里++ 因为候选单词都在queue中，每次取出来步数+1
//                step++;
//            }
//            // 队列走完之后 没有找到endword
//            return 0;
//        }
//    }
}
