package DataStructures.Hash;
public interface Hashable {
	/**
	 * ����ö����Hash����
	 * 
	 * @param tableSize
	 *            the hash table size.
	 * @return (deterministically) a number between 0 and tableSize-1,
	 *         distributed equitably.
	 */
	int hash(int tableSize);
}
 