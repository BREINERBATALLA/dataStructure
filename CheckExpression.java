import java.util.Stack;

public class CheckExpression {

    public static void main(String[] args) {

        System.out.println(getExp("[(})"));
        System.out.println(getExp("[(({}))]"));

    }

    static boolean getExp(String exp) {
        Stack<Character> stack= new Stack<>();
        boolean correct=true;

        for(int i=0; i< exp.length(); i++) {
            char temp = exp.charAt(i);

            if(temp=='{'){
                stack.push('}');
            }else if(temp=='['){
                stack.push(']');
            }
            else if(temp=='('){
                stack.push(')');
            }
            else if(temp!=stack.pop()){
                return !correct;
            }
        }

        return correct;
    }
}
