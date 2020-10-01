public class GeneralizedQueue<T>{
    private RedBlackBST<Integer, T> blackBST;
	private int index;

    public GeneralizedQueue(){
        blackBST = new RedBlackBST<>();
    }

    public void insert(T item){
        blackBST.put(index++, item);
    }

    public void remove(){
        blackBST.deleteMin(); 
    }

    public T get(int x){
        int r = blackBST.rank(x);
        return blackBST.get(r);
    }


    public void removeItem(int x){
        int r = blackBST.rank(x);
        blackBST.delete(r);
    }


}