package datastructure;

import java.util.Stack;

/**
 * 二叉树
 *
 * @author yanmingkun
 * @date 2018-08-06 09:47
 */
public class BinaryTree<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new TreeNode<T>(rootData);
    }

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    }

    public void setTree(T rootData, BinaryTree<T> leftTree,
                        BinaryTree<T> rightTree) {
        privateSetTree(rootData, (BinaryTree) leftTree, (BinaryTree) rightTree);
    }

    private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new TreeNode<T>(rootData);
        if ((leftTree != null) && (!leftTree.isEmpty())) {
            root.setLeftChild(leftTree.root);
        }
        if ((rightTree != null) && (!rightTree.isEmpty())) {
            if (rightTree != leftTree) {
                root.setRightChild(rightTree.root);
            } else {
                root.setRightChild(rightTree.root.copy());
            }
        }
        if ((leftTree != null) && (leftTree != this)) {
            leftTree.clear();
        }
        if ((rightTree != null) && (rightTree != this)) {
            rightTree.clear();
        }
    }

    public void createTree(TreeNode<T> node, T data) {
        if (root == null) {
            root = new TreeNode<T>();
            root.setData(data);
        } else {
            if (Math.random() > 0.5) {                   //采用随机方式创建二叉树
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new TreeNode<T>(data));
                } else {
                    createTree(node.getLeftChild(), data);
                }
            } else {
                if (node.getRightChild() == null) {
                    node.setRightChild(new TreeNode<T>(data));
                } else {
                    createTree(node.getRightChild(), data);
                }
            }
        }
    }

    protected void setRootData(T rootData) {
        root.setData(rootData);
    }

    //更改根结点
    protected void setRootNode(TreeNode<T> rootNode) {
        root = rootNode;
    }

    protected TreeNode<T> getRootNode() {
        return root;
    }

    public void setTree(T rootData) {
        root = new TreeNode<T>(rootData);
    }

    public T getRootData() {
        T rootData = null;
        if (root != null) {
            rootData = root.getData();//调用节点的getData(),返回该节点的数据域
        }
        return rootData;
    }

    //返回二叉树的高度
    public int getHeight() {
        return root.getHeight();//二叉树的高度即为以根结点为根的子树的高度
    }

    //返回二叉树中结点的个数
    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void findMax() {
    }

    public void findMin() {
    }

    public void inOrderTraverse(TreeNode treeNode) {

        if (treeNode != null) {
            inOrderTraverse(treeNode.getLeftChild());
            visit(treeNode);
            inOrderTraverse(treeNode.getRightChild());
        }
    }

    public void nonRecInOrderTraverse(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = treeNode;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            }
            while (stack.size() > 0) {
                node = stack.pop();
                visit(node);
                node = node.getRightChild();
            }
        }


    }


    public void postOrderTraverse(TreeNode treeNode) {

        if (treeNode != null) {
            postOrderTraverse(treeNode.getLeftChild());
            postOrderTraverse(treeNode.getRightChild());
            visit(treeNode);
        }
    }

    public void nonRecPostOrderTraverse(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = treeNode;
        while (treeNode != null) {
            //左子树入栈
            for (; treeNode.getLeftChild() != null; treeNode = treeNode.getLeftChild()) {
                stack.push(treeNode);
            }
            //当前结点无右子树或右子树已经输出
            while (treeNode != null && (treeNode.getRightChild() == null || treeNode.getRightChild() == node)) {
                visit(treeNode);
                //纪录上一个已输出结点
                node = treeNode;
                if (stack.empty()) {
                    return;
                }
                treeNode = stack.pop();
            }
            //处理右子树
            stack.push(treeNode);

        }
    }

    public void preOrderTraverse(TreeNode treeNode) {

        if (treeNode != null) {
            visit(treeNode);
            preOrderTraverse(treeNode.getLeftChild());
            preOrderTraverse(treeNode.getRightChild());

        }
    }

    public void nonRecPreOrderTraverse(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = treeNode;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                visit(node);
                stack.push(node);
                node = node.getLeftChild();
            }
            while (stack.size() > 0) {
                node = stack.pop();
                node = node.getRightChild();
            }
        }
    }

    public void insert() {
    }

    public void remove(int key) {
    }

    public void search(int key) {
    }

    private void visit(TreeNode treeNode) {
        System.out.println("data:" + treeNode.getData());
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree();
        for (int i = 0; i < 10; i++) {
            binaryTree.createTree(binaryTree.root, i);
        }
        System.out.println("建立完毕");
        System.out.println("节点数：" + binaryTree.getNumberOfNodes());
        System.out.println("递归实现的中序遍历");
        binaryTree.inOrderTraverse(binaryTree.root);
        System.out.println("非递归实现的中序遍历");
        binaryTree.nonRecInOrderTraverse(binaryTree.root);
        System.out.println("递归实现的后序遍历");
        binaryTree.preOrderTraverse(binaryTree.root);
        System.out.println("非递归实现的后序遍历");
        binaryTree.nonRecPreOrderTraverse(binaryTree.root);
        System.out.println("递归实现的先序遍历");
        binaryTree.postOrderTraverse(binaryTree.root);
        System.out.println("非递归实现的先序遍历");
        binaryTree.nonRecPostOrderTraverse(binaryTree.root);
    }

}


