package leetcode.conversionOfNumberSystems;

/**
 * @ClassName: q405
 * @Author: 5753
 * @Date: 2022/10/10 15:43
 * @Description: TODO
 */
public class q405 {
    public static String toHex(int num) {
        long num_ = num;
        if (num_ == 0) return "0";
        if (num_ < 0) num_ = (long) (Math.pow(2, 32) + num_);
        StringBuilder sb = new StringBuilder();
        while (num_ != 0) {
            long a = num_ % 16;
            sb.append(a > 9 ? convert(Integer.parseInt(String.valueOf(a))) : a);
            num_ /= 16;
        }
        return sb.reverse().toString();

    }

    public static String toHex2(int num) {
        //https://www.cnblogs.com/gaizai/p/4233780.html#_labelConvert23
        //每四个二进制位代表一个十六进制位数
        //32位的二进制位数可以分成0~7组
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                sb.append(val >= 10 ? (char)(val - 10 + 'a') : (char) (val + '0'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex2(-1));
    }


    public static String convert(int x) {
        String ans = "";
        switch (x) {
            case 10:
                ans = "a";
                break;
            case 11:
                ans = "b";
                break;
            case 12:
                ans = "c";
                break;
            case 13:
                ans = "d";
                break;
            case 14:
                ans = "e";
                break;
            case 15:
                ans = "f";
                break;
        }
        return ans;
    }
}
