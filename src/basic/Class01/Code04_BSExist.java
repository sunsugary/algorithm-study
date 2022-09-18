//package basic.Class01;
//
//import org.springframework.util.StopWatch;
//
//public class Code04_BSExist {
//    /**
//     * 使用二分法判断一个数是不是存在一个有序数组中
//     * <p>
//     * 注意：当求中点的时候会存在一个溢出问题，因为(L+R)/2假如数组的长度非常大超过了Integer的最大值则会溢出
//     * L+(R-L)/2可以避免这个问题
//     * 又因为一个数num/2 = num>>1
//     * 所以最终求中点可以写成 L+(R-L)>>1 优化算法中的常数时间
//     */
//
//    public static boolean exist(int[] arr, int num) {
//        int L = 0;
//        int R = arr.length - 1;
//        int mid = 0;
//
//        while (L < R) {
//            //只要还有两个数就可以继续进行二分
//            mid = L + (R - L) >> 1;
//            if (arr[mid] == num) {
//                return true;
//            } else if (arr[mid] > num) {
//                //说明num可能在数组的左边
//                R = mid - 1;
//            } else {
//                //说明num可能在数组的右边
//                L = mid + 1;
//            }
//        }
//
//        //最终只有一个数
//        return arr[L] == num;
//
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        StopWatch sw = new StopWatch("test");
//        sw.start();
//        Thread.sleep(3000);
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int num = 1;
//        System.out.println(exist(arr, num));
//        sw.stop();
//        System.out.println(sw.prettyPrint());
//    }
//
//
//}
