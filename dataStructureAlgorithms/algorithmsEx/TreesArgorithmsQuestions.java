package dataStructureAlgorithms.algorithmsEx;

import dataStructureAlgorithms.collection.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreesArgorithmsQuestions {

    boolean isBalancedTree = true;//global variable for isBalanced method
    int diameter = 0;
    private TreeNode root;

    public static void main(String[] args) {

    }

    public boolean isSymmetricTree(TreeNode root){
        /*
        101. Symmetric Tree - https://leetcode.com/problems/symmetric-tree/
        https://www.youtube.com/watch?v=F85boSPtfKg&list=PLK0ZC7fyo01IN6L3X2c7VKL6ErjIIj88d
        https://leetcode.com/problems/symmetric-tree/discuss/2179582/Symmetric-tree-or-0ms
        https://leetcode.com/problems/symmetric-tree/discuss/2179854/Java-Easy-Solution-O(n)-and-O(1)-or-O(N)-Auxilary-oror-Clean-Code
        Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

        **both side must exist in order to be symmetric
        check if root.left and root.right is same - as mirror image
         */
        //if root is null return true
        //otherwise, create a recursive method and pass left and right node
        //if left and right is null return true.
        //if either left or right is null return false( since the code already checked if both node are null)
        //if left.val is not equals to right.val return false( it assume that either left and right is not null so check the value)
        //return boolean value with helper method recursively with left.right and right.left node pass

        return false;

    }

    public TreeNode invertTree(TreeNode root){
        /*
        226. Invert Binary Tree - https://leetcode.com/problems/invert-binary-tree/
         */
        return root;
    }

    /*https://leetcode.com/problems/maximum-depth-of-binary-tree/

        Given the root of a binary tree, return its maximum depth.
        A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

        there are several ways to solve the problems
        1. Depth First Search with recursive
        2. iterative Depth First Search
        3. iterative Breath First Search
       */

    //1. Depth First Search with recursive
    public int maxDepthRecursive(TreeNode root){
        //https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/2607224/Java-oror1-lineoror-DFSoror-0ms-oror-simple-solution-oror
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));

    }

    //2. iterative Depth First Search
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/2536032/bfs-traversal
    public int maxDepthDfsIterative(TreeNode root){
        if(root == null){
            return 0;
        }
        Stack<TreeNode> treeStack = new Stack<>();
        int level = 0;
        TreeNode curr = root;
        treeStack.push(curr);
        while(!treeStack.isEmpty()){
            level++;

            for(int i = 0; i < treeStack.size(); i++) {
                curr = treeStack.pop();
                System.out.print(" " + curr.value);

                if (curr.left != null) {
                    treeStack.push(curr.left);
                }
                if (curr.right != null) {
                    treeStack.push(curr.right);
                }
            }

        }
        return level;
    }

    //3. Breath First Search - level order traverse (Queue or Dequeue)
    public int maxDepthBfsIterative(TreeNode root){

        if(root == null){
            return 0;
        }

        int levelCnt = 0;

        Queue<TreeNode> level = new LinkedList<>();
        //add root to the linkedList
        level.add(root);

        while(!level.isEmpty()){
            levelCnt++;
            for(int i = 0; i < level.size() ; i++) {
                //remove the root from the linkedList(Queue)
                TreeNode tempRoot = level.poll();
                if(tempRoot == null){
                    break;
                }
                if (tempRoot.left != null) {
                    //add left node to the linkedList(Queue)
                    level.add(tempRoot.left);
                }
                if (tempRoot.right != null) {
                    //add right node to the linkedList(Queue)
                    level.add(tempRoot.right);
                }
            }

        }

        return levelCnt;

    }

    public boolean isBalancedTree(TreeNode root){
        /*
        110. Balanced Binary Tree - https://www.youtube.com/watch?v=QfJsau0ItOY
        https://leetcode.com/problems/balanced-binary-tree/discuss/2179047/Very-Easy-5-Liner-Java-Solution

        bottom up approach
        check the height of each node recursively from the leaf node.
        if the node is a leaf return 1 (height)  to parent as recursive.
        as the check go up to parent, check absolute value of subtract one node to the other
        if the absolute value is greater than 1 the children is not balanced and set the flag to false.
        once any children
         */
        height(root);
        return isBalancedTree;

    }
    //this is helper method to get the height of binaryTree in recursively.
    private int height(TreeNode root){
        /*

    if the root is null it return 0 otherwise choose max value of left or right and add 1 for the parent node.
    at any point if the value between laft and right is greater than 1 the binary tree is not balanced.
    */
        //if the root is null return 0
        if(root == null){
            return 0;
        }
        //fi there are children, keep going down to children
        int leftH = height(root.left);
        int rightH = height(root.right);

        //at any point of node, if the difference between left and right is greater than 1,
        //the Binarytree is not balanced so simply set class variable to false
        if(Math.abs(leftH-rightH) > 1){
            isBalancedTree = false;
        }

        //if the difference is not greaten than 1 return maximum vlaue between left or right add to 1 for current node.
        return Math.max(leftH, rightH) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root){
        /*
        543. Diameter of Binary Tree
        https://leetcode.com/problems/diameter-of-binary-tree/discuss/2579262/Runtime%3A-0-ms-faster-than-100.00-JAVA-solution
            Given the root of a binary tree, return the length of the diameter of the tree.
            The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
            This path may or may not pass through the root.
            The length of a path between two nodes is represented by the number of edges between them.
         */
        treeDiameter(root);
        return diameter;
    }

    private int treeDiameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHieght = treeDiameter((root.left));
        int rightHeight = treeDiameter(root.right);
        diameter = Math.max((leftHieght + rightHeight), 1);
        return Math.max(leftHieght, rightHeight) + 1;
    }


}
