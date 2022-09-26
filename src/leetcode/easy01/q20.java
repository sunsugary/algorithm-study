package leetcode.easy01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: q20
 * @Author: 5753
 * @Date: 2022/9/21 14:39
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */
public class q20 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && compare(stack.peek(),chars[i] )){
                stack.pop();
            }else{
                stack.push(chars[i]);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean compare(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')') {
            return true;
        }
        if (ch1 == '{' && ch2 == '}') {
            return true;
        }
        if (ch1 == '[' && ch2 == ']') {
            return true;
        }
        return false;
    }
}
