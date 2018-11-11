


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
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftTwo=new BinarySearchTreeADT.BinaryNode<>(5);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftOne=new BinarySearchTreeADT.BinaryNode<>(3);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftFive=new BinarySearchTreeADT.BinaryNode<>(12);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeLeftThree=new BinarySearchTreeADT.BinaryNode<>(7);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeRightOne=new BinarySearchTreeADT.BinaryNode<>(28);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeRightThree=new BinarySearchTreeADT.BinaryNode<>(34);
    public static BinarySearchTreeADT.BinaryNode<Integer> manTreeRightFour=new BinarySearchTreeADT.BinaryNode<>(41);

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

        intBST=new BinarySearchTreeADT(manTreeRoot);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        nodeStrOne.setLeft(null);
        nodeStrThree.setRight(null);
        nodeIntOne.setLeft(null);
        nodeIntThree.setRight(null);
        manTreeRightTwo.setLeft(null);
        manTreeLeftFour.setRight(null);
        intBST=null;
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
        nodeTestSetup();
        BinarySearchTreeADT.BinaryNode resultNode;
        testIter.nextLeft();
        resultNode=testIter.nodePointer;
        assertEquals("Iterator did not properly move to left node", resultNode.compareTo(manTreeLeftFour), 0);
    }

    @Test
    public void testNextRight()
    {
        nodeTestSetup();
        BinarySearchTreeADT.BinaryNode resultNode;
        testIter.nextRight();
        resultNode=testIter.nodePointer;
        assertEquals("Iterator did not properly move to right node", resultNode.compareTo(manTreeRightTwo), 0);
    }

    @Test
    public void testInsertLeft(){
        nodeTestSetup();
        BinarySearchTreeADT.BinaryNode<Integer> expected=intBST.insert(manTreeLeftFour.data, intBST.rootNode);
        BinarySearchTreeADT.BinaryNode<Integer> expectedLeft=expected.getLeftChild();
        System.out.printf("Data: %s\n", expectedLeft.nodeData());
        int compareVal=manTreeLeftFour.compareTo(expectedLeft);
        assertEquals("Left node not correctly inserted",compareVal, 0);
    }

    @Test
    public void testInsertRight(){
        nodeTestSetup();
        BinarySearchTreeADT.BinaryNode<Integer> expected=intBST.insert(manTreeRightTwo.data, intBST.rootNode);
        BinarySearchTreeADT.BinaryNode<Integer> expectedRight=expected.getRightChild();
        System.out.printf("Data: %s\n", expectedRight.nodeData());
        int compareVal=manTreeRightTwo.compareTo(expectedRight);
        assertEquals("Right node not correctly inserted", compareVal, 0);
    }

    @Test
    public void testSetElement(){
        //compare left value
        //compare right value
        //if they are the same as the right and left of a given element it worked

    }

    @Test
    public void testInoder(){
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
        String expected="3 5 7 10 12 25 28 31 34 41 ";
        String recieved=testTree.inOrder(testTree.rootNode);
        assertEquals(expected, recieved);
    }

    @Test
    public void testPreOrder(){
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
        String excepted="25 10 7 5 3 12 31 28 34 41 ";
        String recieved=testTree.preOrder(testTree.rootNode);
        assertEquals(excepted, recieved);
    }

    @Test
    public void testPostOrder() {
        BinarySearchTreeADT<Integer> testTree = testTreeSetup();
        String expected="3 5 7 12 10 28 41 34 31 25 ";
        String recieved=testTree.postOrder(testTree.rootNode);
        assertEquals(recieved, expected);
    }

    @Test
    public void testFindMax(){
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
        BinarySearchTreeADT.BinaryNode<Integer> expected=manTreeRightFour;
        BinarySearchTreeADT.BinaryNode<Integer> result=testTree.findMax(testTree.rootNode);
        int compareVal=expected.compareTo(result);
        assertEquals("Failed to find the maximum element",compareVal,0);
    }

    @Test
    public void testFindMin(){
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
        BinarySearchTreeADT.BinaryNode<Integer> expected=manTreeLeftOne;
        BinarySearchTreeADT.BinaryNode<Integer> result=testTree.findMin(testTree.rootNode);
        int compareVal=expected.compareTo(result);
        assertEquals("Failed to find the minimum element", compareVal, 0);
    }

    @Test
    public void testRemoveSkewLeft()
    {
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
    }

    @Test
    public void testRemoveSkewLeftSingleChild()
    {
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
    }

    @Test
    public void testRemoveSkewLeftFullNode()
    {
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
    }

    @Test
    public void testRemoveSkewRight()
    {
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
    }

    @Test
    public void testRemoveSkewRightSingleChild()
    {
        BinarySearchTreeADT<Integer> testTree=testTreeSetup();
    }

    @Test
    public void testRemoveSkewRightFullNode()
    {
         BinarySearchTreeADT<Integer> testTree=testTreeSetup();
    }

    public  BinarySearchTreeADT<Integer> testTreeSetup()
    {
        BinarySearchTreeADT<Integer> testTree=new BinarySearchTreeADT(manTreeRoot);
        BinarySearchTreeADT.BinaryNode<Integer> newRoot;
        newRoot=testTree.insert(manTreeLeftFour.data, intBST.rootNode);
        newRoot=testTree.insert(manTreeRightTwo.data, intBST.rootNode);
        newRoot=testTree.insert(manTreeLeftFive.data, intBST.rootNode);
        newRoot=testTree.insert(manTreeLeftThree.data,intBST.rootNode);
        newRoot=testTree.insert(manTreeLeftTwo.data,intBST.rootNode);
        newRoot=testTree.insert(manTreeLeftOne.data,intBST.rootNode);
        newRoot=testTree.insert(manTreeRightOne.data,intBST.rootNode);
        newRoot=testTree.insert(manTreeRightThree.data,intBST.rootNode);
        newRoot=testTree.insert(manTreeRightFour.data,intBST.rootNode);
        testTree=new BinarySearchTreeADT(newRoot);
        return testTree;
    }

    public void nodeTestSetup()
    {
        manTreeRoot.setLeft(manTreeLeftFour);
        manTreeRoot.setRight(manTreeRightTwo);
        intBST=new BinarySearchTreeADT(manTreeRoot);
    }
}
