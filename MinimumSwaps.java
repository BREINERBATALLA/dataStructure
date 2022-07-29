import java.time.LocalDate;
import java.time.Period;

public class MinimumSwaps {
    public static void main(String[] args) {

       int[] arr= new int[]{5,3,4,2,1};
       int numSwaps=0;

       for(int i=0;i<arr.length;i++) {

           int elm=arr[i];
           while(elm!=i+1){
               int temp= arr[elm-1];
               arr[elm-1]=elm;
               arr[i]=temp;
               elm=arr[i];
               numSwaps++;
           }
       }

        System.out.println("Minimum swaps:" +numSwaps);


    }



}

