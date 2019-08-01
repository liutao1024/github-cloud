package org.spring.mvn.core.test;
/**
 * @author LiuTao @date 2019年7月30日 上午10:50:03
 * @ClassName: BinaryTree 
 * @Description: 二叉树
 */
public class BinaryTree {
	public TreeNode root;
	public TreeNode getRoot(){
		return root;
	}
	
	/**
	 * 插入二叉树排序 有序插入 (大于根节点放右边 小于根节点放左边)
	 * @param value
	 */
	public void insert(int value) {

	    TreeNode newNode = new TreeNode(value);
	    if (root == null) {
	        root = newNode;
	        root.setLeftNode(null);
	        root.setRightNode(null);
	    } else {
	        TreeNode currentNode = root;
	        TreeNode parentNode;
	        // 有孩子继续循环,一直循环到最后一个节点 和插入的节点比较 大的放到右节点,小于放到左节点
	        while (true) {
	            parentNode = currentNode;
	            // 往右放
	            if (Integer.valueOf(newNode.getValue()) > Integer.valueOf(currentNode.getValue())) {
	                currentNode = currentNode.getRightNode();
	                if (currentNode == null) {
	                    parentNode.setRightNode(newNode);
	                    return;
	                }
	            } else {
	                // 往左放
	                currentNode = currentNode.getLeftNode();
	                if (currentNode == null) {
	                    parentNode.setLeftNode(newNode);
	                    return;
	                }
	            }
	        }
	    }
	}
	/**
	 * @author LiuTao @date 2019年8月1日 上午11:22:36 
	 * @Title: inOrder 
	 * @Description: 中序遍历 
	 * @param treeNode
	 */
	public void inOrder(TreeNode treeNode){
		if (treeNode != null) {
			inOrder(treeNode.getLeftNode());
			System.out.print(" " + treeNode.getValue() + " ");
			inOrder(treeNode.getRightNode());
		}
	}
	/**
	 * @author LiuTao @date 2019年7月30日 上午10:43:52 
	 * @Title: beforOrder 
	 * @Description: 先序遍历 
	 * @param treeNode
	 */
	public void beforeOrder(TreeNode treeNode) {
		if(treeNode != null){
			//
			System.out.print(" " + treeNode.getValue() + " ");
			//
			beforeOrder(treeNode.getLeftNode());
			//
			beforeOrder(treeNode.getRightNode());
		}
	}
	/**
	 * @author LiuTao @date 2019年7月30日 上午10:44:36 
	 * @Title: afterOrder 
	 * @Description: 后序遍历 
	 * @param treeNode
	 */
	public void afterOrder(TreeNode treeNode) {
		if (treeNode != null) {
			afterOrder(treeNode.getLeftNode());
            afterOrder(treeNode.getRightNode());
            System.out.print(" " + treeNode.getValue() + " ");
        }
	}
	/**
	 * @author LiuTao @date 2019年8月1日 上午11:32:57 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		//根节点10
		TreeNode treeNode1 = new TreeNode(10);
		//10的左节点
		TreeNode treeNode2 = new TreeNode(21);
		//10的右节点
		TreeNode treeNode3 = new TreeNode(23);
		//21的左节点
		TreeNode treeNode4 = new TreeNode(24);
		//21的右节点
		TreeNode treeNode5 = new TreeNode(8);
		//23的右节点
		TreeNode treeNode6 = new TreeNode(32);
		//8的左节点
		TreeNode treeNode7 = new TreeNode(1);
		//1的左节点
		TreeNode treeNode8 = new TreeNode(0);
		//1的右节点
		TreeNode treeNode9 = new TreeNode(99);
		
		treeNode1.setLeftNode(treeNode2);
		treeNode1.setRightNode(treeNode3);
		treeNode2.setLeftNode(treeNode4);
		treeNode2.setRightNode(treeNode5);
		treeNode3.setRightNode(treeNode6);
		treeNode4.setLeftNode(treeNode7);
		treeNode7.setLeftNode(treeNode8);
		treeNode7.setRightNode(treeNode9);
		binaryTree.beforeOrder(treeNode1);
		System.out.println();
		binaryTree.inOrder(treeNode1);
		System.out.println();
		binaryTree.afterOrder(treeNode1);
		System.out.println();
		
		
		BinaryTree tree = new BinaryTree();
	    tree.insert(5);
	    tree.insert(7);
	    tree.insert(4);
	    tree.insert(8);
	    tree.insert(6);
	    tree.insert(2);
	    tree.insert(3);
	    tree.insert(9);
	    System.out.println(tree.root);
	    tree.beforeOrder(tree.getRoot());
	    System.out.println();
	    tree.inOrder(tree.getRoot());
	    System.out.println();
	    tree.afterOrder(tree.getRoot());
	}
	
}

