public class LinkedListStack{
    private Node top;
    private int N;
    public LinkedListStack(){
        N = 0;
        top = null;
    }

    public class Node{
        private Node next;
        private String data;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return top == null;
    }


    public void push(String s){
        Node oldTop = top;
        top = new Node();
        top.data = s;
        top.next = oldTop;
        N++;
    }

    public String pop(){
        String nodeData = top.data;
        if(top.next != null){
            top = top.next;
        }else{
            top = null;
        }
        N--;
        return nodeData;
    }

    public String peek(){
        return top.data;
    }

    public static void main(String args[]){
        LinkedListStack stack = new LinkedListStack();
        stack.push("cat");
        stack.push("dog");
        stack.push("frog");
        System.out.println(stack.size()); //3
        System.out.println(stack.pop()); //frog
        System.out.println(stack.pop()); //dog
        System.out.println(stack.peek()); //cat
        System.out.println(stack.size()); //1
    }
}