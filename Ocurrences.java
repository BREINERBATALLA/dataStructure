import java.util.*;

public class Ocurrences {
    public static void main(String[] args) {
        Map<Integer, Integer> set = new HashMap<>();

        List<Integer> integerList= List.of(4,5,3,4,5,6,2,1,2,1,5,3,3,5,4,6);

        for (Integer i : integerList) {

            if(set.containsKey(i)){
                set.put(i,set.get(i)+1);
            }else{
                set.put(i,1);
            }
        }
        set.entrySet().stream().forEach(System.out::println);

    }
}
