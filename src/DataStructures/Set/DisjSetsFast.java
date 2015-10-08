package DataStructures.Set;

// DisjSetsFast class
//
// CONSTRUCTION: with int representing initial number of sets
//
// ******************PUBLIC OPERATIONS*********************
// void union( root1, root2 ) --> Merge two sets
// int find( x )              --> Return set containing x
// ******************ERRORS********************************
// No error checking is performed

/**
 * Disjoint set class, using union by rank and path compression. Elements in the
 * set are numbered starting at 0.
 * 
 * @author Mark Allen Weiss
 */
public class DisjSetsFast {
	/**
	 * ������
	 * 
	 * @param numElements
	 *            the initial number of disjoint sets.
	 */
	public DisjSetsFast(int numElements) {
		s = new int[numElements];
		for (int i = 0; i < s.length; i++)
			s[i] = -1;
	}

	/**
	 * ���ո߶���
	 * 
	 * @param root1
	 *            the root of set 1.
	 * @param root2
	 *            the root of set 2.
	 */
	public void union(int root1, int root2) {
		if (s[root2] < s[root1]) // ���Ķ�ı�ʾ������һ��
			s[root1] = root2; // ��ǳ���ĸ�ָ�������ĸ�
		else {
			if (s[root1] == s[root2])
				s[root1]--; // ��������߶���ͬ��root1����һ��
			s[root2] = root1; // root1��Ϊroot2�ĸ�
		}
	}

	/**
	 * ����
	 * 
	 * @param x
	 *            Ҫ���ҵ���
	 * @return ����x�ĸ�
	 */
	public int find(int x) {
		if (s[x] < 0) //����Ǹ�
			return x;
		else
			return s[x] = find(s[x]); //������Ǹ����ݹ���ҡ�������·��ѹ��
	}

	private int[] s; //�洢���Եĸ�

	// Test main; all finds on same output line should be identical
	public static void main(String[] args) {
		int NumElements = 128;
		int NumInSameSet = 16;

		DisjSetsFast ds = new DisjSetsFast(NumElements);
		int set1, set2;

		for (int k = 1; k < NumInSameSet; k *= 2) {
			for (int j = 0; j + k < NumElements; j += 2 * k) {
				set1 = ds.find(j);
				set2 = ds.find(j + k);
				ds.union(set1, set2);
			}
		}

		for (int i = 0; i < NumElements; i++) {
			System.out.print(ds.find(i) + "*");
			if (i % NumInSameSet == NumInSameSet - 1)
				System.out.println();
		}
		System.out.println();
	}
}
