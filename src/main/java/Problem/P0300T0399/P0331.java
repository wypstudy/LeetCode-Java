package Problem.P0300T0399;

/**
 * Time  : 2021/3/12 08:44
 * Author: Banehallow
 */
public class P0331 {
    public boolean isValidSerialization(String preorder) {
        int slots = 1, i = 0, n = preorder.length();
        while (i < n) {
            if (slots == 0) return false;
            if (preorder.charAt(i)== ',') i++;
            else if (preorder.charAt(i)=='#') {
                slots--;
                i++;
            } else {
                while (i < n && preorder.charAt(i)!=',') i++;
                slots++;
            }
        }
        return slots == 0;
    }
}
