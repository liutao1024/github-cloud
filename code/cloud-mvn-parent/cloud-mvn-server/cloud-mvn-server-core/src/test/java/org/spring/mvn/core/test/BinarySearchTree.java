package org.spring.mvn.core.test;
/**
 * @author LiuTao @date 2019年7月30日 上午10:50:16
 * @ClassName: BinarySearchTree  二叉查询树
 * @Description: 定义:当前根节点的左边全部比根节点小,当前根节点的右边全部比根节点大
 */
public class BinarySearchTree {
	public static void main(String[] args) {
//		int[] arrays = {3,2,1,4,5};
	}
	
	/**
     * 动态创建二叉查找树
     * @param treeRoot 根节点
     * @param value 节点的值
     */
    public static void createTree(TreeRoot treeRoot, int value) {
        //如果树根为空(第一次访问),将第一个值作为根节点
        if (treeRoot.getTreeRoot() == null) {
            TreeNode treeNode = new TreeNode(value);
            treeRoot.setTreeRoot(treeNode);
        } else {
            //当前树根
            TreeNode tempRoot = treeRoot.getTreeRoot();
            while (tempRoot != null) {
                //当前值大于根值,往右边走
                if (value > tempRoot.getValue()) {
                    //右边没有树根,那就直接插入
                    if (tempRoot.getRightNode() == null) {
                        tempRoot.setRightNode(new TreeNode(value));
                        return ;
                    } else {
                        //如果右边有树根,到右边的树根去
                        tempRoot = tempRoot.getRightNode();
                    }
                } else {
                    //左没有树根,那就直接插入
                    if (tempRoot.getLeftNode() == null) {
                        tempRoot.setLeftNode(new TreeNode(value));
                        return;
                    } else {
                        //如果左有树根,到左边的树根去
                        tempRoot = tempRoot.getLeftNode();
                    }
                }
            }
        }
    }
}
class TreeRoot{
	private TreeNode treeRoot;

	public TreeNode getTreeRoot() {
		return treeRoot;
	}

	public void setTreeRoot(TreeNode treeRoot) {
		this.treeRoot = treeRoot;
	}
}
