public class LinkedList<T> {

    private Node<T> head;

    private class Node<T>{

        T data;
        Node next;

        public Node(T data){
            this.data=data;
            this.next=null;
        }

    }

    public void insertAtBeginnig(T data){
        Node<T> newNode= new Node<>(data);

        if(head!=null){
            newNode.next=head;
        }
        head=newNode;
    }

    public void insertAtTheEnd(T data) {
        Node<T> newNode= new Node<>(data);

        if(head==null){
            head=newNode;
        }

        else{
            Node temp= head;
            while(temp!=null) {
                if(temp.next!=null){
                    temp=temp.next;
                }else{
                    break;
                }
            }
            temp.next=newNode;
        }

    }

    public T getAtBeginning(){
        T data=null;

        if(head!=null){
            data=head.data;
            head=head.next;
        }
        return data;
    }

    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList= new LinkedList<>();

        System.out.println(integerLinkedList.getAtBeginning());

        integerLinkedList.insertAtBeginnig(10);

        System.out.println(integerLinkedList.getAtBeginning());
        System.out.println(integerLinkedList.getAtBeginning());

        integerLinkedList.insertAtTheEnd(5);

        System.out.println(integerLinkedList.getAtBeginning());
        System.out.println(integerLinkedList.getAtBeginning());


    }

}
