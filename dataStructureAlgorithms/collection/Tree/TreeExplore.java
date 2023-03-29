package dataStructureAlgorithms.collection.Tree;

import dataStructureAlgorithms.collection.TreeNode;

public class TreeExplore {

    public static void main(String[] args) {
        TreeExplore treeEx = new TreeExplore();
        BinaryTree tree = treeEx.createBinaryTree();
        //treeEx.displayTreeInOrder(tree);
        //treeEx.displayTreeInOrderStack(tree);
        //treeEx.displayTreePreOrder(tree);
        //treeEx.displayTreePreOrderStack(tree);
        //treeEx.displayTreePostOrder(tree);
        //treeEx.displayTreePostOrderWithStack(tree);
        treeEx.displayTreelevelOrder(tree);

    }


    private void dispalyTreePreOrderStack(BinaryTree tree) {
        System.out.println("\n Pre Order with Stack");
        tree.traversePreOrderWithStack(tree.root);
    }

    public BinaryTree createBinaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(13);
        bt.add(11);
        bt.add(2);
        bt.add(17);


        return bt;
    }

    public BinaryTree createBinaryTreeWithArray(){
        BinaryTree btObj = new BinaryTree();
        //implement btObj from an array
        return btObj;
    }

    private void displayTreeInOrder(BinaryTree tree){
        System.out.println("In Order: first visit the left sub-tree then the root node, and finally the right sub-tree.");
        tree.traverseInOrder(tree.root);
    }

    private void displayTreeInOrderStack(BinaryTree tree){
        System.out.println("In order With Stack: ");
        tree.traverseInOrderWithStack(tree.root);
    }

    private void displayTreePreOrder(BinaryTree tree) {
        System.out.println("Pre Order: visits first the root node, then the left sub-tree and the right sub-tree.");
        tree.traversePreOrder(tree.root);
    }

    private void displayTreePreOrderStack(BinaryTree tree) {
        System.out.println("Pre Order with Stack : visits first the root node, then the left sub-tree and the right sub-tree.");
        tree.traversePreOrderWithStack(tree.root);
    }

    private void displayTreePreOrderWithStack(BinaryTree tree){
        System.out.println("Post_Order with Stack : traverse down root left and right");
        tree.traversePreOrderWithStack(tree.root);
    }

    private void displayTreePostOrder(BinaryTree tree){
        System.out.println("Post-order : traversal visits the left sub-tree, the right sub-tree, and the root.");
        tree.traversePostOrder(tree.root);

    }

    private void displayTreePostOrderWithStack(BinaryTree tree){
        System.out.println("Post-order with Stack : traversal visits the left sub-tree, the right sub-tree, and the root.");
        tree.traversePostOrderWithStack(tree.root);
    }


    private void displayTreelevelOrder(BinaryTree tree){
        System.out.println("Level Order : visits all the levels of the tree starting from the root, and from left to right.");
        tree.traverseLevelOrderQueue(tree.root);
    }

}
