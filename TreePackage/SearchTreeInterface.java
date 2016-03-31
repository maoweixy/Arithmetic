package TreePackage;

public interface SearchTreeInterface<T extends Comparable<? super T>> 
extends TreeInterface<T>{
//	public boolean contains(T entry);
	/*Task ����ָ������
	 * @param entry �����Ҷ���
	 * @return �����ҵ��Ķ���û����null
	 */
	public T getEntry(T entry);
	
	/*Task ��Ԫ�ز������� 
	 * @param newEntry ���������
	 * @return newEntry�����ڷ���null�����ڷ��غ�newEntry��ƥ���Ԫ��
	 */
	public T add(T newEntry);
}
