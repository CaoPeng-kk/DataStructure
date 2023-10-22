package test;

import java.util.Random;

/**
 * @Description:
 * @Date: Created in 20:29 2022/5/20/020
 * @Author: caopeng
 */
public class ABTestJD {

    public static void main(String[] args) {
        int testA = 0;
        int testB = 0;
        for (int i = 0; i < 10000; i++) {
            int random = getRandom();
            int index = random % 100;
//            System.out.println(random);
            if (index > 70) {
                testA++;
            } else {
                testB++;
            }
        }
        System.out.println(testA);
    }

    private static int getRandom() {
        return new Random().nextInt(100);
    }
}
