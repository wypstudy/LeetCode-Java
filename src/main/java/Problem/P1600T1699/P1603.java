package Problem.P1600T1699;

/**
 * Time  : 2021/3/19 10:24
 * Author: Banehallow
 */
public class P1603 {
    static class ParkingSystem {
        int[] typeToCount;

        public ParkingSystem(int big, int medium, int small) {
            typeToCount = new int[4];
            typeToCount[1] = big;
            typeToCount[2] = medium;
            typeToCount[3] = small;
        }

        public boolean addCar(int carType) {
            if (typeToCount[carType] > 0) {
                typeToCount[carType]--;
                return true;
            }
            return false;
        }
    }
}
