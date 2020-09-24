import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BinaryTreeTest extends BinaryTree {
    @Test
    public void addRightTest() throws Exception {
        BinaryTree add_test = new BinaryTree("cat", "кот");
        add_test.add("odin", "один");
        assertEquals("odin", add_test.getRoot().getRight().getKey());
    }

    @Test
    public void addLeftTest() throws Exception {
        BinaryTree add_test = new BinaryTree("odin", "один");
        add_test.add("cat", "кот");
        assertEquals("cat", add_test.getRoot().getLeft().getKey());
    }

    @Test
    public void addTestNegative() throws Exception {
        BinaryTree add_test = new BinaryTree("cat", "кот");
        add_test.add("odin", "один");
        assertEquals(null, add_test.getRoot().getLeft());
    }

    @Test
    public void searchTestPositive() throws Exception {
        BinaryTree search_test = new BinaryTree();
        search_test.add("cat", "кот");
        search_test.add("dog", "собака");
        search_test.add("pig", "свинья");
        assertEquals("кот", search_test.search("cat"));
    }

    @Test
    public void searchTestNegative() throws Exception {
        BinaryTree search_test = new BinaryTree();
        search_test.add("cat", "кот");
        search_test.add("dog", "собака");
        search_test.add("pig", "свинья");
        assertEquals(null, search_test.search("noga"));
    }

    @Test
    public void searchTestCaps() throws Exception {
        BinaryTree search_test = new BinaryTree();
        search_test.add("cat", "кот");
        search_test.add("DOG", "СОБАКА");
        search_test.add("pig", "свинья");
        assertEquals("собака", search_test.search("dog"));
    }

    @Test
    public void rewriteTestPositive() throws Exception {
        BinaryTree rewrite_test = new BinaryTree();
        rewrite_test.add("pig", "свинья");
        rewrite_test.add("cat", "кот");
        rewrite_test.add("dog", "собака");
        rewrite_test.rewrite("pig", "машина");
        assertEquals("машина", rewrite_test.search("pig"));
    }

    @Test
    public void rewriteTestCaps() throws Exception {
        BinaryTree rewrite_test = new BinaryTree();
        rewrite_test.add("pig", "свинья");
        rewrite_test.add("cat", "кот");
        rewrite_test.add("dog", "собака");
        rewrite_test.rewrite("DOG", "мопс");
        assertEquals("мопс", rewrite_test.search("dog"));
    }

    @Test
    public void delTest() throws Exception {
        BinaryTree del_test = new BinaryTree();
        del_test.add("cat", "кот");
        del_test.add("dog", "собака");
        del_test.add("pig", "свинья");
        del_test.delete("pig");
        assertEquals(null, del_test.search("pig"));
    }

    @Test
    public void delTestCaps() throws Exception {
        BinaryTree del_test = new BinaryTree();
        del_test.add("CAT", "КОТ");
        del_test.add("dog", "собака");
        del_test.add("pig", "свинья");
        del_test.delete("cat");
        assertEquals(null, del_test.search("CAT"));
    }

    @Test
    public void sizeTestPositive() throws Exception {
        BinaryTree size_test = new BinaryTree();
        size_test.add("cat", "кот");
        size_test.add("dog", "собака");
        size_test.add("pig", "свинья");
        size_test.add("elephant", "слон");
        size_test.add("whale", "кит");
        assertEquals(5, size_test.size());
    }

    @Test
    public void sizeTestNull() throws Exception {
        BinaryTree size_test = new BinaryTree();
        assertEquals(0, size_test.size());
    }

    @Test
    public void readTestPositive() throws Exception {
        BinaryTree read_test = new BinaryTree();
        String separator = File.separator;
        String filePath = "C:" + separator + "Users" + separator + "Даник" + separator + "Desktop" + separator + "test.txt";
        read_test.read(filePath);
        assertEquals("слон", read_test.search("elephant"));
    }

    @Test
    public void readTestNegative() throws Exception {
        BinaryTree read_test = new BinaryTree();
        String separator = File.separator;
        String filePath = "C:" + separator + "Users" + separator + "Даник" + separator + "Desktop" + separator + "test.txt";
        read_test.read(filePath);
        assertEquals(null, read_test.search("wrong word"));
    }

    @Test
    public void readTestChanged() throws Exception {
        BinaryTree read_test = new BinaryTree();
        String separator = File.separator;
        String filePath = "C:" + separator + "Users" + separator + "Даник" + separator + "Desktop" + separator + "test.txt";
        read_test.read(filePath);
        read_test.rewrite("bear", "мишка");
        read_test.read(filePath);
        assertEquals("мишка", read_test.search("bear"));
    }
}


