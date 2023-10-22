//package test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Description:
// * @Date: Created in 16:43 2022/5/20/020
// * @Author: caopeng
// */
//public class ABTest {
//
//    public static void main(String[] args) throws InterruptedException {
////        List<Long> list = new ArrayList<>(100);
//        Map<Long, List<Long>> map = new HashMap<>(100);
//        int testA = 0;
//        int testB = 0;
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
////            TimeUnit.MILLISECONDS.sleep(2);
//            Long l = SequenceUtil.nextId();
////            System.out.println("traceId值 " + l);
////            long hash = getHash(l);
//////            System.out.println("Hash值 " + hash);
////            long index = hash % 100;
//            long index1 = l % 102;
//            if (index1 > 70) {
//                testA++;
//            } else {
//                testB++;
//            }
////            System.out.println("桶位为 " + index);
////            if (!map.containsKey(index)) {
////                List<Long> list = new ArrayList<>();
////                list.add(l);
////                map.put(index, list);
////            } else {
////                List<Long> longs = map.get(index);
////                longs.add(l);
////            }
////            System.out.println(l);
////            TimeUnit.MILLISECONDS.sleep(2);
////            System.out.println("------------");
//
////            long l1 = SequenceUtil.nextId();
////            System.out.println(l1);
//        }
//        long costTime = System.currentTimeMillis() - start;
//        System.out.println(costTime);
//        System.out.println(map);
//    }
//
//    /**
//     * MurmurHash
//     */
//    private static long getHash(long traceId) {
//        HashFunction hashFunction = Hashing.murmur3_32();
//        HashCode hashCode = hashFunction.hashLong(traceId);
//        return hashCode.padToLong();
//    }
//}
