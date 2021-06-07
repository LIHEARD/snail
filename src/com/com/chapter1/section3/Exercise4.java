package com.com.chapter1.section3;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {
    public static void main(String[] args) {
        Exercise4 exercise4 = new Exercise4();
        System.out.println(exercise4.isBalanced("[]()"));
    }
    private  boolean isBalanced(String input){
        char[] parentheses = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char parenthese : parentheses){
            if(parenthese == '(' || parenthese == '{' || parenthese == '['){
                stack.push(parenthese);
            }else{
                if(stack.isEmpty()) return  false;
                Character character = stack.pop();
                if(parenthese == ')' && character != '('  || parenthese == ']' && character != '[' || parenthese == '}' && character != '{'){
                    return  false;
                }
            }

        }
        return  true;


    }
}
