package homework;
 
class Node {
    Node previous, next;
    int contents;
    
    Node(int val) {
        this.contents = val;
    }
}
 
class List {
    Node first;
 
    void add(int num) { 
        Node x = new Node(num);
        if(first == null) {
            this.first = x;
        }else{
            Node current = this.first;
            boolean inList = false;
            
            while(current.next != null) {
                if(current.contents == num) inList = true;
                current = current.next;
            }
            
            if(!inList) {
                current.next = x;
                x.previous = current;                
            }
        }
    }
    
    void remove(int num) { 
        Node current = this.first;

        while(current.next != null) {
            if(current.contents == num) {
                if(current.previous != null) {
                    current.previous.next = current.next;
                }
                if(current.next != null) {
                    current.next.previous = current.previous;
                }  
            }
            current = current.next;
        }       
    }
    
    boolean contains(int num) {
        Node current = this.first;

        while(current.next != null) {
            if(current.contents == num) return true;
            current = current.next;
        }

        return false;
    }
}