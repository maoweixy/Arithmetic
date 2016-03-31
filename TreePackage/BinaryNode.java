package TreePackage;

public class BinaryNode<T> {
	private T rootData;
	private BinaryNode<T> leftNode;
	private BinaryNode<T> rightNode;
//	public BinaryNode(){
//		rootData = null;
//	}c
	public BinaryNode(T data){
		this(data, null, null);
	}
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
		this.rootData = data;
		this.leftNode = left;
		this.rightNode = right;
	}
	public void setRootData(T data){
		rootData = data;
	}
	public T getRootData(){
		return rootData;
	}
	public BinaryNode<T> getLeftChild(){
		return leftNode;
	}
	public BinaryNode<T> getRightChild(){
		return rightNode;
	}
	public void setLeftChild(BinaryNode<T> leftChild) {  
        leftNode = leftChild;
    }  
  
    public void setRightChild(BinaryNode<T> rightChild) {  
        rightNode = rightChild;  
    }  
    public int getHeight(BinaryNode<T> node){
    	int height = 0;
    	if (node != null) {
			height = 1 + Math.max(getHeight(node.leftNode), getHeight(node.rightNode)); 
		}
    	return height;
    }
}
