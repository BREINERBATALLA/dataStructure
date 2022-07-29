public class Stack<T> {

    private Node<T> top;

    private class Node<T>{

        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data){
            this.data=data;
            this.next=null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);

        newNode.next=top;
        top=newNode;
    }

    boolean isEmpty(){
        return this.top==null;
    }

    public T pop() {
        Node<T> temp = new Node<T>();
        if(!isEmpty()){
            temp=top;
            top=top.next;
        }
        return  temp.data;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();

        System.out.println(stringStack.pop());
        stringStack.push("Breiner");
        stringStack.push("Batalla");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());

    }
}


