package lab06;

public class Node {
	
	Object value;
	Node next;
	
	public Node(int value, Node next){
		this.value = value;
		this.next = next;
	}
	
	public Node(Object value){
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
