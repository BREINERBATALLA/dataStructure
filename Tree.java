public class Tree<T> {

    private T data;
    private Tree<T> left;
    private Tree<T> right;

    public Tree(T data, Tree<T> left, Tree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }

    static void preOrden(Tree tree) {

        if(tree!=null) {
            System.out.println(tree.data);
            preOrden(tree.left);
            preOrden(tree.right);
        }

    }

    static void inOrden(Tree tree) {

        if(tree!=null) {
            preOrden(tree.left);
            System.out.println(tree.data);
            preOrden(tree.right);
        }

    }

    static void postOrden(Tree tree) {

        if(tree!=null) {
            preOrden(tree.left);
            preOrden(tree.right);
            System.out.println(tree.data);
        }

    }

    static boolean isBST(Tree<Integer> tree) {

        if(tree==null){
            return true;
        }
        else if(tree.getLeft() !=null && tree.data<tree.getLeft().data){
            return false;
        }
        else if(tree.getRight() !=null && tree.data>tree.getRight().data){
            return false;
        }

        return (isBST(tree.getRight()) && isBST(tree.getLeft()));
    }

    public static void main(String[] args) {
        Tree<Integer> integerTree = new Tree<>(3, new Tree<>(2, null,null),
                                                new Tree<>(5, null,null));


        Tree.preOrden(integerTree);
        Tree.inOrden(integerTree);
        Tree.postOrden(integerTree);
        System.out.println(Tree.isBST(integerTree));
    }
}




