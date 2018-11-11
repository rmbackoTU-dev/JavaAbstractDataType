import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;

public  class BinarySearchTreeADT<T extends Comparable<T>>
{

    BinaryNode<T> rootNode;
    Iterator<T> nodeIter;

    public BinarySearchTreeADT(BinaryNode<T> rt){
        this.rootNode=rt;
        this.nodeIter=new Iterator(rootNode);
    }

    public static class BinaryNode<T extends Comparable<T>>
    {
        public BinaryNode<T> left;
        public BinaryNode<T> right;
        public T data;

        public BinaryNode(T dat)
        {
            left=null;
            right=null;
            data=dat;
        }

        public BinaryNode(BinaryNode<T> leftChild, BinaryNode<T> rightChild, T dat)
        {
            left=leftChild;
            right=rightChild;
            data=dat;
        }

        public String nodeData()
        {
            return this.data.toString();
        }

        public BinaryNode<T> getLeftChild()
        {
            if(this.left == null)
            {
                return null;
            }
            else {
                return this.left;
            }
        }

        public BinaryNode<T> getRightChild()
        {
            if(this.right == null)
            {
                return null;
            }
            else{
                return this.right;
            }
        }

        public void setData(T dat){
            this.data=dat;
        }

        public void setLeft(BinaryNode<T> lt)
        {
            this.left=lt;
        }

        public void setRight(BinaryNode<T> rt)
        {
            this.right=rt;
        }

        public int compareTo(BinaryNode<T> other )
        {
            return this.data.compareTo(other.data);
        }

    }

    //can not access subclasses from external classes
    public String inOrderDriver(){
        String result=inOrder(this.rootNode);
        return result;
    }

    public String preOrderDriver(){
        String result=preOrder(this.rootNode);
        return result;
    }

    public String postOrderDriver(){
        String result=postOrder(this.rootNode);
        return result;
    }

    public BinaryNode<T> getRootNode() {
        return this.rootNode;
    }

    public BinaryNode<T> getNextLeft() {
        nodeIter.nextLeft();
        BinaryNode<T> nextLeft=nodeIter.nodePointer;
        T nodePointerData=nextLeft.data;
        System.out.println(nodePointerData.toString());
        return nodeIter.nodePointer;
    }

    public BinaryNode<T> getNextRight(){
        nodeIter.nextRight();
        BinaryNode<T> nextRight=nodeIter.nodePointer;
        T nodePointerData=nextRight.data;
        System.out.println(nodePointerData.toString());
        return nodeIter.nodePointer;
    }

    public void resetIter(){
        nodeIter.setNodePointer(rootNode);
    }

    public BinaryNode<T> findMin(BinaryNode<T> root){
        System.out.println("Entering findMin");
        Iterator<T> treeIter=new Iterator(root);
        BinaryNode<T> minimumNode=root;
        while(treeIter.hasLeft())
        {
            treeIter.nextLeft();
        }
        minimumNode=treeIter.nodePointer;
        System.out.println("Leaving find min with " + minimumNode.data.toString());
        return minimumNode;
    }

    public BinaryNode<T> findMax(BinaryNode<T> root){
        System.out.println("Entering findMax");
        Iterator<T> treeIter=new Iterator(root);
        BinaryNode<T> maximumNode=root;
        while(treeIter.hasRight())
        {
            treeIter.nextRight();
        }
        maximumNode=treeIter.nodePointer;
        System.out.println("Leaving find max with "+maximumNode.data.toString());
        return maximumNode;
    }

    public String inOrder(BinaryNode<T> root)
    {
        System.out.println("Entering in order");
        Iterator<T> traversalIter=new Iterator(root);
        BinaryNode<T> leftNode;
        BinaryNode<T> rightNode;
        String result="";
        if(traversalIter.hasLeft()){
            leftNode=root.getLeftChild();
            System.out.printf("Left node data: "+leftNode.nodeData().toString()+"\n");
            result=result+inOrder(leftNode);
        }
        if(root != null){
            System.out.println("Root data:"+ root.nodeData().toString());
            result=result+root.nodeData().toString()+" ";
        }
        if(traversalIter.hasRight())
        {
            rightNode=root.getRightChild();
            System.out.printf("Right node data: "+rightNode.toString().toString()+"\n");
            result=result+inOrder(root.getRightChild());
        }
        System.out.println("Leaving inorder with "+result);
        return result;
    }


    public String preOrder(BinaryNode<T> root){
        System.out.println("Entering preOrder");
        Iterator<T> traversalIter=new Iterator(root);
        String result = "";
        BinaryNode<T> leftNode;
        BinaryNode<T> rightNode;
        if(root != null){
            System.out.printf("Root data "+root.nodeData().toString());
            result=result+root.nodeData().toString()+" ";
        }
        if(traversalIter.hasLeft()){
            leftNode=root.getLeftChild();
            System.out.println("Left node data: "+leftNode.nodeData().toString());
            result=result+preOrder(leftNode);
        }
        if(traversalIter.hasRight()){
            rightNode=root.getRightChild();
            System.out.println("Right node Data: "+rightNode.nodeData().toString());
            result=result+preOrder(root.getRightChild());
        }
        System.out.println("Leaving preOrder with "+result);
        return result;
    }

