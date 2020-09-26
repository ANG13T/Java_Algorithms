public class WeightedQuickUnion{

    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int N){
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public int root(int n){
        while(n != id[n]){
            id[n] = id[id[n]];
            n = id[n];
        }
        return n;
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q); 

        if(i == j) return;

        if(sz[j] > sz[i]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
        
    }

    public static void main(String args[]){
        WeightedQuickUnion wqu = new WeightedQuickUnion(5);
        wqu.union(0,1);
        wqu.union(2,3);
        System.out.println(wqu.connected(0,1));
        wqu.union(0,3);
        wqu.union(2,4);
        System.out.println(wqu.connected(0,3));
        System.out.println(wqu.connected(0,4));
        System.out.println(wqu.connected(0,2));
    }
}