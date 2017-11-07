public class linkedList {

    public Node head;
    public int length;

    public class Node{
        public int value;
        public Node next;
        public Node(int val){
            this.value=val;
        }
    }
    public linkedList(){
        this.head=new Node(0);
        this.length=1;
    }
    public Node find_nth_node(int index){
        Node nth= this.head;
        for(int i=0; i<index; i++) nth=nth.next;
        return nth;
    }
    public void insert_node(int val, int pos){

        if(pos>=this.length) System.out.println("Error inserting, position is greater than size.");
        else if(pos<0) System.out.println("Position negative.");
        else{
            Node new_node;
            //insert new node to nth position-> between n and n+1
            Node nth= this.find_nth_node(pos);
            int nth_val= nth.value;
            //alter the value of nth node to new one
            nth.value= val;
            //create new node and insert between nth and n+1
            new_node= new Node(nth_val);
            new_node.next= nth.next;
            nth.next= new_node;
            //update the length
            this.length++;
        }
    }
    public void remove_node(int pos){
        if(pos==0) {
            this.head=this.head.next;
            this.length--;
        }
        if(pos<=0 || pos>=this.length) System.out.println("Invalid index.");
        Node removed_prev= this.find_nth_node(pos-1);
        removed_prev.next= removed_prev.next.next;
        //update the length
        this.length--;
    }
    public void printList(){
        Node to_print= this.head;
        for(int i=0; i<this.length; i++) {
            System.out.print("->");
            System.out.print(to_print.value);
            to_print= to_print.next;
        }
        System.out.println();
    }
    public void reverse_list(){
        // prev=5 current=4 next=3
        Node prev=this.head;
        Node current= this.head.next;
        Node next= this.head.next.next;

        //head will be tail
        prev.next=null;
        // <-5 4->3->2->1->0
        for(int i=0; i<this.length-1; i++){
            // <-5<-4->3->2->1->0
            current.next= prev;
            // prev=4 current=4 next=3
            prev= current;
            // prev=4 current=3 next=3
            current= next;
            // prev=4 current=3 next=2
            try{
                next= next.next;
            }catch (NullPointerException e){

            }
        }
        this.head=prev;
    }
    public void reverse_list_recursive(Node current){
        if(current.next==null) {
            this.head= current;
            return;
        }
        reverse_list_recursive(current.next);
        current.next.next= current;
    }
    public void recursive_reverse(){
        reverse_list_recursive(this.head);
    }

}

