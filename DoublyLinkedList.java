class DoublyLinkedList {
    Object data;
    NodeDoubly head;
    NodeDoubly tail;
    int size = 0;

    // METHOD DARI SLIDE MATERI

    void inisiasi() {
        NodeDoubly head = null;
        NodeDoubly tail = null;
    }
    
    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void showForward() {
        NodeDoubly p = head;
        System.out.println("\nData Doubly Linkedlist urutan dari depan:");
        while (p != null) {
            System.out.print(p.data + " , ");
            p = p.next;
        }
        System.out.println();
    }

    void showBackward() {
        NodeDoubly p = tail;
        System.out.println("\nData Doubly Linkedlist urutan dari belakang:");
        while (p != null) {
            System.out.print(p.data + " , ");
            p = p.prev;
        }
        System.out.println();
}

    void addFirst(NodeDoubly input) {
        if (isEmpty()) {
            this.head = input;
            this.tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    void addFirst(Object input) {
        addFirst(new NodeDoubly(input));
    }

    void addLast(NodeDoubly input) {
        if (isEmpty()) {
            this.head = input;
            this.tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void addLast(Object input) {
        addLast(new NodeDoubly(input));
    }
    
    void insertBefore(Object key, NodeDoubly input) {
        NodeDoubly temp = head;
        while (temp != null) { 
            if(temp.data == key) {
                if (temp == head) {
                    this.addFirst(input);
                    System.out.println("");
                    size++;
                    break;
                } else {
                    input.prev = temp.prev;
                    input.next = temp;
                    temp.prev.next = input;
                    temp.prev = input;
                    System.out.println("");
                    size++;
                    break;
                }
            }
            temp = temp.next;
        }
    }

    void insertBefore(Object key, Object input) {
        insertBefore(key, new NodeDoubly(input));
    }

    void insertAfter(Object key, NodeDoubly input) {
        NodeDoubly temp = head;
        do { 
            if (temp.data == key) {
                input.prev = temp;
                input.next = temp.next;
                temp.next.prev = input;
                temp.next = input;
                size++;
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    void insertAfter(Object key, Object input) {
        insertAfter(key, new NodeDoubly(input));
    }

    void removeFirst() {
        NodeDoubly temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head.next.prev = null;
                head = temp.next;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void removeLast() {
        NodeDoubly temp = tail;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                tail.prev.next = null;
                tail = temp.prev;
            }
            size--;
        } else {
            System.out.println("Data is empty!");  
        }
    }

    void remove(Object key) {
        if (isEmpty()) {
            System.out.println("Data is empty!");
            return;
        }

        NodeDoubly temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                if (temp == head) {
                    removeFirst();
                } else if (temp == tail) {
                    removeLast();
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                }
                return;
            }
            temp = temp.next;
        }
    }

    // METHOD YANG DIMINTA DALAM LATIHAN
    
    void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " size = " + size);
        }

        NodeDoubly newNode = new NodeDoubly(data);

        if (index == 0) {
            addFirst(newNode);
        } else if (index == size) {
            addLast(newNode);
        } else {
            NodeDoubly current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " size = " + size);
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            NodeDoubly current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = null;
            size--;
        }
    }

    Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " size = " + size);
        }

        NodeDoubly current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    int indexOf(Object data) {
        NodeDoubly current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // data tidak ditemukan
    }
}