import java.util.*;

public  class BinarySearchTreeADT<T extends Comparable<T>>
{

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

    public BinaryNode<T> findMin(BinaryNode<T> root){
        System.out.println("Entering findMin");
        Iterator<T> treeIter=new Iterator(root);
        BinaryNode<T> minimumNode=root;
        while(treeIter.hasLeft())
        {
            treeIter.nextLeft();
        }
        minimumNode=treeIter.nodePointer;
        System.out.println("Leaving find min with" + minimumNode.data.toString());
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
        String result="";
        System.out.println("Problems at Left");
        traversalIter.nextLeft();
        result=result+traversalIter.nodePointer.data.toString()+" ,";
        System.out.println("Problem at Right");
        traversalIter.nextRight();
        System.out.println("Leaving inorder with"+result);
        return result;
    }


    public String preOrder(BinaryNode<T> root){
        System.out.println("Entering preOrder");
        Iterator<T> traversalIter=new Iterator(root);
        String result = "";
        result=result+traversalIter.nodePointer.data.toString() + " ,";
        System.out.println("Problem at left");
        traversalIter.nextLeft();
        System.out.println("Problem at right");
        traversalIter.nextRight();
        System.out.println("Leaving preOrder with"+result);
        return result;
    }

    public String postOrder(BinaryNode<T> root){
        System.out.println("Entering postOrder");
        Iterator<T> traversalIter=new Iterator(root);
        String result="";
        System.out.println("Problem at left");
        traversalIter.nextLeft();
        System.out.println("Problem at right");
        traversalIter.nextRight();
        result=result+traversalIter.nodePointer.data.toString()+" ,";
        System.out.println("Leaving postOrder with"+result);
        return result;

    }


    public static class Iterator<T extends Comparable<T>>
    {
        /*Implement an iterator which goes to the next node in the tree
         * Ensure no concurrent modification exceptions
         */
        private BinarySearchTreeADT.BinaryNode<T> nextLeft;
        private BinarySearchTreeADT.BinaryNode<T> nextRight;
        public  BinarySearchTreeADT.BinaryNode<T> nodePointer;

        public Iterator(BinaryNode<T> root)
        {
            nodePointer=root;
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
            System.out.println("Problem wih has left");
            boolean hasLeft=false;
            BinaryNode<T> lt=this.nodePointer.getLeftChild();
            if(lt != null){
                hasLeft=true;
            }
            return hasLeft;
        }

        public boolean hasRight()
        {
            System.out.println("Problem with has right");
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
                System.out.println("test has next");
                if(!hasLeft())
                {
                    throw new java.util.NoSuchElementException();
                }
                System.out.println("setting nextLeft");
                if(this.nextLeft == null)
                {
                    setNext();
                }
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
                System.out.println("test has next");
                if(!hasRight())
                {
                    throw new java.util.NoSuchElementException();
                }
                System.out.println("setting nextRight");
                if(this.nextRight == null)
                {
                    setNext();
                }
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

