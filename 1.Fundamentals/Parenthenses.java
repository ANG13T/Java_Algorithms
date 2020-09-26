public class Parenthenses{
   
    private final static char LEFT_PAREN = '(';
    private final static char RIGHT_PAREN = ')';
    private final static char RIGHT_BRACKET = ']';
    private final static char LEFT_BRACKET = '[';
    private final static char LEFT_BRACE = '{';
    private final static char RIGHT_BRACE = '}';

    public boolean isBalanced(String s){
         private Stack<String> stack;
        for(int i = 0; i < s.length; i++){
            char c = s[i]; 
            if(c == LEFT_PAREN) stack.push(LEFT_PAREN);
            if(c == LEFT_BRACKET) stack.push(LEFT_BRACKET);
            if(c == LEFT_BRACE) stack.push(LEFT_BRACE);
            if(c == RIGHT_PAREN){
                if(stack.empty()) return false;
                if(stack.pop() != LEFT_PAREN) return false;
            }else if(c == RIGHT_BRACKET){
                if(stack.empty()) return false;
                if(stack.pop() != LEFT_BRACKET) return false;
            }else if(c == RIGHT_BRACE){
                if(stack.empty()) return false;
                if(stack.pop() != LEFT_BRACE) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
    }

}