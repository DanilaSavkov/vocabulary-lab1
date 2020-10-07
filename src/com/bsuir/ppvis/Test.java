package com.bsuir.ppvis;

import com.bsuir.ppvis.task.BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree bin = new BinaryTree("word", "слово");
        bin.print();
        //bin.delete("egor");
        //bin.rewrite("word", "хуй");
        System.out.println(bin.search("egor"));
        bin.print();
    }
}
