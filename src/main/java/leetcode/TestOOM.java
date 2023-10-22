package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: Created in 20:47 2021/11/24
 * @Author: caopeng
 */
public class TestOOM {

    public static void main(String[] args) {
        int i = 2;
        int i1 = 1 << i;
        System.out.println(i1);

//        int count = 0;
//        List<TestOOM> list = new ArrayList<>();
//        try {
//            while (true) {
//                list.add(new TestOOM());
//                System.out.println(count);
//                count++;
//            }
//        } catch (Error e) {
//            System.out.println(count);
//            e.printStackTrace();
//        }
//        for(;;) {
//            retry:
//            for (;;) {
//                for (;;) {
//                    continue retry;
//                }
//            }
//        }
    }
}
