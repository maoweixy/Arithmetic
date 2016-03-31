package TreePackage;

public class BinarySearchTree <T extends Comparable<? super T>> 
extends BinaryTree<T> implements SearchTreeInterface<T>{

	public BinarySearchTree() {
		super();
	}
	public BinarySearchTree(T rootEntry) {
		super(rootEntry);
	}
	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	@Override
	public T getEntry(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if (root == null) {
			root = new BinaryNode<T>(newEntry);
//			setRootData(newEntry);//严重错误的写法，原因onenote树里面有
		}else {
			result = addEntry(this.root, newEntry);
		}
		return result;
	}
	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
		T result = null;
		T rootData = rootNode.getRootData();
		int com = newEntry.compareTo(rootData);
		if (com == 0) {
			result = rootData;
			rootNode.setRootData(newEntry);
		}else if (com < 0) {
			if (rootNode.getLeftChild() != null) {
				result = addEntry(rootNode.getLeftChild(), newEntry);
			}else {
				rootNode.setLeftChild(new BinaryNode<T>(newEntry));
			}
		}else {
			if (rootNode.getRightChild() != null) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			}else {
				rootNode.setRightChild(new BinaryNode<T>(newEntry));
			}
		}
		return result;
	}
}
