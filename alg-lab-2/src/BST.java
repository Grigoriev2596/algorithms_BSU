import java.util.ArrayList;

class Node {
    int key; 
    Node left, right; 
   
    public Node(int data){ 
        key = data; 
        left = right = null; 
    } 
} 

class BST {

    static final int COUNT = 5;
    // BST root node 
    Node root;
    int n = 0;
   
    BST(){
        root = null; 
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.key) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.key) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
        n++;
    }

    public void buildTree(int[] arr) {
        for(int el : arr) {
            add(el);
        }
    }


    static void printTree(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        printTree(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");
        // Process left child
        printTree(root.left, space);
    }


    ArrayList<Integer> inorder(Node node, ArrayList<Integer> list)
    {
        if (node == null)
            return list;
        /* first recur on left child */
        inorder(node.left, list);

        /* then print the data of node */
        list.add(node.key);

        /* now recur on right child */
        inorder(node.right, list);
        return list;
    }


    ArrayList<Integer> reverseInorder(Node node, ArrayList<Integer> list)
    {
        if (node == null)
            return list;

        /* first recur on left child */
        reverseInorder(node.right, list);

        /* then print the data of node */
        list.add(node.key);

        /* now recur on right child */
        reverseInorder(node.left, list);

        return list;
    }

    public int kthSmallestEl(int k) {
        return getInorder().get(k - 1);
    }
    public int kthSmallestEl(Node root, int k) {
        return getInorder(root).get(k - 1);
    }

    public Node getBalancedRoot(Node root, int k) {
        int smallestKth = kthSmallestEl(root, k+1);

        if (smallestKth < root.key) {
            while(root.key != smallestKth) {
                root = rotateRight(root);
            }
        } else {
            while(root.key != smallestKth) {
                root = rotateLeft(root);
            }
        }

        if (root.left != null) {
            getBalancedRoot(root.left, k / 2);
        }
        if (root.right != null) {
            getBalancedRoot(root.right, k / 2);
        }
        return root;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        return x;
    }

    ArrayList<Integer> getReverseInorder() { return reverseInorder(root, new ArrayList<Integer>()); }
    ArrayList<Integer> getReverseInorder(Node root) { return reverseInorder(root, new ArrayList<Integer>()); }
    ArrayList<Integer> getInorder() { return inorder(root, new ArrayList<Integer>()); }
    ArrayList<Integer> getInorder(Node root) { return inorder(root, new ArrayList<Integer>()); }

    
}