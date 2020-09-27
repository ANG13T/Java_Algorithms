public class BinaryHeap<Key extends Comparable<Key>>{
    private Key[] bh;
    private int N;

    public BinaryHeap(int capacity){
        bh = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key k){
        bh[N++] = k;
    }

    private static boolean less(int v, int w){
        return bh[v].compareTo(bh[w]) < 0; //index at v less than nidex at w
    }

    private void sink(int k){
        while(2 * k <= N){ //while child is inside the heap
            int j = 2 * k; //left child
            if(j < N && less(j, j + 1)){ //if child inside heap and left child less than right child
                j++; //go to right child
            }

            if(!less(k, j)){ //if child is less than original
                break; //stop because children must be less
            }

            exch(k, j); //if child is greater than original than exchange because children must have a lower value
            k = j; //go into the child to continue the process until the node is in the right spot
        }   
    }

    private void swim(int k){
        while(k > 1 && less(k / 2, k)){ //if k is not above the heap and parent node is less than node
            exch(k / 2, k); //exchange with parent bc parent must have greater value
            k = k / 2; //move up to parent until node is in right place (children have smaller values)
        }
    }

    public Key delMax(){
        Key max = bh[1];
        exch(i, N--); //exchange with last element
        sink(i); //sink last element (new top) until it is in proper place
        bh[N + 1] = null; //mullify last element (max)
        return max; //return old max
    }

    public static void exch(int i, int j){
        Key t = bh[i];
        bh[i] = bh[j];
        bh[j] = t;
    }
}