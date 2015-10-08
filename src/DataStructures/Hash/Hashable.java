package DataStructures.Hash;
public interface Hashable {
	/**
	 * 计算该对象的Hash函数
	 * 
	 * @param tableSize
	 *            the hash table size.
	 * @return (deterministically) a number between 0 and tableSize-1,
	 *         distributed equitably.
	 */
	int hash(int tableSize);
}
 