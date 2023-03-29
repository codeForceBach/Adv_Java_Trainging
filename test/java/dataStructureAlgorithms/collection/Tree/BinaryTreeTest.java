package dataStructureAlgorithms.collection.Tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree biTree = new BinaryTree();

    //**Use stream to convert int[] or Arraylist<Integer> to compare contents equality

    //using java stream: https://www.techiedelight.com/convert-list-integer-array-int/
    private int[] convertToIntArray(List<Integer> list){
        //int[] intArray = list.toArray(new Integer[0]); not working -->
        int [] intArray = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return intArray;
    }

    //using java stream: https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java//
    private List<Integer> convertToIntegerList(int [] intArray){
        //List<Integer> list = Arrays.asList(intArray);not working -->
        List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        return list;
    }

    @Test
    void containTreeNodeTest() {
        //create same binaryTree as TreeExplore.createBinaryTree
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17};
        for(int i: intTree) {
            biTree.add(i);
        }
        assertTrue(biTree.containTreeNode(17));
        assertFalse(biTree.containTreeNode(29));
    }

    @Test
    void deleteTreeNodeTest() {
        //create same binaryTree as TreeExplore.createBinaryTree
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        for(int i: intTree) {
            biTree.add(i);
        }
        //assertTrue(biTree.containTreeNode(9));
        biTree.delete(13);
        assertFalse(biTree.containTreeNode(13));
    }

    @Test
    void traverseLevelOrderQueueTest() {
        System.out.println("Breadth-First Search (Level Order) : visits all the noide before going to next levels of the tree starting from the root, and from left to right.");
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 2, 13, 11, 17, 15, 19};
        for(int i: intTree) {
            biTree.add(i);
        }
        List<Integer> levelOrder = biTree.traverseLevelOrderQueue(biTree.root);

        // created private method to do the conversion at the top
        int[] copyTree = convertToIntArray(levelOrder);
        assertTrue(Arrays.equals(intTree, copyTree));

        // created private method to do the conversion at the top
        List<Integer> treeOrder = convertToIntegerList(intTree);
        assertTrue(treeOrder.equals(levelOrder));

    }

    @Test
    void traverseInOrderWithStackTest() {
        System.out.println("In Order: first visit the left sub-tree then the root node, and finally the right sub-tree.");

        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        for (int i : intTree) {
            biTree.add(i);
        }
        int[] inOrder = biTree.traverseInOrderWithStack(biTree.root);

        int[] returnArray = {2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 19};
        assertTrue(Arrays.equals(returnArray, inOrder));

    }

    @Test
    void traversePreOrderWithStackTest() {
        System.out.println("Pre-Order: visits first the root and the left sub tree and right sub tree");
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        for (int i : intTree) {
            biTree.add(i);
        }
        int[] preOrder = biTree.traversePreOrderWithStack(biTree.root);

        int [] preOrderArray = {6, 4, 3, 2, 5, 8, 7, 9, 13, 11, 17, 15, 19};
        assertTrue(Arrays.equals(preOrderArray, preOrder));
    }

    @Test
    void traversePostOrderWithStackTest() {
        System.out.println("post-Order: visits the left sub tree, the right sub tree then root");
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        for (int i : intTree) {
            biTree.add(i);
        }
        int [] postOrder = biTree.traversePostOrderWithStack(biTree.root);

        int [] returnPostOrderArray = {2, 3, 5, 4, 7, 11, 15, 19, 17, 13, 9, 8, 6};

        assertTrue(Arrays.equals(postOrder, returnPostOrderArray));
    }

    @Test
    void traversePreOrderWithStackLeetcodeTest() {
        System.out.println("in-Order: visits the root left sub tree, the right sub tree");
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        for (int i : intTree) {
            biTree.add(i);
        }
        List<Integer> inOrder = biTree.traversePreOrderWithStackLeetcode(biTree.root);
    }

}