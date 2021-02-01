package Problem.P0000T0099;

public class P0012 {
    public String intToRoman(int num) {
        Character[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder romanStr = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int d = num % 10;
            StringBuilder subRomanStr = new StringBuilder();
            if (d == 4 || d == 9) {
                subRomanStr.append(roman[i]);
                subRomanStr.append(roman[i + (d + 1) / 5]);
            } else {
                if (d >= 5) {
                    subRomanStr.append(roman[i + 1]);
                }
                for (int j = 0; j < d % 5; j++) {
                    subRomanStr.append(roman[i]);
                }
            }
            romanStr.insert(0, subRomanStr.toString());
            num /= 10;
            i += 2;
        }
        return romanStr.toString();
    }

    public static void main(String[] args) {
        P0012 solution = new P0012();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}
