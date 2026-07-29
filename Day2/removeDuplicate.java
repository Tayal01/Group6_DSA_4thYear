package Day2;

import java.util.*;

public class removeDuplicate {

    public String removeDuplicateLetters(String s) {

        int[] last = new int[26];

        // Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Skip if already in stack
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove bigger characters if they appear later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        removeDuplicate obj = new removeDuplicate();

        String s = "cbacdcbc";

        System.out.println("Input  : " + s);
        System.out.println("Output : " + obj.removeDuplicateLetters(s));
    }
}