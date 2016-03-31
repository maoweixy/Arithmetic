package TreePackage;

public interface SearchTreeInterface<T extends Comparable<? super T>> 
extends TreeInterface<T>{
//	public boolean contains(T entry);
	/*Task 检索指定对象
	 * @param entry 待查找对象
	 * @return 返回找到的对象，没有则null
	 */
	public T getEntry(T entry);
	
	/*Task 将元素插入树中 
	 * @param newEntry 待插入对象
	 * @return newEntry不存在返回null，存在返回和newEntry相匹配的元素
	 */
	public T add(T newEntry);
}
