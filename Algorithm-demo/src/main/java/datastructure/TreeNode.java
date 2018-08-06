package datastructure;

/**
 * @author yanmingkun
 * @date 2018-08-06 10:30
 */
public class TreeNode<T> {
    private TreeNode leftChild = null;
    private TreeNode rightChild = null;
    private T data;

    public TreeNode() {
        this(null);
    }

    public TreeNode(T data) {
        this(data, null, null);
    }

    public TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;

    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = (TreeNode<T>) leftChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = (TreeNode<T>) rightChild;
    }


    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (leftChild != null) {
            leftNumber = leftChild.getNumberOfNodes();
        }
        if (rightChild != null) {
            rightNumber = rightChild.getNumberOfNodes();
        }
        return 1 + leftNumber + rightNumber;
    }

    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(TreeNode<T> node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
        }
        return height;
    }

    public TreeNode<T> copy() {
        TreeNode<T> newRoot = new TreeNode<T>(data);
        if (leftChild != null)
            newRoot.leftChild = (TreeNode<T>) leftChild.copy();
        if (rightChild != null)
            newRoot.rightChild = (TreeNode<T>) rightChild.copy();
        return newRoot;
    }
}
