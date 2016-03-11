package DataStructures.Tree;

import DataStructures.Comparable;

class BinaryNode {
	BinaryNode(Comparable theElement) {
		this(theElement, null, null);
	}

	BinaryNode(Comparable theElement, BinaryNode lt, BinaryNode rt) {
		element = theElement;
		left = lt;
		right = rt;
	}

	Comparable element; // The data in the node
	BinaryNode left; // Left child
	BinaryNode right; // Right child
}
