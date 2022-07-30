import java.util.HashMap;
import java.util.Map;

public class TargetPairSum {

    public static void main(String[] args) {
        int[] arr= new int[]{4,3,6,2,1,4,5,2};
        int target=3;
        Map<Integer,Integer> set = new HashMap<>();

        for(int i=0; i <arr.length; i++) {
            set.put(arr[i],i);

            if(set.containsKey(target-arr[i])) {
                System.out.println("{"+ set.get(target-arr[i])+ "," + i + "}");
                break;
            }
        }



    }
}
