package com.example.practicejava;

public class Calculator {
    int num1;
    int num2;
    String operator;
    int result;

    public Calculator() {} //매개변수가 없는 기본생성자
    public int calculate(int num1, int num2, String operator) {
        if (operator.equals("+")) {
            result = num1 + num2;
            return result;
        }
        else if (operator.equals("-")) {
            result = num1 - num2;
            return result;
        }
        else {
            return -1;
        }
    }
}
/*
1.사칙연산
2.숫자
3.결과값

 */