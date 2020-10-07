package com.bsuir.ppvis.task;

/**
 * @brief Helper class for implementing a binary tree structure (in particular a node)
 */
public class Node {
    private String key;
    /**
     * @brief Class field that stores the russian word
     */
    private String info;
    /**
     * @brief Class field that stores the english word
     */
    private Node right;
    /**
     * @brief Class field that stores the root of the right subtree
     */
    private Node left;/** @brief Class field that stores the root of the left subtree */
    /**
     * @param key  The english word that we inputed
     * @param info The russian word that we inputed
     * @brief A constructor
     * @detailed This constructor allows us to create an instance of a Node class
     */
    public Node(String key, String info) {
        this.key = key;
        this.info = info;
        right = null;
        left = null;
    }

    /**
     * A getter
     *
     * @return the value of the private field (key) of the class
     */
    public String getKey() {
        return key;
    }

    /**
     * A getter
     *
     * @return the value of the private field (info) of the class
     */
    public String getInfo() {
        return info;
    }

    /**
     * A getter
     *
     * @return the value of the private field (right) of the class
     */
    public Node getRight() {
        return right;
    }

    /**
     * A getter
     *
     * @return the value of the private field (left) of the class
     */
    public Node getLeft() {
        return left;
    }

    /**
     * A setter
     *
     * @param key
     * @brief sets the value of the private field (key) of the class
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * A setter
     *
     * @param info
     * @brief sets the value of the private field (info) of the class
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * A setter
     *
     * @param right
     * @brief sets the value of the private field (right) of the class
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * A setter
     *
     * @param left
     * @brief sets the value of the private field (left) of the class
     */
    public void setLeft(Node left) {
        this.left = left;
    }
}