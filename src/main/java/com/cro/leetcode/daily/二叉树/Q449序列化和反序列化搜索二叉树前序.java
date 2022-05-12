package com.cro.leetcode.daily.二叉树;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author cro
 * @description https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class Q449序列化和反序列化搜索二叉树前序 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {
        public static final String SEP = ",";
        public static final String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            traversal(sb, root);
            return sb.toString();
        }
        public void traversal(StringBuffer sb, TreeNode node){
            if (node == null){
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(node.val).append(SEP);
            traversal(sb,node.left);
            traversal(sb,node.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] split = data.split(SEP);
            LinkedList<String> nodes = new LinkedList<>();
            Collections.addAll(nodes, split);
            return deserialize(nodes);
        }
        public TreeNode deserialize(LinkedList<String> nodes){
            // nodes为空 返回空
            if (nodes == null) return null;
            String first = nodes.removeFirst();
            if (first.equals(NULL)){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }
        
        
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
}
