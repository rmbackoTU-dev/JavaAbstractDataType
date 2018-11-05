


import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class BinarySearchTreeADTTest {

    BinarySearchTreeADT<Integer> intBST;

    Integer intDatOne=new Integer(10);
    String strDatOne=new String("Apple");

    Integer intDatTwo=new Integer(20);
    String strDatTwo=new String("Banana");

    Integer intDatThree=new Integer(30);
    String strDatThree=new String("Candy");


    BinarySearchTreeADT.BinaryNode<Integer> nodeIntOne;
    BinarySearchTreeADT.BinaryNode<Integer> nodeIntTwo;
    BinarySearchTreeADT.BinaryNode<Integer> nodeIntThree;

    BinarySearchTreeADT.BinaryNode<String> nodeStrOne;
    BinarySearchTreeADT.BinaryNode<String> nodeStrTwo;
    BinarySearchTreeADT.BinaryNode<String> nodeStrThree;

    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeRoot=new BinarySearchTreeADT.BinaryNode(25);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftFour=new BinarySearchTreeADT.BinaryNode(10);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeRightTwo=new BinarySearchTreeADT.BinaryNode(31);

    public BinarySearchTreeADT.Iterator testIter=new BinarySearchTreeADT.Iterator(manTreeRoot);

    @org.junit.Before
    public void setUp() throws Exception
    {

        nodeIntOne=new  BinarySearchTreeADT.BinaryNode(intDatOne);
        nodeIntThree=new  BinarySearchTreeADT.BinaryNode(intDatThree);
        nodeIntTwo=new  BinarySearchTreeADT.BinaryNode(nodeIntOne, nodeIntThree,
                intDatTwo);

        nodeStrOne=new  BinarySearchTreeADT.BinaryNode(strDatOne);
        nodeStrThree=new  BinarySearchTreeADT.BinaryNode(strDatThree);
        nodeStrTwo=new  BinarySearchTreeADT.BinaryNode(nodeStrOne, nodeStrThree,
                strDatTwo);

        manTreeRoot.setLeft(manTreeLeftFour);
        manTreeRightTwo.setRight(manTreeRightTwo);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        nodeStrOne.setLeft(null);
        nodeStrThree.setRight(null);
        nodeIntOne.setLeft(null);
        nodeIntThree.setRight(null);
        manTreeRightTwo.setLeft(null);
        manTreeLeftFour.setRight(null);
    }

    @Test
    public void testEmptyNodeint()
    {
        BinarySearchTreeADT.BinaryNode<Integer> testNodeInt=new BinarySearchTreeADT.BinaryNode(30);
        assertTrue("Empty Node Initilaization Unsuccessful",
                (testNodeInt.compareTo(nodeIntThree) == 0));

    }

    @Test
    public void testEmptyNodeStr()
    {
        BinarySearchTreeADT.BinaryNode<String> testNodeStr=new BinarySearchTreeADT.BinaryNode("Candy");
        assertTrue("Empty Node Initilaization Unsuccessful",
                (testNodeStr.compareTo(nodeStrThree) == 0 ));
    }

    @Test
    public void testInitFullNodeInt(){
        BinarySearchTreeADT.BinaryNode<Integer> testNodeInt= new BinarySearchTreeADT.BinaryNode(nodeIntOne,
                nodeIntThree, 10);
        BinarySearchTreeADT.BinaryNode<Integer> testNodeLeft=testNodeInt.getLeftChild();
        BinarySearchTreeADT.BinaryNode<Integer> testNodeRight=testNodeInt.getRightChild();
        int leftCompare=nodeIntOne.compareTo(testNodeLeft);
        int rightCompare=nodeIntThree.compareTo(testNodeRight);
        int rootCompare=nodeIntOne.compareTo(testNodeInt);
        System.out.printf("Left: %d \n", leftCompare);
        System.out.printf("Right: %d\n", rightCompare);
        System.out.printf("Root: %d \n", rootCompare);
        assertTrue("Full node initilization unsuccessful",(leftCompare == 0  && rightCompare == 0
                && rootCompare ==0));
    }

    @Test
    public void testInitFullNodeStr(){
        BinarySearchTreeADT.BinaryNode<String> testNodeStr= new BinarySearchTreeADT.BinaryNode(nodeStrOne,
                nodeStrThree, "Apple");
        BinarySearchTreeADT.BinaryNode<String> testNodeLeft=testNodeStr.getLeftChild();
        BinarySearchTreeADT.BinaryNode<String> testNodeRight=testNodeStr.getRightChild();
        int leftCompare=nodeStrOne.compareTo(testNodeLeft);
        int rightCompare=nodeStrThree.compareTo(testNodeRight);
        int rootCompare=nodeStrOne.compareTo(testNodeStr);
        System.out.printf("Left: %d \n", leftCompare);
        System.out.printf("Right: %d\n", rightCompare);
        System.out.printf("Root: %d \n", rootCompare);
        assertTrue("Full node initilization unsuccessful",(leftCompare == 0  && rightCompare == 0
                && rootCompare ==0));
    }

    @Test
    public void testGetLeftInt()
    {
        BinarySearchTreeADT.BinaryNode<Integer> testLeftNode=nodeIntTwo.getLeftChild();
        assertEquals("Get left returns left child", testLeftNode, nodeIntOne);
    }

    @Test
    public void testGetRightInt()
    {
        BinarySearchTreeADT.BinaryNode<Integer> testRightNode=nodeIntTwo.getRightChild();
        assertEquals("Get left returns right child", testRightNode, nodeIntThree);
    }

    @Test
    public void testGetLeftStr()
    {
        BinarySearchTreeADT.BinaryNode<String> testLeftNode=nodeStrTwo.getLeftChild();
        assertEquals("Get left returns left child", testLeftNode, nodeStrOne);
    }

    @Test
    public void testGetRightStr()
    {
        BinarySearchTreeADT.BinaryNode<String> testRightNode=nodeStrTwo.getRightChild();
        assertEquals("Get left returns right child", testRightNode, nodeStrThree);
    }

    @Test
    public void testSetLeftInt()
    {
        BinarySearchTreeADT.BinaryNode<Integer> nodeIntFour=new BinarySearchTreeADT.BinaryNode<Integer>(5);
        nodeIntOne.setLeft(nodeIntFour);
        assertEquals(nodeIntFour, nodeIntOne.left);
    }

    @Test
    public void testSetRightInt()
    {
        BinarySearchTreeADT.BinaryNode<Integer> nodeIntFour=new BinarySearchTreeADT.BinaryNode<Integer>(5);
        nodeIntThree.setRight(nodeIntFour);
        assertEquals(nodeIntFour, nodeIntThree.right);
    }

    @Test
    public void testSetLeftStr()
    {
        BinarySearchTreeADT.BinaryNode<String> nodeStrFour=new BinarySearchTreeADT.BinaryNode<String>("Five");
        nodeStrOne.setLeft(nodeStrFour);
        assertEquals(nodeStrFour, nodeStrOne.left);
    }

    @Test
    public void testSetRightStr()
    {
        BinarySearchTreeADT.BinaryNode<String> nodeStrFour=new BinarySearchTreeADT.BinaryNode<String>("Five");
        nodeStrThree.setRight(nodeStrFour);
        assertEquals(nodeStrFour, nodeStrThree.right);
    }

    @Test
    public void testHasNextTrue()
    {
        assertTrue("iterator failed to detect next", testIter.hasNext() );
    }

    @Test
    public void testHasNextFalse()
    {
        assertFalse("iterator has failed to detect that there is no children", testIter.hasNext());
    }

    @Test
    public void testHasNextLeft()
    {
        assertTrue("iterator failed to detect next", testIter.hasLeft() );
    }

    @Test
    public void testHastNextRight()
    {
        assertTrue("iterator failed to detect next", testIter.hasRight() );
    }

    @Test
    public void testHasNextLeftFalse()
    {
        assertFalse("iterator failed to detect next", testIter.hasLeft() );
    }

    @Test
    public void testHastNextRightFalse()
    {
        assertFalse("iterator failed to detect next", testIter.hasRight() );
    }

    @Test
    public void testNextLeft()
    {
        BinarySearchTreeADT.BinaryNode resultNode;
        testIter.nextLeft();
        resultNode=testIter.nodePointer;
        assertEquals("Iterator did not properly move to left node", resultNode.compareTo(manTreeLeftFour), 0);
    }

    @Test
    public void testNextRight()
    {
        BinarySearchTreeADT.BinaryNode resultNode;
        testIter.nextRight();
        resultNode=testIter.nodePointer;
        assertEquals("Iterator did not properly move to right node", resultNode.compareTo(manTreeRightTwo), 0);
    }

}