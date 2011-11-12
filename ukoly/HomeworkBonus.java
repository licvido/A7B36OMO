package homework;

import java.util.Iterator;



class Node {
    int contents;
    Node parent; // ukazatel na rodice tohoto uzlu
    Node left, right;
}



class NodeIterator implements Iterator<Node> {
    
    Node node;
    Node root;

    NodeIterator(Node root) {
        
        this.root = root;
        this.node = root;
        
        while (this.node.left != null) {
            this.node = this.node.left;
        }
        
        if (this.node == root) {
            this.node = this.node.right;
        }
    }

    public boolean hasNext() {
        
        if (this.node != null) {
            return true;
        } else {
            return false;
        }
    }

    public Node next() {
        
        Node n = this.node;
        
        if (this.node.right != null) {
            
            this.node = this.node.right;
            while (this.node.left != null) {
                this.node = this.node.left;
            }
            
        } else {
            
            while (this.node == this.node.parent.right && this.node.parent != null) {
                this.node = this.node.parent;
            }
            
            if (this.node == this.root) {
                this.node = null;
            } else {
                
                this.node = this.node.parent;
                if (this.node == this.root) {   
                    
                    this.node = this.node.right; 
                    while (this.node != null && this.node.left != null) {
                        this.node = this.node.left;
                    }
                    
                }
            }
        }
        
        return n;
    }

    public void remove() {
        // nic
    }
}