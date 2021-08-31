/**
 * This is the Tree class from Java:How to Program 11th Edition
 * @param <E>
 */
public class Tree<E extends  Comparable<E>> {
    /**
     * This is the root node
     * Also from Java:How to Program 11th Edition
     */
    private TreeNode<E> root;

    // constructor initializes an empty Tree of integers

    /**
     * Tree constructor
     * Also from Java:How to Program 11th Edition
     */
    public Tree() {root = null;}

    // insert a new node in the binary search tree

    /**
     * Inserting Node method
     * Also from Java:How to Program 11th Edition
     * @param insertValue Element E
     */
    public void insertNode(E insertValue) {
        if (root == null) {
            root = new TreeNode<E>(insertValue); // create root node
        }
        else {
            root.insert(insertValue); // call the insert method
        }
    }

    // begin preorder traversal

    /**
     * PreorderTraversal that just calls the helper method
     * Also from Java:How to Program 11th Edition
     */
    public void preorderTraversal() { preorderHelper(root);}

    // recursive method to perform preorder traversal

    /**
     * Helper method to in order traversal
     * Also from Java:How to Program 11th Edition
     * @param node Takes in a node argument
     */
    private void inorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        //left, node, right
        inorderHelper(node.leftNode); // traverse left subtree
        System.out.printf("%s ", node.data); // output node data
        inorderHelper(node.rightNode); // traverse right subtree
    }

    // begin inorder traversal

    /**
     * In order traversal method, just calls helper method
     * Also from Java:How to Program 11th Edition
     */
    public void inorderTraversal() { inorderHelper(root);}

    // recursive method to perform inorder traversal

    /**
     * Post order helper method
     * Also from Java:How to Program 11th Edition
     * @param node Takes in node argument
     */
    private void postorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        //left,right, node
        postorderHelper(node.leftNode); // traverse left subtree
        postorderHelper(node.rightNode); // traverse right subtree
        System.out.printf("%s ", node.data); // output node data
    }

    // begin postorder traversal

    /**
     * Post order traversal method, just calls helper method
     * Also from Java:How to Program 11th Edition
     */
    public void postorderTraversal() { postorderHelper(root);}

    // recursive method to perform postorder traversal

    /**
     * Preorder helper method
     * Also from Java:How to Program 11th Edition
     * @param node Takes node argument
     */
    private void preorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        //node,left,right
        System.out.printf("%s ", node.data); // output node data
        preorderHelper(node.leftNode); // traverse left subtree
        preorderHelper(node.rightNode); // traverse right subtree
    }

    /**
     * Output tree function
     * Calls the outputTreeHelper method
     */
    public void outputTree(){
        outputTreeHelper(root,0);
    }

    /**
     * outputTreeHelper method, recursive function to print the trees
     * @param node Takes in a TreeNode node
     * @param depth Takes in an int for depth for better visualization
     */
    private void outputTreeHelper(TreeNode<E> node,int depth){
        if (node == null) { // if the node is null
            return;
        }

        outputTreeHelper(node.rightNode, depth+1); // traverse right subtree, depth +1
        for(int i =0; i < depth*5; i++){ // adding 5 spaces between 'vertical rows'
            System.out.print(" ");
        }
        System.out.println(node.data); // output node data
        outputTreeHelper(node.leftNode,depth+1); // traverse left subtree

    }
  }
