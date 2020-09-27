
import java.util.Arrays; 

public class MergeSortInversions{
    // Function to count the number of inversions 
    // during the merge process 
    private int mergeCount(int[] arr, int l, int m, int r){
        //left subarray copy
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        //right subarray copy
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        //init pointers and swaps
        int i = 0;
        int j = 0;
        int k = l;
        int swaps = 0; 

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){ //if number in left subarray is less than on right sub array
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while(i < left.length){
             arr[k++] = left[i++];
        }

        while(j < right.length){
            arr[k++] = right[j++];
        }

        return swaps;
    }

    private int mergeSortAndCount(int[] arr, int l, int r){
        int count = 0; //num of inversions
        if(l < r){
            int m = (l + r) / 2; //mid way of array
            //amount of inversions = left subarray count + rightsubarray count + merge array count
            count += mergeCount(arr, l, m); //left sub array
            count += mergeCount(arr, m + 1, r); //right sub array
            count += mergeCount(arr, l, m, r); //merge count
        }

        return count;
    }

    public static void main(String[] args) 
    { 
        int[] arr = { 1, 20, 6, 4, 5 }; 
  
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1)); 
    } 
}