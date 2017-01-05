import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by michal on 05.01.17.
 */
public class BSTTest {

    BST bst;
    BST bst2;
    BST bst3;


    @Before
    public void setUp() throws Exception {
        bst = new BST();
        bst.insert(9);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(11);
        bst.insert(13);

        bst2 = new BST();
        bst2.insert(1);
        bst2.insert(2);
        bst2.insert(3);
        bst2.insert(4);
        bst2.insert(5);

        bst3 = new BST();
        bst3.insert(3);
        bst3.insert(5);
        bst3.insert(4);
        bst3.insert(7);
        bst3.insert(2);
        bst3.insert(1);
    }

    @Test
    @Ignore
    public void print() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        bst.printTree(outputStreamWriter);
        outputStreamWriter.write("\n");
        bst2.printTree(outputStreamWriter);
        outputStreamWriter.write("\n");
        outputStreamWriter.write("\n");
        outputStreamWriter.write("\n");
        bst3.printTree(outputStreamWriter);
        outputStreamWriter.close();
    }

    @Test
    public void getHeight() throws Exception {
        Assert.assertEquals(4, bst.getHeight());
    }

    @Test
    public void getLongestPath() throws Exception {
        Assert.assertEquals(6, bst.getLongestPath());
    }

    @Test
    public void levelOrderTest() throws Exception {
        Assert.assertEquals("3 2 5 1 4 7 ", bst3.levelOrder());
    }
}