package org.cloud.mvn.zstudy.dataStructuresAndAlgorithms.binaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinaryTree {
	public static void main(String[] args) throws IOException {
		BinaryTreeAPI();
	}
	/**
	 * @Author LiuTao @Date 2020年6月9日 上午10:11:29 
	 * @Title: BinaryTreeAPI 
	 * @Description: TODO(Describe) 
	 * @throws IOException
	 */
	public static void BinaryTreeAPI() throws IOException{
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		while(true){
			System.out.print("Enter first letter of show, ");
			System.out.print("insert, find, delete, or traverse: ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				theTree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				Node found = theTree.find(value);
				if(found != null){
					System.out.println("Found: ");
					found.displayNode();
					System.out.print("\n");
				}else {
					System.out.println("Could not find " + value);
				}
				break;
			case 'd':
				System.out.print("Enter value to delete: ");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if(didDelete)
					System.out.println("Deleted " + value);
				else 
					System.out.println("Could not delete " + value);
				break;
			case 't':
				System.out.print("Enter type 1, 2 or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.println("Invalid entry");
				break;
			}
		}
	}
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
/**
 * @Author LiuTao @Date 2020年11月10日 下午5:09:41
 * @ClassName: Node 
 * @Description: 节点类
 */
class Node{
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	public void displayNode(){
		System.out.print("{");
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("}");
	}
}
/**
 * @Author LiuTao @Date 2020年11月10日 下午5:09:27
 * @ClassName: Tree 
 * @Description: 树类
 */
class Tree{
	private Node root;
	public Tree(){
		root = null;
	}
	/**
	 * @Author LiuTao @Date 2020年6月9日 上午10:10:54 
	 * @Title: find 
	 * @Description: 查找 
	 * @param key
	 * @return
	 */
	public Node find(int key){
		Node current = root;
		while(current.iData != key){
			if(key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
			if(current == null)
				return null;
		}
		return current;
	}
	/**
	 * @Author LiuTao @Date 2020年6月9日 上午10:10:38 
	 * @Title: insert 
	 * @Description: 插入 
	 * @param id
	 * @param dd
	 */
	public void insert(int id, double dd){
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if(root == null){
			root = newNode;
		}else {
//			Node parent = root;
//			
//			while(true){
//				
//			}
			Node current = root;
			Node parent;
			while(true){
				parent = current;//此处类似递归,子节点不为空时,将该子节点作为父节点赋值
				if(id < current.iData){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				}else {
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
			
			
//			Node parent = root;
//			Node current;
//			while(true){
//				if(id < parent.iData){
//					current = parent.leftChild;
//					if(current == null){
//						parent.leftChild = newNode;
//						return;
//					}
//				}else {
//					current = parent.rightChild;
//					if(current == null){
//						parent.rightChild = newNode;
//						return;
//					}
//				}
//			}
		}
	}
	/**
	 * @Author LiuTao @Date 2020年6月9日 上午10:09:25 
	 * @Title: delete 
	 * @Description: 删除 
	 * @param key
	 * @return
	 */
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(current.iData != key){
			parent = current;
			if(key < current.iData){
				isLeftChild = true;
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null)
				return false;
		}
		if(current.leftChild == null && current.rightChild == null){
			if(current == root)
				root = null;
			else if (isLeftChild) 
				current.leftChild = null;
			else
				current.rightChild = null;
		}else if(current.rightChild == null){
			if(current == root)
				root = current.leftChild;
			else if (isLeftChild) 
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}else if(current.leftChild == null){
			if(current == root)
				root = current.rightChild;
			else if (isLeftChild) 
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}else {
			Node successor = getSuccessor(current);
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return true;
			
	} 
	public Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode;
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	public void traverse(int traverseType){
		switch (traverseType) {
		case 1:
			System.out.print("\nPreOrder traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInOrder traversal: ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostOrder traversal: ");
			postOrder(root);
			break;
		}
	}
	public void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.iData + " " );
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	public void inOrder(Node localRoot){
		if(localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " " );
			inOrder(localRoot.rightChild);
		}
		
	}
	public void postOrder(Node localRoot){
		if(localRoot != null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " " );
		}
		
	}
	/**
	 * @Author LiuTao @Date 2020年6月9日 上午10:10:00 
	 * @Title: displayTree 
	 * @Description: 打印树,从根节点开始打印,每一级的节点在同一个Stack中
	 */
	public void displayTree(){
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("---------------------------------------------------------------------------------------------");
		while(isRowEmpty == false){
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			while(globalStack.isEmpty() == false){
				Node temp = globalStack.pop();
				if(temp != null){
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);//这儿先放左节点再放右节点,当pop时后进先出,
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}else {
					System.out.print(" ");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++) 
					System.out.print(" ");
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false) 
				globalStack.push(localStack.pop());//localStack.pop后进先出,再push到globalStack时,左节点在栈顶
		}
		System.out.println("---------------------------------------------------------------------------------------------");
	}
}