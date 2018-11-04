


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

    BinarySearchTreeADT.BinaryNode<Integer> manTreeRoot=new BinarySearchTreeADT.BinaryNode(25);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftOne=new BinarySearchTreeADT.BinaryNode(4);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftTwo=new BinarySearchTreeADT.BinaryNode(5);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftThree=new BinarySearchTreeADT.BinaryNode(8);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftFour=new BinarySearchTreeADT.BinaryNode(10);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftFive=new BinarySearchTreeADT.BinaryNode(12);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftSix=new BinarySearchTreeADT.BinaryNode(24);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeRightOne=new BinarySearchTreeADT.BinaryNode(28);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeRightTwo=new BinarySearchTreeADT.BinaryNode(31);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeRightThree=new BinarySearchTreeADT.BinaryNode(35);
    BinarySearchTreeADT.BinaryNode<Integer> manTreeRightFour=new BinarySearchTreeADT.BinaryNode(40);

    BinarySearchTreeADT.Iterator testIter;

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

        //Mock tree manual inserts and deletes with no check conditions
        manTreeRoot.setLeft(manTreeLeftFour);
        manTreeLeftFour.setLeft(manTreeLeftTwo);
        manTreeLeftFour.setRight(manTreeLeftFive);
        manTreeLeftTwo.setLeft(manTreeLeftOne);
        manTreeLeftTwo.setRight(manTreeLeftThree);
        manTreeLeftFive.setRight(manTreeLeftSix);
        manTreeRoot.setRight(manTreeRightTwo);
        manTreeRightTwo.setLeft(manTreeRightOne);
        manTreeRightTwo.setRight(manTreeRightThree);
        manTreeRightThree.setRight(manTreeRightFour);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        nodeStrOne.setLeft(null);
        nodeStrThree.setRight(null);
        nodeIntOne.setLeft(null);
        nodeIntThree.setRight(null);
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
        testIter=new BinarySearchTreeADT.Iterator(manTreeRoot);
        assertTrue("iterator failed to detect next", testIter.hasNext() );
    }

    @Test
    public void testHasNextFalse()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeLeftOne);
        assertFalse("iterator has failed to detect that there is no children", testIter.hasNext());
    }

    @Test
    public void testHasNextLeft()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeRoot);
        assertTrue("iterator failed to detect next", testIter.hasLeft() );
    }

    @Test
    public void testHastNextRight()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeRoot);
        assertTrue("iterator failed to detect next", testIter.hasRight() );
    }

    @Test
    public void testHasNextLeftFalse()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeLeftOne);
        assertFalse("iterator failed to detect next", testIter.hasLeft() );
    }

    @Test
    public void testHastNextRightFalse()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeLeftOne);
        assertFalse("iterator failed to detect next", testIter.hasRight() );
    }

    @Test
    public void testNextLeft()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeRoot);
        testIter.nextLeft();
        BinarySearchTreeADT.BinaryNode<Integer> resultNode=testIter.nodePointer;
        assertEquals("Iterator did not properly move to left node", resultNode.compareTo(manTreeLeftFour), 0);
    }

    public void testNextRight()
    {
        testIter=new BinarySearchTreeADT.Iterator(manTreeRoot);
        testIter.nextRight();
        BinarySearchTreeADT.BinaryNode<Integer> resultNode=testIter.nodePointer;
        assertEquals("Iterator did not properly move to right node", resultNode.compareTo(manTreeRightTwo), 0);
    }

}