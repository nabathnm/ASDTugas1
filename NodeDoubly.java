public class NodeDoubly {
    Object data;
    NodeDoubly next;
    NodeDoubly prev;

    public NodeDoubly() {}

    public NodeDoubly(Object data) {
        this.data = data;
    }

    public NodeDoubly(Object data, NodeDoubly next, NodeDoubly prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    
}