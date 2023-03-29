package dataStructureAlgorithms.algorithmsEx;

import dataStructureAlgorithms.collection.Tree.BinaryTree;
import dataStructureAlgorithms.collection.Tree.TreeExplore;
import dataStructureAlgorithms.collection.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreesArgorithmsQuestionsTest {

    TreesArgorithmsQuestions treeQ = new TreesArgorithmsQuestions();
    BinaryTree biTree = new BinaryTree();
    int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
    int [] balanceTree = {9, 5, 14, 3, 7, 12, 18, 2, 4, 6, 8, 11, 13, 15, 20};

    @Test
    void maxDepthTest() {

    }

    @Test
    void maxDepthRecursiveTest() {
        for (int i : intTree) {
            biTree.add(i);
        }
        int maxDepth = treeQ.maxDepthDfsIterative(biTree.getRoot());
        assertEquals(6, treeQ.maxDepthRecursive(biTree.getRoot()));
    }

    @Test
    void maxDepthDfsIterativeTest() {
        for (int i : intTree) {
            biTree.add(i);
        }
        assertEquals(6, treeQ.maxDepthDfsIterative(biTree.getRoot()));
    }

    @Test
    void maxDepthBfsIterativeTest() {
        for (int i : intTree) {
            biTree.add(i);
        }
        assertEquals(6, treeQ.maxDepthBfsIterative(biTree.getRoot()));
    }

    @Test
    void diameterOfBinaryTreeTest() {
        for (int i : balanceTree) {
            biTree.add(i);
        }
        assertEquals(8, treeQ.diameterOfBinaryTree(biTree.getRoot()));
    }

    @Test
    void isBalancedTreeTest() {
        for (int i : balanceTree) {
            biTree.add(i);
        }
        assertTrue(treeQ.isBalancedTree(biTree.getRoot()));
    }
}