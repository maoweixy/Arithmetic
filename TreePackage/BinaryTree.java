package TreePackage;

import java.util.Iterator;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
	public BinaryNode<T> root;
	public BinaryTree(){
		root = null;
	}
	public BinaryTree(T rootData){
		root = new BinaryNode<T>(rootData);
	}
	public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right){
		privateSetTree(rootData, left, right);
	}

	public int getHeight(){
		return root.getHeight(root);
	}
	public void setRootData(T rootData) {
		root.setRootData(rootData);
	}

	@Override
	public T getRootData() {
		return root.getRootData();
//		return null;
	}
	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		privateSetTree(rootData,(BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}
	private void privateSetTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
		// TODO Auto-generated method stub
		root = new BinaryNode<T>(rootData);
		if (left != null) {
			root.setLeftChild(left.root);
		}
		if (right != null) {
			root.setRightChild(right.root);
		}
	}
	/**
	 * ÖÐÐò±éÀú
	 */
	public void inorderTraverse(){
		inorderTraverse(root);

	}
	public void inorderTraverse(BinaryNode<T> node){
		if (node != null) {
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getRootData());
			inorderTraverse(node.getRightChild());
		}
	}
	public static void main(String[] args) {
		 BinaryTreeInterface<String> eTree = new BinaryTree<String>();  
		 eTree.setTree("E");
		 BinaryTreeInterface<String> fTree = new BinaryTree<String>();  
		 fTree.setTree("F");  
		 BinaryTreeInterface<String> gTree = new BinaryTree<String>();  
		 gTree.setTree("G");  
		 BinaryTreeInterface<String> hTree = new BinaryTree<String>();  
		 hTree.setTree("H");  
		   
		 BinaryTreeInterface<String> bTree = new BinaryTree<String>();  
		 bTree.setTree("B", eTree, fTree);  
		   
		 BinaryTreeInterface<String> cTree = new BinaryTree<String>();  
		 cTree.setTree("C", gTree, hTree);  
		   
		 BinaryTreeInterface<String> aTree = new BinaryTree<String>();  
		 aTree.setTree("A", bTree, cTree);
		 
		 ((BinaryTree<String>)aTree).inorderTraverse();
//		 ((BinaryTree<String>)gTree).setRootData("mao");
//		 gTree = new BinaryTree<String>();
//		 gTree.setTree("1");
		 System.out.println("");
		 ((BinaryTree<String>)aTree).inorderTraverse();
		 int t = ((BinaryTree<String>)aTree).getHeight();
		 System.out.println("");
		 System.out.println(t);
	}
}
