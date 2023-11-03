package ListAssignment;



public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head=null;// your code here
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove() {
    	if(head==null) {
    		return;
    	}else if(head.next==null) {
    		head=null;
    	}else {
    		Node runner= head;
    		while(runner.next.next != null) {
                runner = runner.next;
            }
            runner.next = null;
        }
    }
    public void printValues() {
    	Node runner= head;
    	System.out.println(runner.value);
    	runner= runner.next;
    }
    public Node find(int value) {
		Node runner= head;
    	while(runner!= null) {
    		if (runner.value==value) {
    			return runner;
    		}
    		runner=runner.next;
    	}
    	return null;
    }
    
    public void removeAt(int n) {
    	if(head==null) return;
    	if(n==0) {
    		head= head.next;
    		return;
    	}
    	Node runnerNode= head;
    	int count=1;
		while(runnerNode.next!=null && count <n) {
    		runnerNode=runnerNode.next;
    		count++;
    	}
    	if(runnerNode.next!= null) {
    		runnerNode.next=runnerNode.next.next;
    	}
}
}

