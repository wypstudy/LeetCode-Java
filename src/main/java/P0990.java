/**
 * Date  :  2020/6/8
 * Author:  YiPing, Wei
 **/
public class P0990 {
    int size = 26;
    int[] UFSet = new int[size];

    private int find(int x) {
        if (UFSet[x] == x)
            return x;
        else
            UFSet[x] = find(UFSet[x]);
            return UFSet[x];
    }

    private void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot < yRoot)
            UFSet[yRoot] = xRoot;
        else if (xRoot > yRoot)
            UFSet[xRoot] = yRoot;
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < size; i++)
            UFSet[i] = i;
        for (String equation:equations) {
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                union(left, right);
            }
        }
        for (String equation:equations) {
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!' && find(left) == find(right)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P0990 solution = new P0990();
        String[] equations1 = {"a==b", "b!=a"};
        String[] equations2 = {"b==a", "a==b"};
        String[] equations3 = {"a==b", "b==c", "a==c"};
        String[] equations4 = {"a==b", "b!=c", "c==a"};
        String[] equations5 = {"c==c", "b==d", "x!=z"};
        System.out.println(solution.equationsPossible(equations1));
        System.out.println(solution.equationsPossible(equations2));
        System.out.println(solution.equationsPossible(equations3));
        System.out.println(solution.equationsPossible(equations4));
        System.out.println(solution.equationsPossible(equations5));
    }
}
