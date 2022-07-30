import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr= new int[]{9,4,3,1,5,2,6};
        int start=0;
        int end=arr.length-1;
        int middle=0;
        int target=6;
        boolean flag=false;

        Arrays.sort(arr);


        while(start<=end) {
            middle=(int)(start+end)/2;

            if(target==arr[middle]){
                flag=true;
                break;
            }else if(target>=arr[middle]) {
                start=middle+1;
            }
            else{
                end=middle-1;
            }
        }

        if(flag){
            System.out.println(target+" was found at index "+ middle);
        }else{
            System.out.println(target+ "not found");
        }
    }
}
