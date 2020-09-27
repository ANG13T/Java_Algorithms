public class UnorderedMaxPQ<Key extends Comparable<Key>>{ // generic class that takes on comparable vals
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key k){
        pq[N++] = k;
    }

    public Key delMax(){
        int max = 0;
        for(int i = 1; i < N; i++){
            if(less(max, i)){
                max = i;
            }
        }
        exch(max, N - 1);
        return pq[--N];
    }

     private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0; //v less than w
    }

    public static void exch(Key[] a, int i, int j){
        Key swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}