package dataStructureAlgorithms.collection.Tree;

import dataStructureAlgorithms.collection.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

//https://www.baeldung.com/java-binary-tree
//https://www.baeldung.com/java-depth-first-search
//https://www.baeldung.com/java-breadth-first-search

public class BinaryTree {
    TreeNode root;
    int[] binaryArray;
    List<Integer> binaryList;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode curr, int value){
        /*
        if the new node's value is lower than the current node, go to left
        if the new node's value is greater than the current node, go to right
        if the current node is null, it reached a leaf node and simply insert node in that position
         */

        if(curr == null){
            return new TreeNode(value);
        }
        if(value < curr.value){
            curr.left = addRecursive(curr.left, value);
        } else if(value > curr.value){
            curr.right = addRecursive(curr.right, value);
        } else {
            return curr;
        }
        return curr;
    }

    public boolean containTreeNode(int value){
        return containsTreeNodeRecursive(root, value);
    }

    private boolean containsTreeNodeRecursive(TreeNode curr, int value){
        if(curr == null){
            return false;
        }
        if(value == curr.value){
            return true;
        }
        return value < curr.value
                ? containsTreeNodeRecursive(curr.left, value)
                : containsTreeNodeRecursive(curr.right, value);
    }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode curr, int value){
        if(curr == null){
            return null;
        }

        if(value < curr.value){
            curr.left = deleteRecursive(curr.left, value);
            return curr;
        } else if(value > curr.value) {
            curr.right = deleteRecursive(curr.right, value);
            return curr;
        } else {//if(curr.value == value)

                if(curr.left == null && curr.right == null){
                    return null;
                }
                if (curr.right == null){
                    return curr.left;
                }
                if(curr.left == null){
                    return curr.right;
                }
            int smallestValue = fineSmallestValue(curr.right);
            curr.value = smallestValue;
            curr.right = deleteRecursive(curr.right, smallestValue);
            return curr;

            }//end if else

        }

    private int fineSmallestValue(TreeNode curr){
        return curr.left == null ? curr.value : fineSmallestValue(curr.left);

    }

    /*
    Depth-first Search  - in-order, pre-order, post-order
    in-order traversal consists of first visiting the left sub-tree then the root node and finally the right sub tree.
     */
    public int[] traverseInOrder(TreeNode node){
       if(node != null){
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
           binaryList.add(node.value);
           traverseInOrder(node.right);
        }
       return convertToIntArray(binaryList);
    }

    public int [] traverseInOrderWithStack(TreeNode node){
        //to store all the node from left most tree and root and right
        Stack<TreeNode> treeStack = new Stack<>();
        //to store all the node to ArrayList and return
        binaryList = new ArrayList<>();
        TreeNode curr = node;
        while (curr != null || !treeStack.isEmpty()){
            //as long as the node is not null, store in stack and move to left node
            while(curr != null){
                treeStack.push(curr);
                curr = curr.left;
            }
            //after the node reach null in the most depth left node,
            //add them to list from the top( which by default most depth left node to be stored
            TreeNode top = treeStack.pop();
            System.out.print(" " + top.value);
            binaryList.add(top.value);
            curr = top.right;
        }
        return convertToIntArray(binaryList);
    }

    /*
    pre-order traversal visits first the root and the left sub tree and right sub tree
     */
    public void traversePreOrder(TreeNode node){
        if(node != null){
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public int [] traversePreOrderWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();//first in (bottom of stack) last out
        binaryList = new ArrayList<>();
        TreeNode curr = node;
        stack.push(node);
        while(!stack.isEmpty()){
            curr = stack.pop();//remove existing stack and assign to curr node
            System.out.print(" " + curr.value);
            binaryList.add(curr.value);
            //stack the right node first so that after the left node got pop right value would pop
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return convertToIntArray(binaryList);
    }

    public List<Integer> traversePreOrderWithStackLeetcode(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.empty()){
            while (curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.value);
            curr = curr.right;
        }
        return result;
    }

    /*
    post-order traversal visits the left sub tree, the right sub tree then root
     */
    public void traversePostOrder(TreeNode node){
        if(node != null){
            traversePostOrder(node.left);;
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public int [] traversePostOrderWithStack(TreeNode root){
        Stack<TreeNode> treeStack = new Stack<>();
        binaryList = new ArrayList<>();
        TreeNode prev = root;
        TreeNode curr = root;
        treeStack.push(root);

        while(!treeStack.isEmpty()){
            curr = treeStack.peek();
            boolean hasChild = (curr.left != null || curr.right != null);
            boolean isPrevLastChild = (prev == curr.right ||(prev == curr.left && curr.right == null));

            if(!hasChild || isPrevLastChild){
                curr = treeStack.pop();
                System.out.print(" " + curr.value + ",");
                binaryList.add(curr.value);
                prev = curr;
            } else {
                if (curr.right != null){
                    treeStack.push(curr.right);
                }
                if(curr.left != null){
                    treeStack.push(curr.left);
                }
            }

        }
        return convertToIntArray(binaryList);
    }

    /*
    Breadth-Frist Search - visits all the nodes of a level of the tree starting from the root, left and right, before going to the next level
    to implement this search, use Queue to hold the node from each level in order extract each node from the list then its children to the queue
     */
    public List<Integer> traverseLevelOrderQueue(TreeNode node){
        if(node == null){
            return binaryList;
        }
        binaryList = new ArrayList<>();

        Queue<TreeNode> qListNode = new LinkedList<>();
        qListNode.add(node);

        while(!qListNode.isEmpty()){
            TreeNode tNode = qListNode.remove();
            System.out.print(" " + tNode.value);

            binaryList.add(tNode.value);

            if(tNode.left != null){
                qListNode.add(tNode.left);
            }
            if(tNode.right != null){
                qListNode.add(tNode.right);
            }

        }
        return binaryList;
    }

    //using java stream: https://www.techiedelight.com/convert-list-integer-array-int/
    private int[] convertToIntArray(List<Integer> list){
        //int[] intArray = list.toArray(new Integer[0]); not working -->
        int [] intArray = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();;
        return intArray;
    }

    //using java stream: https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java//
    private List<Integer> convertToIntegerList(int [] intArray){
        //List<Integer> list = Arrays.asList(intArray);not working -->
        List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        return list;
    }

}
