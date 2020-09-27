public class DutchFlag{
    int[] array;

    public DutchFlag(int[] a){
        this.array = a;
    }

    public void swap(int i, int j){
        int temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    public String getColor(int num){
        if(num == 0){
            return "red";
        }else if(num == 1){
            return "white";
        }else{
            return "blue";
        }
    }

    public int[] sort(){
        int low = 0;
        int reader = 0;
        int high = this.array.length - 1;

        while(reader <= high){
            String result = getColor(this.array[reader]);
            if(result == "red"){
                swap(reader,low);
                reader++;
                low++;
            }else if(result == "white"){
                reader++;
            }else if(result == "blue"){
                swap(reader,high);
                high--;
            }else{
                System.out.println("Bad input");
               break;
            }
        }
        return this.array;
    }

    public static void main(String args[]){
        int[] array1 = {1,2,0,0,2,1,1,0,2,0};
        DutchFlag flag = new DutchFlag(array1);
        int[] result = flag.sort();
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}