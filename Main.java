
class Main {
    public static void main(String[] args) {

        System.out.println("Singly Linkedlist");

        SinglyLinkedList sll = new SinglyLinkedList();

        System.out.println("Penambahan data");
        sll.addFirst("A1"); // [A1]   size = 1
        sll.addLast("B5"); // [A1, B5]   size = 2
        sll.insertBefore("B5", "T4"); // [A1, T4, B5]   size = 3
        sll.insertAfter("A1", "G2"); // [A1, G2, T4, B5]   size = 4
        sll.insertAt(2, "P3"); // [A1, G2, P3, T4, B5]   size = 5
        sll.insertAt(3, "C3"); // [A1, G2, P3, C3, T4, B5]   size = 6
        sll.insertAt(4, "I3"); // [A1, G2, P3, C3, I3, T4, B5]   size = 7

        System.out.println("Menampilkan data");
        sll.showForward(); // Data Singly Linkedlist urutan dari depan: A1, G2, P3, C3, I3, T4, B5,

        System.out.println("Penghapusan data");
        sll.removeFirst();  // [G2, P3, C3, I3, T4, B5]   size = 6
        sll.removeLast(); // [G2, P3, C3, I3, T4]   size = 5
        sll.remove("G2"); // [P3, C3, I3, T4]   size = 4
        sll.removeAt(0); // [C3, I3, T4]   size = 3

        System.out.println("Menampilkan data");
        sll.showForward();  // Data Singly Linkedlist urutan dari depan: C3, I3, T4, 

        System.out.println("Pengecekan data");
        System.out.println("\nIndex ke 1 adalah: " + sll.get(1)); // Index ke 1 adalah: I3
        System.out.println("Data C3 berada dalam list: " + sll.contains("C3")); // Data C3 berada dalam list: true
        System.out.println("Data T4 berada pada index ke: " + sll.indexOf("T4")); // Data T4 berada pada index ke: 2


        System.out.println("Doubly Linkedlist");
        
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("Penambahan data");
        dll.addFirst("A1"); // [A1]   size = 1
        dll.addLast("B5"); // [A1, B5]   size = 2
        dll.insertBefore("B5", "T4"); // [A1, T4, B5]   size = 3
        dll.insertAfter("A1", "G2"); // [A1, G2, T4, B5]   size = 4
        dll.insertAt(2, "P3"); // [A1, G2, P3, T4, B5]   size = 5
        dll.insertAt(3, "C3"); // [A1, G2, P3, C3, T4, B5]   size = 6
        dll.insertAt(4, "I3"); // [A1, G2, P3, C3, I3, T4, B5]   size = 7

        System.out.println("Menampilkan data");
        dll.showForward(); // Data Doubly Linkedlist urutan dari depan: A1, G2, P3, C3, I3, T4, B5,
        dll.showBackward(); // Data Doubly Linkedlist urutan dari belakang: B5, T4, I3, C3, P3, G2, A1,

        System.out.println("Penghapusan data");
        dll.removeFirst();  // [G2, P3, C3, I3, T4, B5]   size = 6
        dll.removeLast(); // [G2, P3, C3, I3, T4]   size = 5
        dll.remove("G2"); // [P3, C3, I3, T4]   size = 4
        dll.removeAt(0); // [C3, I3, T4]   size = 3

        System.out.println("Menampilkan data");
        dll.showForward();  // Data Doubly Linkedlist urutan dari depan: C3, I3, T4, 
        dll.showBackward(); // Data Doubly Linkedlist urutan dari belakang: T4 , I3 , C3 ,

        System.out.println("Pengecekan data");
        System.out.println("\nIndex ke 1 adalah: " + sll.get(1)); // Index ke 1 adalah: I3
        System.out.println("Data C3 berada dalam list: " + sll.contains("C3")); // Data C3 berada dalam list: true
        System.out.println("Data T4 berada pada index ke: " + sll.indexOf("T4")); // Data T4 berada pada index ke: 2
    }
}