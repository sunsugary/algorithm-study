package basic.Class01;

public class Code01_SelectionSort {

    /**
     * 知识：异或^ 运算可以看成是无进位相加，并且满足加法交换律与结合律
     * 无进位相加：0110101
     * 1011010
     * 1101111
     * 并且两个相同的数异或运算为0，任何一个数异或0得到自己本身
     * 问：把两个数交换，且不使用第三个变量？
     * 解：a = a^b;b=a^b;a=a^b;
     * 第一步a = a ^ b;
     * 第二步b = (a ^ b) ^ b;因为满足结合律，所以等于 a ^ (b ^ b) = a;
     * 第三步a = (a ^ b) ^ a;最后得出 a = b;
     * 最终a和b可以完成交换
     */
    public static void main(String[] args) {
        int a = 100;
        int b = 99;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " , " + b);


    }


    /**
     * 选择排序：
     * 1.首先假设最小值minIndex为0
     * 2.遍历最小值后边的数字，如果有更小的，则将minIndex改为该值
     * 3.将0位置与最小值位置交换
     *
     * @param arr
     */


    public static void selectionSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            //假设最小值
            int minIndex = i;
            for (int j = 0; j < arr.length - 1; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            swap(arr, i, minIndex);
        }


    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
