package scarylist;

public class LinkedList {
	public Node head;
	
	public void add(String name){
		if(head == null){
			head = new Node(name);
		} else {
			Node at = findAlphaPosition(name);
			insertBefore(at,name);
		}
	
	}

	public void insertAfter(Node n, String name){
		if(n.next == null){
			n.next = new Node(name);
		} else {
			Node temp = n.next;
			
			Node toInsert = new Node(name);
			toInsert.next = temp;
			
			n.next = toInsert;	
		}		
	}
	
	public void removeNode(Node n){
		if(n == head){
			head = head.next;
		} else {
			Node prev = getPrev(n);
			Node next = n.next;
			prev.next = next;
		}		
	}
	
	public void insertBefore(Node n, String name){
		if(n == head){
			Node temp = new Node(name);
			temp.next = this.head;
			this.head = temp;
		} else {
			Node temp = getPrev(n);
			insertAfter(temp,name);	
		}
	}
	
	public Node getPrev(Node n){
		Node temp = head;
		if(head == n){
			//Can't go back
			System.out.println("Can't go previous to head");
			return null;
		}
		while(temp.next != null){
			if(temp.next.equals(n)){
				return temp;
			}
			temp = temp.next;
		}
		return temp;
	}
	
	public Node findAlphaPosition(String name){
		if(head == null){
			return head;
		} else {
			Node temp = head;
			while(temp.next != null){
				if(name.compareTo(temp.name) < 1){
					return temp;
				} else {
					temp = temp.next;
				}
			}
			
			return null;
		}
	}
	
	public void addAtHead(String name){
		if(head == null){
			head = new Node(name);			
		} else {
			Node temp = new Node(name);
			temp.next = head;
			this.head = temp;
		}
	}
	
	public void addAtLast(String name){
		if(head == null){
			head = new Node(name);
		} else {
			Node last = findLastNode();
			last.next = new Node(name);
		}
	}
	
	public Node removeFirst(){
		if(head == null){
			return null;
		} else {
			return head = head.next;
		}
	}
	
	public void print(){
		Node temp = head;
		System.out.println("");
		if(temp == null){
			System.out.println("Empty List. ");
		} else {	
			while(temp != null){
				System.out.println(temp.name + " ");
				temp = temp.next;
			}
		}
	}
	
	public Node findLastNode(){
		if(head == null){
			return head;
		} else {
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			return temp;
		}
	}
	
	public void empty(){
		this.head = null;
	}

	public LinkedList beginingWith(String str){
		LinkedList tempList = new LinkedList();
		Node pointer = this.head;
		while(pointer != null){
			if(pointer.name.contains(str)){
				tempList.add(pointer.name);
			}
			pointer = pointer.next;
		}
		
		return tempList;
	}
}
