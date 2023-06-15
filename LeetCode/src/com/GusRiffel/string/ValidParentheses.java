package com.GusRiffel.string;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));

    }
    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    if (s.charAt(i + 1) != ')') {
                        return false;
                    }
                    break;

                case '{':
                    if (s.charAt(i + 1) != '}') {
                        return false;
                    }
                    break;

                case '[':
                    if (s.charAt(i + 1) != ']') {
                        return false;
                    }
                    break;

                default:
                    break;
            }
        }
        return true;
    }
}
