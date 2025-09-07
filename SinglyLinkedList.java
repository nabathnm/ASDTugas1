public class SinglyLinkedList {
    NodeSingly head, tail;
    int size = 0;

    // METHOD DARI SLIDE MATERI

    void inisiasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void showForward() {
        NodeSingly p = head;
        System.out.println("\nData Singly Linkedlist urutan dari depan:");
        while (p != null) {
            System.out.print(p.data + " , ");
            p = p.pointer;
        }
        System.out.println();
    }
    
    void addFirst(NodeSingly input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.pointer = head;
            head = input;
        }
        size++;
    }

    void addFirst(Object input) {
        addFirst(new NodeSingly(input));
    }

    void addLast(NodeSingly input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.pointer = input;
            tail = input;
        }
        size++;
    }

    void addLast(Object input) {
        addLast(new NodeSingly(input));
    }

    void insertBefore(Object key, NodeSingly input) {
        NodeSingly temp = head;
        while (temp != null) {
            if ((temp.data == key) && (temp == head)) {
                this.addFirst(input);
                break;
            } else if (temp.pointer.data == key) {
                input.pointer = temp.pointer;
                temp.pointer = input;
                break;
            }
            temp = temp.pointer;
        }
    }

    void insertBefore(Object key, Object input) {
        insertBefore(key, new NodeSingly(input));
    }

    void insertAfter(Object key, NodeSingly input) {
        NodeSingly temp = head;
        do { 
            if (temp.data == key) {
                input.pointer = temp.pointer;
                temp.pointer = input;
                size++;
                break;
            } else {
                temp = temp.pointer;
            }
        } while (temp != null);
    }

    void insertAfter(Object key, Object input) {
        insertAfter(key, new NodeSingly(input));
    }

    void removeFirst() {
        NodeSingly temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                temp = temp.pointer;
                head = temp;
                temp = null;
            }
            size --;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void removeLast() {
        NodeSingly temp = tail;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                NodeSingly p = head;
                while (p.pointer != tail) {
                    p = p.pointer;
                }
                p.pointer = null;
                tail = p;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void remove(Object key) {
        if (!isEmpty()) {
            NodeSingly p = head;
            NodeSingly prev = null;

            while (p != null) {
                if (p.data.equals(key)) {
                    if (p == head) {
                        removeFirst();
                    } else if (p == tail) {
                        removeLast();
                    } else {
                        prev.pointer = p.pointer;
                        size--;
                    }
                    return;
                }
                prev = p;
                p = p.pointer;
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " size = " + size);
    }

    // METHOD SUDAH ADA DI SLIDE TETAPI DIMINTA DI SOAL
    
    // public Object get(int index) {
    //     checkIndex(index);

    //     NodeSingly currentNode = head;
    //     for (int i = 0; i < index; i++) {
    //         currentNode = currentNode.pointer;
    //     }
    //     return currentNode.data;
    // }

    // public int indexOf(Object theElment) {
    //     NodeSingly currentNode = head;
    //     int index = 0;
    //     while (currentNode != null && !currentNode.data.equals(theElment)) {
    //         currentNode = currentNode.pointer;
    //         index++;
    //     }
    //     if (currentNode == null) {
    //         return -1;
    //     } else {
    //         return index;
    //     }
    // }

    public Object remove(int index) {
        checkIndex(index);

        Object removeElement;
        if (index == 0) {
            removeElement = head.data;
            head = head.pointer;
        } else {
            NodeSingly q = head;
            for (int i = 0; i < index - 1; i++) {
                q = q.pointer;
            }
            removeElement = q.pointer.data;
            q.pointer = q.pointer.pointer;
            tail = q;
        }
        size--;
        return removeElement;
    }

    public void add(int index, Object theElement) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException ("index = " + index + " size = " + size);
        if (index == 0) {
            head = new NodeSingly(theElement, head);
        } else {
            NodeSingly p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.pointer;
            }
            p.pointer = new NodeSingly(theElement, p.pointer);
        }
        size++;
    }

    // METHOD YANG DIMINTA DALAM LATIHAN

    void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " size = " + size);
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            NodeSingly p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.pointer;
            }
            NodeSingly newNode = new NodeSingly(data);
            newNode.pointer = p.pointer;
            p.pointer = newNode;
            size++;
        }
    }

    void removeAt(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            NodeSingly prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.pointer;
            }
            NodeSingly toRemove = prev.pointer;
            prev.pointer = toRemove.pointer;
            toRemove = null;
            size--;
        }
    }

    Object get(int index) {
        checkIndex(index);

        NodeSingly currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }
        return currentNode.data;
    }

    boolean contains(Object data) {
        NodeSingly currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.pointer;
        }
        return false;
    }

    int indexOf(Object data) {
        NodeSingly currentNode = head;
        int index = 0;
        while (currentNode != null && !currentNode.data.equals(data)) {
            currentNode = currentNode.pointer;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
        }
    }
}