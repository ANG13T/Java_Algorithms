
public class MergeWithAuxiliary{

    public MergeWithAuxiliary(int[] array, int[] aux){
       
       int N = array.length / 2;
        for(int i = 0; i < N; i++){
            aux[i] = array[i];
        }


        int i = 0; int k = 0; int j = N;
        while (k < array.length) {
            if (i >= N)
                array[k++] = array[j++];
            else if (j >= array.length) 
                array[k++] = aux[i++];
            else if (aux[i] < array[j])
                array[k++] = aux[i++];
            else {
                array[k++] = array[j++];
            }
        }
        System.out.println("Computed: /n");
        for(int p = 0; p < array.length; p++){
            System.out.println(array[p]);
        }
    }



 public static void main(String args[]){
        int[] arr = {10, 32, 55, 9, 17, 28};
        int[] aux = new int[arr.length / 2];
        MergeWithAuxiliary mwa = new MergeWithAuxiliary(arr, aux);
    }

}