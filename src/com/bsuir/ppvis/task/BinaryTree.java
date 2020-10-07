package com.bsuir.ppvis.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @brief This class allows us to work with a binary tree data structure
 */

public class BinaryTree {

    /**
     * @brief A private variable
     * @details represents the root of the binary tree(the first pair of words that we enter into our dictionary)
     */
    private Node root;

    /**
     * @param key  The english word that we inputed
     * @param info The russian word that we inputed
     * @brief A constructor
     * @details Creates a root from the first pair of words that we inputed
     */
    public BinaryTree(String key, String info) throws NullPointerException {
        try {
            this.root = new Node(key.toLowerCase(), info.toLowerCase());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief A constructor
     * @details Creates an empty root of the binary tree
     */
    public BinaryTree() {
    }

    /**
     * @param key  The english word that we inputed
     * @param info The russian word that we inputed
     * @details This function allows us to add the pair of words(english and russian translations)
     */
    public void add(String key, String info) throws NullPointerException {
        try {
            root = addRecursion(root, key.toLowerCase(), info.toLowerCase());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private Node addRecursion(Node root, String key, String info) {
        if (root == null)
            return new Node(key, info);
        if (key.compareTo(root.getKey()) > 0)
            root.setRight(addRecursion(root.getRight(), key, info));
        else if (key.compareTo(root.getKey()) < 0)
            root.setLeft(addRecursion(root.getLeft(), key, info));
        return root;
    }

    /**
     * @details This function allows us to print the dictionary in alphabetical order
     */
    public void print() {
        inAlphabetOrder(root);
    }

    private void inAlphabetOrder(Node root) {
        if (root != null) {
            inAlphabetOrder(root.getLeft());
            System.out.println(root.getKey() + "\t-\t" + root.getInfo());
            inAlphabetOrder(root.getRight());
        }
    }

    /**
     * @param key The english word that we inputed
     * @return the russian equivalent of the english word (word with the entered key)
     * @details This function allows us to search the russian word by the key (the english word) in the dictionary
     */
    public String search(String key) throws NullPointerException {
        try {
            Node node = findNode(root, key.toLowerCase());
            if (node != null) return node.getInfo();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Node findNode(Node root, String key) {
        if (root == null) return null;
        if (!root.getKey().equals(key)) {
            if (key.compareTo(root.getKey()) > 0) return findNode(root.getRight(), key);
            else if (key.compareTo(root.getKey()) < 0) return findNode(root.getLeft(), key);
        }
        return root;
    }

    /**
     * @param key     The english word for which we want to change the translation
     * @param newInfo The russian word we want to change the translation with
     * @brief This function allows us to rewrite the russian word in a certain pair
     */
    public void rewrite(String key, String newInfo) throws NullPointerException {
        try {
            newInfo = newInfo.toLowerCase();
            Node node = findNode(root, key.toLowerCase());
            if (node != null) node.setInfo(newInfo);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param key The english word that we inputed
     * @details This function allows us to delete the pair of words(english and russian) from the dictionary by the key
     * (the english word)
     */
    public void delete(String key) throws NullPointerException {
        try {
            root = deleteRecursion(root, key.toLowerCase());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private Node deleteRecursion(Node root, String key) {
        if (root == null) return null;
        if (key.compareTo(root.getKey()) < 0) root.setLeft(deleteRecursion(root.getLeft(), key));
        else if (key.compareTo(root.getKey()) > 0) root.setRight(deleteRecursion(root.getRight(), key));
        else {
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();
            root.setKey((root.getRight()).getKey());
            root.setInfo((root.getRight()).getInfo());
            root.setRight(deleteRecursion(root.getRight(), root.getKey()));
        }
        return root;
    }

    /**
     * @return the number of words in the dictionary
     * @details This function allows to know the size of the dictionary
     */
    public int size() {
        return sizeRecursion(root);
    }

    private int sizeRecursion(Node node) {
        if (node == null) return 0;
        else return (sizeRecursion(node.getLeft()) + 1 + sizeRecursion(node.getRight()));
    }

    /**
     * @param filePath The path to the file
     * @throws FileNotFoundException
     * @details This function allows us to load a dictionary from a file
     */
    public void read(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            if (checkSeparatorExists(temp)) add(splitString(temp, false), splitString(temp, true));
        }
        scanner.close();
    }

    private String splitString(String line, boolean index) {
        String[] result = line.split(" - ", 2);
        if (!index) return result[0];
        else if (index) return result[1];
        else return null;
    }

    private boolean checkSeparatorExists(String line) {
        return line.contains(" - ");
    }

    public Node getRoot() {
        return root;
    }
}