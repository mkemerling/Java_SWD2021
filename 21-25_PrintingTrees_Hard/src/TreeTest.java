import java.security.SecureRandom;

/**
 * Public TreeTest is where the main method lies, this is the driver for the progrram
 */
public class TreeTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        //Creating a new value array of the textbook example numbers
        int[] valueArray = new int[] {49,83,28,97,71,40,18,99,92,72,69,44,32,19,11};

        System.out.println("Inserting the following values: ");

        //putting the values into the tree
        for (int j : valueArray) {
            System.out.printf("%d ", j);
            tree.insertNode(j); //inserting value to node
        }

        //preorder
        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        //in order
        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        //post order
        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();

        tree.outputTree(); // printing the tree
    }
}
