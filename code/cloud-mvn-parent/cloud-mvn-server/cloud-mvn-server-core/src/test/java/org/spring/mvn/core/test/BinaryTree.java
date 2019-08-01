package org.spring.mvn.core.test;
/**
 * @author LiuTao @date 2019年7月30日 上午10:50:03
 * @ClassName: BinaryTree 
 * @Description: 二叉树
 */
public class BinaryTree {
	public static void main(String[] args) {
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
		preTraverseBTree(treeNode1);
		inTraverseBTree(treeNode1);
	}
	/**
	 * @author LiuTao @date 2019年7月30日 上午10:43:52 
	 * @Title: preTraverseBTree 
	 * @Description: 先序遍历 
	 * @param rootTreeNode
	 */
	public static void preTraverseBTree(TreeNode rootTreeNode) {
		if(rootTreeNode != null){
			//
			System.out.println(rootTreeNode.getValue());
			//
			preTraverseBTree(rootTreeNode.getLeftNode());
			//
			preTraverseBTree(rootTreeNode.getRightNode());
		}
	}
	/**
	 * @author LiuTao @date 2019年7月30日 上午10:44:36 
	 * @Title: inTraverseBTree 
	 * @Description: 中序遍历 
	 * @param rootTreeNode
	 */
	public static void inTraverseBTree(TreeNode rootTreeNode) {
		if (rootTreeNode != null) {

            //访问左节点
            inTraverseBTree(rootTreeNode.getLeftNode());

            //访问根节点
            System.out.println(rootTreeNode.getValue());

            //访问右节点
            inTraverseBTree(rootTreeNode.getRightNode());
        }
	}
}
