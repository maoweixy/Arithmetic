package TreePackage;

public class Main {

	public static void main(String[] args) {
		SearchTreeInterface<Integer> tree = new BinarySearchTree<>();
		tree.add(6);
		tree.add(9);
		tree.add(10);
		tree.add(2);
		tree.add(8);
		tree.add(1);
		tree.add(4);
		System.out.println(tree.getRootData());
		((BinarySearchTree<Integer>)tree).inorderTraverse();
	}

}
