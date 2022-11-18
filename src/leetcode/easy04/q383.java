package leetcode.easy04;

/**
 * @ClassName: q383
 * @Author: 5753
 * @Date: 2022/10/8 15:38
 * @Description: TODO
 */
public class q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[128];

        for(int i = 0 ; i<magazine.length();i++){
            int index = magazine.charAt(i) - 'a';
            arr[index]++;
        }

        for(int i = 0 ; i < ransomNote.length();i++){
            int index = ransomNote.charAt(i) - 'a';
            if(--arr[index] < 0){
                return false;
            }
        }
        return true;

    }
}
