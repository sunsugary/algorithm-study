package begin.Class08;

public class Code02_MergeSort {
    //归并排序
    //给一个数组，平均分成两份，左边部分先有序，右边有序
    //左边部分一个指针，右边部分一个指针
    //两个指针来到index=0位置，谁小拷贝谁,然后指针来到下一个index


    public static void main(String[] args) {
        int[] arr = {1,4,7,7,6,0,6,2,0,7};
        mergeSort1(arr);


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    //递归方法实现归并排序
    public static void mergeSort1(int[] arr) {

        if (arr == null || arr.length < 2) {
            //当只有一个数或者为空时直接返回 不排序
            return;
        }

        process(arr, 0, arr.length - 1);


    }

    private static void process(int[] arr, int L, int R) {
        //递归的终点
        if (L == R) {
            //此时表示数组只剩下一个数
            return;
        }

        //求出中点
        int mid = (L + R) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);

        //当将数组拆分到不能拆分的时候
        //开始进行归并排序

        System.out.println("L:" + L + " MID:" + mid + " R:" + R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {


        //定义两个指针分别指向数组的各半
        int p1 = L;
        int p2 = mid + 1;

        //需要准备一个数组作为排序后的数组
        int[] help = new int[R - L + 1];

        //help数组插入的指针
        int helpIndex = 0;

        while (p1 <= mid && p2 <= R) {
            //循环向help数组添加数，直到越界
            help[helpIndex++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //两个条件只有一个可能会越界

        while (p1 <= mid) {
            //当p2越界
            help[helpIndex++] = arr[p1++];
        }

        while (p2 <= R) {
            help[helpIndex++] = arr[p2++];
        }

        //最后将help数组中的数值拷贝到arr数组中

        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }


    }


}
