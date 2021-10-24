package programingtasks;

import java.util.Arrays;

public class FindPositiveValueInArray {

    public static void main(String[] args) {
        int A[] = {0,1, 3, 6, 4, 1, 2};
        A = Arrays.stream(A).filter(value -> value > 0).sorted().toArray();
        int min =1;
        for(int i = 0; i<A.length; i++){
            if(min<A[i]){
                break;
            }
            else {
                min = A[i]+1;
            }
        }
        System.out.println(min);
        //System.out.println(max);
    }
}
