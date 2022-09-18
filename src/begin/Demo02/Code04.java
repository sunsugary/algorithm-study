package begin.Demo02;

public class Code04 {
    /**
     * 有序的数组找出来一个num
     * 二分法
     */
    public static boolean find(int[] arr, int num) {
        //处理边界
        if (arr == null || arr.length == 0) {
            return false;
        }
        //左边界
        int L = 0;
        int R = arr.length - 1;
        // arr[0...N-1] 找 num
        while (L <= R) {
            //左边界大于右边界跳出循环
            //中点位置
            int mid = (L + R) / 2;
            //找到的情况
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                //中点大于num
                //更改左边界
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    /**
     * 暴力方法
     */
    public static boolean test(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 有序数组找到 >= num的最左位置
     */
    public static int mostLeftNoMoreNumIndex(int[] arr, int num) {
        //处理边界
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //左边界
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            //ans更新
            //中点位置
            int mid = (L + R) / 2;
            if (arr[mid] > num) {
                //记录mid
                ans = mid;
                //要看arr[mid]左边还有没有比num大的数
                R = mid - 1;
            } else {
                //进行二分
                L = mid + 1;

            }
        }
        return ans;
    }

    /**
     * 有序数组找到 <= num的最右位置
     */
    public static int mostRightNoMoreNumIndex(int[] arr, int num) {
        //处理边界
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        int mid = (L + R) / 2;
        if (arr[mid] >= num) {
            R = mid - 1;
        } else {
            ans = mid;
            L = mid + 1;
        }
        return ans;
    }

    /**
     * 暴力找方法
     *
     * @param arr,num
     */
    public static int test2(int[] arr, int num) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                if (i >= ans) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    /**
     * 生成随机数组，且相邻不相等
     */
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) Math.random() * maxLen;
        int[] arr = new int[len];
        if (len > 0) {
            //生成0位置数
            arr[0] = (int) Math.random() * maxValue;
            //生成其他数据
            for (int i = 1; i < arr.length; i++) {
                do {
                    arr[i] = (int) Math.random() * maxValue;
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * 验证传进来的数是不是局部最小
     */
    public static boolean check(int[] arr, int minIndex) {
        //验证边界情况
        if (arr.length == 0) {
            return minIndex == -1;
        }

        //左边下边
        int left = minIndex - 1;
        //右边下边
        int right = minIndex + 1;

        boolean leftBig = left >= 0 ? arr[left] > arr[minIndex] : true;

        boolean rightBig = right < arr.length ? arr[right] > arr[minIndex] : true;

        return leftBig && rightBig;


    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 局部最小
     * 1. 0位置比1位置小则 0位置最小
     * 2. n-1位置比n-2位置小 则n-1位置最小
     * 3. i< i+1 && i<i-1
     *
     * @param arr
     */
    public static int oneMinIndex(int[] arr) {
        //考虑边界
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        int L = 0;
        int R = N - 1;
        int ans = -1;
        if (N == 2) {
            if (arr[0] < arr[1]) {
                return 0;
            }
        }
        if (N == 1) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return arr[L] < arr[R] ? L : R;

    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(test2(arr, 6));
//        System.out.println(mostRightNoMoreNumIndex(arr, 6));
//        System.out.println(mostLeftNoMoreNumIndex(arr, 6));
        int maxLen = 1000;
        int maxValue = 10000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
