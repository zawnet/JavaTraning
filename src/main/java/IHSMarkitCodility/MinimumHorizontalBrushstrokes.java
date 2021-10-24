package IHSMarkitCodility;

public class MinimumHorizontalBrushstrokes {



    public static void main(String[] args) {
        int[] A = {1,1,1,1,1};
        System.out.println(solution(A));
        System.out.println(BrushCount(A));
        System.out.println(brushCount(A));
    }

    static int BrushCount(int[] buildings)
    {
        int brushCount = 0;
        int prevHeight = 0;
        for(int i = 0; i < buildings.length; i++)
        {
            if(buildings[i] > prevHeight)
                brushCount = brushCount + (buildings[i] - prevHeight);
            prevHeight = buildings[i];
        }
        return brushCount;
    }

    public static int solution(int[] A) {
        int numberOfBrushstrokes = 0;
        int n = A.length;
        for (int i = 0; i<n; i++) {
                if((i + 1) < n ) {
                    if (A[i] > A[i + 1]) {
                        numberOfBrushstrokes += A[i] - A[i + 1];
                    }
                }
                else {
                    numberOfBrushstrokes +=A[i];
                }
            }
        return numberOfBrushstrokes;
    }

    public static int brushCount(int[] buildings)
    {
        int count=0;
        for(int i=0; i<=buildings.length-1; i++){
            if((i+1)<(buildings.length)){
                if(buildings[i]>buildings[i+1]){
                    count += buildings[i]-buildings[i+1];
                }
            }else{
                count += buildings[i];
            }
        }
        return count;
    }
}
