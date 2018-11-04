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


    public static class Iterator<T extends Comparable<T>>
    {
        /*Implement an iterator which goes to the next node in the tree
         * Ensure no concurrent modification exceptions
         */
        private BinarySearchTreeADT.BinaryNode<T> nextLeft;
        private BinarySearchTreeADT.BinaryNode<T> nextRight;
        public  BinarySearchTreeADT.BinaryNode<T> nodePointer;
        private BinaryNode<T> previousPtr;

        public Iterator(BinaryNode<T> root)
        {
            nodePointer=root;
            previousPtr=null;
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
            BinaryNode<T> lt=nodePointer.getLeftChild();
            BinaryNode<T> rt=nodePointer.getRightChild();
            if(hasLeft()){
                nextLeft=lt;
            }

            if(hasRight()){
                nextRight=rt;
            }
        }

        public boolean hasLeft()
        {
            boolean hasLeft=false;
            BinaryNode<T> lt=nodePointer.getLeftChild();
            if(lt != null){
                hasLeft=true;
            }
            return hasLeft;
        }

        public boolean hasRight()
        {
            boolean hasRight=false;
            BinaryNode<T> rt=nodePointer.getRightChild();
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

                if(nextLeft == null)
                {
                    setNext();
                }
                this.previousPtr=nodePointer;
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
                if(nextRight == null)
                {
                    setNext();
                }
                this.previousPtr=nodePointer;
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

