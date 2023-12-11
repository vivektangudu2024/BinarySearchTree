package com.day10.BinarySearchTree;

// Interface for Node with generic key type
interface INode<K extends Comparable<K>> {
    K getKey();

    void setKey(K key);

    INode<K> getLeft();

    void setLeft(INode<K> left);

    INode<K> getRight();

    void setRight(INode<K> right);
}

// Binary Node class implementing the INode interface
class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
    private K key;
    private INode<K> left;
    private INode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }
    /*
     * @desc:gets the left child of the node.
     * @params: none
     * @return:left node
     */
    @Override
    public INode<K> getLeft() {
        return left;
    }
    /*
     * @desc: Sets the right child of the node.
     * @params:left child node to be set.
     * @return:none
     */
    @Override
    public void setLeft(INode<K> left) {
        this.left = left;
    }
    /*
     * @desc:gets the right child of the node.
     * @params: none
     * @return:right node
     */
    @Override
    public INode<K> getRight() {
        return right;
    }
    /*
     * @desc: Sets the right child of the node.
     * @params: right - The right child node to be set.
     * @return:none
     */
    @Override
    public void setRight(INode<K> right) {
        this.right = right;
    }
}

// Binary Search Tree class
class MyBinarySearchTree<K extends Comparable<K>> {
    private INode<K> root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    /*
     * @desc: Adds a key to the Binary Search Tree.
     * @params: key - The key to be added.
     * @return:none
     */
    public void add(K key) {
        root = addRec(root, key);
    }
    /*
     * @desc: Recursively adds a key to the BST.
     * @params: root - The root of the current subtree, key - The key to be added.
     * @return: The updated root of the subtree.
     */
    private INode<K> addRec(INode<K> root, K key) {
        if (root == null) {
            return new MyBinaryNode<>(key);
        }

        // Compare the key with the root's key to determine the direction
        int compareResult = key.compareTo(root.getKey());

        if (compareResult < 0) {
            // If the key is smaller, go to the left
            root.setLeft(addRec(root.getLeft(), key));
        } else if (compareResult > 0) {
            // If the key is larger, go to the right
            root.setRight(addRec(root.getRight(), key));
        }

        return root;
    }

    /*
     * @desc:display the bst
     * @params: root - The root of the current subtree.
     * @return: none
     */
    public void inorderTraversal(INode<K> root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.print(root.getKey() + " ");
            inorderTraversal(root.getRight());
        }
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    /*
     * @desc: Gets the size of the BST.
     * @params: none
     * @return: The size of the BST.
     */
    public int size(INode<K> root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    public int size() {
        return size(root);
    }
}

public class BSTExample {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

        // Adding nodes
        bst.add(56);
        bst.add(30);
        bst.add(70);

        // Displaying the BST using inorder traversal
        System.out.println("Inorder Traversal of BST:");
        bst.inorderTraversal();
    }
}

