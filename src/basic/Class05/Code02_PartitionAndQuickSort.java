package basic.Class05;

import java.util.Stack;

public class Code02_PartitionAndQuickSort {

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);


    }

    private static void process1(int[] arr, int L, int R) {
        //base case
        if (L >= R) {
            return;
        }

        int M = partition1(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);


    }

    private static int partition1(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }

        if (L == R) {
            return L;
        }
        //小于区的起始位置
        int lessEqual = L - 1;

        //遍历的开始的位置
        int index = L;

        while (index < R) {
            if (arr[index] <= arr[R]) {
                //当前数比目标数arr[R]小的时候 当前数与小于区后一个数进行交换
                swap(arr, index, lessEqual + 1);
                lessEqual++;
                index++;
            } else {
                //大于的时候直接跳过
                index++;
            }
        }
        swap(arr, R, ++lessEqual);
        return lessEqual;

    }

    public static void swap(int[] arr, int K, int M) {
        int temp = arr[K];
        arr[K] = arr[M];
        arr[M] = temp;
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);

    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int[] equalRange = partition2(arr, L, R);
        process2(arr, L, equalRange[0] - 1);
        process2(arr, equalRange[1] + 1, R);
    }

    private static int[] partition2(int[] arr, int L, int R) {
        //快排2.0是将数组分成三部分，选定arr[R]为目标值，小于目标值放在左边 等于放在中间 大于放在右边 并且最终返回等于区的左右边界

        //如果范围有问题
        if (L > R) {
            return new int[]{-1, -1};
        }
        //递归调用会将数组最终分成一个值
        if (L == R) {
            return new int[]{L, L};
        }
        //定义小于区边界 默认小于区一开始一个数没有
        int lessL = L - 1;
        //定义大于区的边界 默认最后一个数在大于区
        int moreR = R;
        //定义遍历数组的指针
        int index = L;

        //只要index不与大于区的边界重合则循环
        while (index < moreR) {
            //目标数为arr[R]
            if (arr[index] == arr[R]) {
                //当前数等于目标数的时候直接跳到下一个
                index++;
            } else if (arr[index] > arr[R]) {
                //当签数大于目标数 与大于区的左数第一个数交换大于区向左扩一位
                swap(arr, index, --moreR);
            } else {
                //当钱数小于目标数 与小于区的右数第一个数进行交换 小于区向右扩一位
                swap(arr, index++, ++lessL);
            }
        }
        //最终循环走完 目标数与大于区的第一个数进行交换
        swap(arr, R, moreR);
        return new int[]{lessL + 1, moreR};
    }

    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    /**
     * @return void
     * @Author 5753
     * @Description 快排3.0 由于快排1.0和2.0都是使用arr[R]作为目标，会存在最差情况{1，2，3，4，5，6}，改用随机值作为目标数使时间复杂度来到N * logN
     * @Date 11:28 2022/9/5
     * @Param [arr]
     **/
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }

        swap(arr, R, L + (int) (Math.random() * (R - L + 1)));
        int[] equalRange = partition2(arr, L, R);
        process3(arr, L, equalRange[0] - 1);
        process3(arr, equalRange[1] + 1, R);
    }


    /**
     * @return void
     * @Author 5753
     * @Description 快排非递归版本 用栈来执行
     * @Date 14:14 2022/9/5
     * @Param [arr]
     **/
    public static void quickSort4(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //第一次进行分层 随机一个目标数出来
        swap(arr, N - 1, (int) (Math.random() * N));
        int[] equalRange = partition2(arr, 0, N - 1);
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, equalRange[0] - 1));
        stack.push(new Op(equalRange[1] + 1, N - 1));
        while (!stack.isEmpty()) {
            Op op = stack.pop();
            if (op.l < op.r) {
                swap(arr, op.r, op.l + (int) (Math.random() * (op.r - op.l + 1)));
                equalRange = partition2(arr, op.l, op.r);
                stack.push(new Op(op.l, equalRange[0] - 1));
                stack.push(new Op(equalRange[1] + 1, op.r));
            }
        }
    }

    // 快排非递归版本需要的辅助类
    // 要处理的是什么范围上的排序，如果使用递归进行快排 第一次是将数组分成两份，每一份再去调用这个递归，重复这个过程直至遇到baseCase分到不能再分。
    // 如果使用非递归就要记住每一次分完之后的数组左右边界
    public static class Op {
        public int l;
        public int r;

        public Op(int left, int right) {
            l = left;
            r = right;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 7, 6, 0, 6, 2, 0, 7};
//        quickSort4(arr);
        quickSort4(arr);
        printArr(arr);
    }


}
