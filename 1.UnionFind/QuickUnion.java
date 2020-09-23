public class QuickUnion{

    private int[] id;

    public QuickUnion(int N){
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public int root(int n){
        while(n != id[n]){
            n = id[n];
        }
        return n;
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q); 

        id[i] = j;
    }

    public static void main(String args[]){
        QuickUnion qu = new QuickUnion(5);
        qu.union(0,1);
        qu.union(2,3);
        System.out.println(qu.connected(0,1));
        qu.union(0,3);
        qu.union(2,4);
        System.out.println(qu.connected(0,3));
        System.out.println(qu.connected(0,4));
        System.out.println(qu.connected(0,2));
    }
}