    public String postOrder(BinaryNode<T> root){
        System.out.println("Entering postOrder");
        Iterator<T> traversalIter=new Iterator(root);
        String result="";
        BinaryNode<T> leftNode;
        BinaryNode<T> rightNode;
        if(traversalIter.hasLeft()){
            leftNode=root.getLeftChild();
            System.out.println("Left node data: "+leftNode.nodeData().toString());
            result=result+postOrder(root.getLeftChild());
        }
        if(traversalIter.hasRight()){
            rightNode=root.getRightChild();
            System.out.println("Right node data: "+rightNode.nodeData().toString());
            result=result+postOrder(root.getRightChild());
        }
        if(root != null)
        {
            System.out.println("Data: "+root.nodeData().toString());
            result=result+root.nodeData().toString()+" ";
        }
        System.out.println("Leaving postOrder with "+result);
        return result;
    }

    /**
     * @Cited: Data Structure and Algorithm Analysis in Java 3rd Edition
     * @Author: Mark Allen Weiss
     *
     */

    public BinaryNode<T> insert(T data, BinaryNode<T> insertNode)
    {
        BinaryNode<T> compareNode=new BinaryNode(data);
        if(insertNode == null)
        {
            return new BinaryNode<T>(null, null, data);
        }

        int compareVal=compareNode.compareTo(insertNode);
        if(compareVal <0){
            BinaryNode<T> leftNode=insert(data, insertNode.getLeftChild());
            insertNode.setLeft(leftNode);
        }
        else if(compareVal >0){
            BinaryNode<T> rightNode=insert(data, insertNode.getRightChild());
            insertNode.setRight(rightNode);
        }
        else {
            //Duplicate do not return
            return null;
        }
        //Return the root to the new tree
        return insertNode;
    }

