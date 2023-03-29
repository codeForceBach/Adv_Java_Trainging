package dataStructureAlgorithms.collection.Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeExploreTest {

    TreeExplore treeTest = new TreeExplore();

    @Test
    public void validateContainsElementInBinaryTreeTest(){
        BinaryTree bt = treeTest.createBinaryTree();

        assertTrue(bt.containTreeNode(6));
        assertTrue(bt.containTreeNode(4));
        assertFalse(bt.containTreeNode(1));
    }


}