import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack implements Iterable<String>{
    private Node<String> first;     // top of stack
    private int n; 

    private static class Node{
        private Node<String> next;
        private String data;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public String pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        String oldItem = first.data;
        first = first.next;
        n--;
        return oldItem;
    }


    public void push(String String){
       Node<String> oldNode = first;
       first = new Node();
       first.data = String;
       first.next = oldNode;
       n++;
    }

    public String peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.data;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String data : this) {
            s.append(data);
            s.append(' ');
        }
        return s.toString();
    }
       

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<String> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<String> {
        private Node<String> current;

        public LinkedIterator(Node<String> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String data = current.data;
            current = current.next; 
            return String;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!System.in.isEmpty()) {
            String data = System.in.readString();
            if (!data.equals("-"))
                stack.push(data);
            else if (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }
        System.out.println("(" + stack.size() + " left on stack)");
    }

}