package homework;

class Node {
	
	Node next;
	int contents;
}

class Iterator {
	
	private static Node current;
	
	Iterator(Node node) {
		current = node;
	}
	
	int next() {
		
		if (this.hasNext()) {
			while (current.contents % 2 != 0) {
				current = current.next;
			}
			int currNext = current.contents;
			current = current.next;
			return currNext;
		}
		return 0;
	}
	
	boolean hasNext() {
		Node tmp = current;
		while (tmp != null) {
			if (tmp.contents % 2 == 0) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
}