
public class main {

    public static void testLinkedList(){
        linkedList l = new linkedList();
        l.insert_node(1, 0);
        l.insert_node(2, 0);
        l.insert_node(3, 0);
        l.insert_node(4, 0);
        l.insert_node(5, 0);
        l.printList();
        l.reverse_list();
        l.printList();
        l.recursive_reverse();
        System.out.println();
        l.printList();
    }

    public static void main(String[] args) {






    }
}
