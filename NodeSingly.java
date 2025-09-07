public class NodeSingly {
    Object data;
    NodeSingly pointer;

    NodeSingly() {}
    
    NodeSingly(Object data) {
        this.data = data;   
    }

    NodeSingly(Object data, NodeSingly pointer) {
        this.data = data;
        this.pointer = pointer;
    }
}