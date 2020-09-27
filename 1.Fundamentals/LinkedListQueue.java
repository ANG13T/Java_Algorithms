public class LinkedListQueue{
    private Node first;
    private Node last;
    private int N;

    public LinkedListQueue{
        N = 0;
    }

    private class Node{
        Node next;
        String data;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void enqueue(String item){
        Node oldLast = first;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last : oldLast.next = last;
        N++;
    }

    public String dequeue(){
        String oldItem = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return oldItem;
    }

    
}