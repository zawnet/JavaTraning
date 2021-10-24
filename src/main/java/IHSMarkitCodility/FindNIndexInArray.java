package IHSMarkitCodility;

public class FindNIndexInArray {

    public static void main(String[] args) {
        int[] A = {1,5,6,8,9,10};
        System.out.println(solution(A,6));
    }

    static int solution(int[] A, int X){
        int N = A.length;
        if(N == 0){
            return -1;
        }
        int l = 0;
        int r = N-1;

        while (l<r){
            int m = (l+r)/2;

            if(A[m] > X){
                r = m+1;

            }
            else {
                l = m;

            }
            if(A[l] == X){
                return l;
            }

        }

        return -1;
    }
}