    public BinaryNode<T> find (T data) throws NoSuchElementException{
        boolean found=false;
        BinaryNode<T> compareNode=new BinaryNode(data);
        Iterator nodeIter=new Iterator(this.rootNode);
        BinaryNode<T> returnNode=null;
        int compareVal=compareNode.compareTo(nodeIter.nodePointer);
        while(!found) {
            if (compareVal < 0) {
                if (nodeIter.hasLeft()) {
                    nodeIter.nextLeft();
                } else {
                    throw new NoSuchElementException();
                }
            } else if (compareVal > 0) {
                if (nodeIter.hasRight()) {
                    nodeIter.nextRight();
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                returnNode = nodeIter.nodePointer;
                found=true;
            }
            compareVal=compareNode.compareTo(nodeIter.nodePointer);
        }
            System.out.println("Returning data of "+returnNode.nodeData().toString());
            return  returnNode;
    }

    public BinaryNode<T> removeSkewLeft(T data, BinaryNode treeRoot){
        BinaryNode<T> compareNode=new BinaryNode(data);
        Iterator<T> nodeIter=new Iterator(treeRoot);
        BinaryNode<T> electedRoot;
        BinaryNode<T> leftNode;
        BinaryNode<T> rightNode;

        //Also base case may never be hit because of hasLeft hasRight
        if(treeRoot == null)
        {
            return treeRoot;

        }

        int compareVal=compareNode.compareTo(treeRoot);

        if(compareVal < 0)
        {
            if(nodeIter.hasLeft())
            {
                leftNode=treeRoot.getLeftChild();
                electedRoot=removeSkewLeft(data, leftNode);
                treeRoot.setLeft(electedRoot);
            }
            else{
                return treeRoot;
            }
        }
        else if(compareVal > 0)
        {
            if(nodeIter.hasLeft()){
                rightNode=treeRoot.getRightChild();
                electedRoot=removeSkewLeft(data, rightNode);
                treeRoot.setRight(electedRoot);
            }
            else
            {
                return treeRoot;
            }

        }
        else if(nodeIter.hasLeft() && nodeIter.hasRight())
        {
            //Node found and has two children

            electedRoot=findMin(treeRoot.right);
            treeRoot.setData(electedRoot.data);
            BinaryNode<T> replacementTree=removeSkewLeft(electedRoot.data, treeRoot.right );
            treeRoot.setRight(replacementTree);
            System.out.println("Tree root "+treeRoot.nodeData().toString());

        }
        else
        {
            boolean hasRight=nodeIter.hasRight();
            boolean hasLeft=nodeIter.hasLeft();
            if(nodeIter.hasLeft())
            {
                //set the current node to the left element
                treeRoot=treeRoot.getLeftChild();
                System.out.println("Tree root: "+treeRoot.nodeData().toString());
            }
            else
            {
                //set the current node to right element
                if(nodeIter.hasRight()) {
                    treeRoot = treeRoot.getRightChild();
                }
                else
                {
                    treeRoot=null;
                }
            }
        }
        return treeRoot;
    }

    /*
    *Returns the root node of the new tree with the element removed
     */
    public BinaryNode<T> removeSkewRight(T data, BinaryNode<T> treeRoot){
        BinaryNode<T> compareNode=new BinaryNode(data);
        Iterator<T> nodeIter=new Iterator(treeRoot);
        BinaryNode<T> electedRoot;
        BinaryNode<T> leftNode;
        BinaryNode<T> rightNode;

        //Also base case may never be hit because of hasLeft hasRight
        if(treeRoot == null)
        {
            return treeRoot;

        }

        int compareVal=compareNode.compareTo(treeRoot);

        if(compareVal < 0)
        {
            if(nodeIter.hasLeft())
            {
                leftNode=treeRoot.getLeftChild();
                electedRoot=removeSkewRight(data, leftNode);
                treeRoot.setLeft(electedRoot);
            }
            else{
                return treeRoot;
            }
        }
        else if(compareVal > 0)
        {
            if(nodeIter.hasLeft()){
                rightNode=treeRoot.getRightChild();
                electedRoot=removeSkewRight(data, rightNode);
                treeRoot.setRight(electedRoot);
            }
            else
            {
                return treeRoot;
            }

        }
        else if(nodeIter.hasLeft() && nodeIter.hasRight())
        {
            //Node found and has two children

            electedRoot=findMax(treeRoot.left);
            treeRoot.setData(electedRoot.data);
            BinaryNode<T> replacementTree=removeSkewRight(electedRoot.data, treeRoot.left );
            treeRoot.setLeft(replacementTree);
            System.out.println("Tree root "+treeRoot.nodeData().toString());

        }
        else
        {
            boolean hasRight=nodeIter.hasRight();
            boolean hasLeft=nodeIter.hasLeft();
            if(nodeIter.hasLeft())
            {
                //set the current node to the left element
                treeRoot=treeRoot.getLeftChild();
            }
            else
            {
                //set the current node to right element
                if(nodeIter.hasRight()) {
                    treeRoot = treeRoot.getRightChild();
                }
                else
                {
                    treeRoot=null;
                }
            }
        }
        return treeRoot;
    }


    public static class Iterator<T extends Comparable<T>>
    {
        /*Implement an iterator which goes to the next node in the tree
         * Ensure no concurrent modification exceptions
         */
        private BinarySearchTreeADT.BinaryNode<T> nextLeft;
        private BinarySearchTreeADT.BinaryNode<T> nextRight;
        public  BinarySearchTreeADT.BinaryNode<T> nodePointer;
        public  BinarySearchTreeADT.BinaryNode<T> prevPointer;

        public Iterator(BinaryNode<T> root)
        {
            nodePointer=root;
            prevPointer=null;
        }

        public void setNodePointer(BinaryNode<T> node){
            this.nodePointer=node;
        }

        public boolean hasNext()
        {
            boolean hasNext=false;
            if(hasLeft())
            {
                hasNext=true;
            }
            if(hasRight())
            {
                hasNext=true;
            }

            return hasNext;
        }

        public void setNext()
        {
            BinaryNode<T> lt;
            BinaryNode<T> rt;
            if(hasLeft()){
                lt=this.nodePointer.getLeftChild();
                nextLeft=lt;
            }

            if(hasRight()){
                rt=this.nodePointer.getRightChild();
                nextRight=rt;
            }
        }

        public boolean hasLeft()
        {
            boolean hasLeft=false;
            BinaryNode<T> lt=this.nodePointer.getLeftChild();
            if(lt != null){
                hasLeft=true;
            }
            return hasLeft;
        }

        public boolean hasRight()
        {
            boolean hasRight=false;
            BinaryNode<T> rt=this.nodePointer.getRightChild();
            if(rt != null){
                hasRight=true;
            }
            return hasRight;
        }

        public void clearNext(){
            this.nextLeft=null;
            this.nextRight=null;
        }

        public void nextLeft(){
            try
            {
                if(!hasLeft())
                {
                    throw new java.util.NoSuchElementException();
                }
                if(this.nextLeft == null)
                {
                    setNext();
                }
                this.prevPointer=nodePointer;
                this.nodePointer=nextLeft;
                clearNext();
            }
            catch (NoSuchElementException nse)
            {
                System.err.println("No left element exist");
            }
        }

        public void nextRight()
        {
            try
            {
                if(!hasRight())
                {
                    throw new java.util.NoSuchElementException();
                }
                if(this.nextRight == null)
                {
                    setNext();
                }
                this.prevPointer=nodePointer;
                this.nodePointer=nextRight;
                clearNext();
            }
            catch (NoSuchElementException nse)
            {
                System.err.println("No left element exist");
            }

        }
    }
}

