public class Queu <T>{

    private Node head;
    private Node tail;

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void Enqueu(T data) {
        Node<T> newNode = new Node<>(data);

        if(head==null) {
            head=newNode;
        }else{
            tail.next=newNode;
        }
        tail=newNode;

    }

    public T Dequeu(){
        Node<T> temp = new Node<>();
        if(head!=null){
            temp=head;
            head=head.next;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        Queu<String> stringQueu= new Queu<>();

        System.out.println(stringQueu.Dequeu());

        stringQueu.Enqueu("Breiner");
        stringQueu.Enqueu("Batalla");
        System.out.println(stringQueu.Dequeu());
        System.out.println(stringQueu.Dequeu());


    }
}
