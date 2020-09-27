public class ArrayStack{
    private int N;
    private String[] stack;
    public ArrayStack(int cap){
        N = null;
        stack = new String[cap];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String s){
        stack[N++] = s;
    }

    public String pop(){
        return stack[--N];
    }

    public String peek(){
        return stack[N - 1];
    }


}