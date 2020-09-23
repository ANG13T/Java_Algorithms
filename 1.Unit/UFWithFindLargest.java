public class UFWithFindLargest{
    private int id[]; // id[i] = parent of node i
    private int sz[]; // sz[i] = size of node i
    private int large[]; // large[i] = largest element in component

    public UFWithFindLargest(int n){
        id = new int[n];
        sz = new int[n];
        large = new int[n];

        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }

    private root(int i){ //finds root of given node
        while(id[i] != i){
            id[i] = id[id[i]]; // path compression
            i = id[i];
        }

        return i;
    }

     // return the largest element in the connected component containing p
    public int find(int p) { 
        return large[root(p)];
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return;
        int largestP = large[rootp];
        int largestQ = large[rootq];
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
            
            if (largestP > largestQ)
                large[rootq] = largestP;
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
            
            if (largestQ > largestP)
                large[rootp] = largestQ;
        }
    }



}