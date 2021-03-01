package Problem.P0800T0899;

public class P0896 {
    public boolean isMonotonic(int[] A) {
        boolean asc = true, dsc = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) asc = false;
            if (A[i] > A[i - 1]) dsc = false;
        }
        return asc || dsc;
    }
}
