/**
 * This TreeNode class is directly from the textbook example, nothing here was changed
 * Derived from: Java:How to Program 11th Edition
 * @param <E>
 */
public class TreeNode<E extends Comparable<E>> {
    TreeNode<E> leftNode; //leftnode
    E data; // node value
    TreeNode<E> rightNode; //rightnode

    // constructor initializes data and makes this a leaf node

    /**
     * Constructor that initializes data and makes a left node
     * Also from Java:How to Program 11th Edition
     * @param nodeData
     */
    public TreeNode(E nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // node has no children
    }
    // locate insertion point and insert new node; ignore duplicate values

    /**
     * Inserts new node, and ignores duplicates
     * Also from Java:How to Program 11th Edition
     * @param insertValue
     */
    public void insert(E insertValue){
        // insert in left subtree
        if (insertValue.compareTo(data) < 0) {
            // insert new TreeNode
            if (leftNode == null) {
                leftNode = new TreeNode<E>(insertValue);
            }
            else { // continue traversing left subtree recursively
                leftNode.insert(insertValue);
            }
        }
                 // insert in right subtree
        else if (insertValue.compareTo(data) > 0) {
            // insert new TreeNode
            if (rightNode == null) {
                rightNode = new TreeNode<E>(insertValue);
            }
            else { // continue traversing right subtree recursively
                rightNode.insert(insertValue);
            }
        }
    }

}
