package com.unit5;

public class BalancedBrackets {

    public  boolean isBalanced(String s) {

        if (s.length() == 0) return true;

        Stack<Character> brackets = new Stack<Character>();

        brackets.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
    
            if (isOpenning(s.charAt(i)))
                brackets.push(s.charAt(i));
            else
            if (isClosing(s.charAt(i))) {
    
                if (brackets.size() > 0 && isMatching(brackets.peek(), s.charAt(i)))
                    brackets.pop();
                else
                    return false;
            } 
        }

        return brackets.size() == 0;
    }

    private  boolean isOpenning(Character str) {
        return str == '(' || str == '{' || str == '[' || str == '<';
    }

    private  boolean isClosing(Character str) {
        return str == ')' || str == '}' || str == ']' || str == '>';
    }

    private  boolean isMatching(Character left, Character right) {
        return (left == '(' && right == ')' ||
                left == '{' && right == '}' ||
                left == '<' && right == '>' ||
                left == '[' && right == ']');
    }
}
