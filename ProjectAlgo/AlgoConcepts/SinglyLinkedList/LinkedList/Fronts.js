// Add Front
// Write a method that accepts a value and create a new node, assign it to the list head, and return a pointer to the new head node.

// Remove Front
// Write a method to remove the head node and return the new list head node. If the list is empty, return null.

// Front
// Write a method to return the value (not the node) at the head of the list. If the list is empty, return null.

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}
class SLL{
    constructor(){
        this.head = null;
    }
    addFront(value){
        let newNote = new Node(value);
        if (!this.head) {
            this.head = newNote;
            return this;
        }
        newNote.next = this.head;
        this.head = newNote;
        return this;
    }
    removeFront(){
        if(!this.head){
            return null;
        }
        this.head = this.head.next;
        return this
    }
    front(){
        if(!this.head){
            return null;
        }
        return this.head.data;

    }
}


let list = new SLL(); 
let val= list.addFront(18).addFront(15).removeFront().front()
console.log(val);