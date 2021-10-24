package IHSMarkitCodility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Siblings {

    public static void main(String[] args) {
        System.out.println(solution(355));
    }

    public static int solution(int N){
        int result = 0;
        List<Integer> digits = new ArrayList<>();

        if(N< 0){
            throw new IllegalArgumentException("N parameter isn't negative value.");
        }
        if (N==0){
            return 0;
        }
        while (N > 0){
            digits.add(N%10);
            N = N/10;
        }

        int sum = digits.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .reduce(0,(a, b) -> a*10 + b);

        result = sum;

        if(result > 100000000){
            return -1;
        }
        else {
            return result;
        }

    }
}
