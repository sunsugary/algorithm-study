package leetcode.eays04;

public class q459 {
    public boolean repeatedSubstringPattern(String s) {
        //重复的字符串，如果一个字符串可以由它的字串的重复组成，那么这个字符串每个字符出现的次数是相同的
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int temp = arr[0];
        for (int num : arr) {
            if (num != temp && num) {
                return false;
            }
        }
        return true;
    }
}
