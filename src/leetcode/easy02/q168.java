package leetcode.easy02;

/**
 * @ClassName: q168
 * @Author: 5753
 * @Date: 2022/9/24 17:50
 * @Description: TODO
 */
public class q168 {

    public static String convertToTitle(int columnNumber) {
        int cn = columnNumber;
        StringBuilder sb = new StringBuilder();
        while (cn > 0) {
            sb.append((char) (cn % 26 + 'A' - 1));
            cn = cn / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        //FXSHRXW
        System.out.println(convertToTitle(2147483647));
    }
}
