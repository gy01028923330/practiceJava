package com.example.practicejava;

public class Test1 {

    public static String test22(String msg) {
        int num1 = 1;
        byte num2 = 1;
        byte num3 = 127;
        byte num4 = (byte) 128;
        int num7 = Integer.parseInt("1234");
        short num5 = 1;

        Integer ab;
        int c;
        return String.valueOf(123);
    }

    public Integer test3(String msg, int ab) {
        return Integer.parseInt(msg);
    }
}

//test22에 d를 넣어서 완성된 문자열을 s에 저장시킨 후 'test22 : '와 s를 합친 문자열 프린트


class Ex02_switch {
    public static void main() {
        int i = 4;

        switch (i % 3) {
            case 1: // else if (i % 3 == 1)
                System.out.println("나머지가 1");
                break;
            case 2:
                System.out.println("나머지가 2");
                break;
            default:
                System.out.println("나머지가 0");
        }
    }
}


class Ex06_ForExtension {
    public static void main(String[] args) {
        int i = 0;
        for (; i < 10; i++) {
            if (i % 2 == 0)
                System.out.println(i + " ");

        }
        System.out.println();

        i = 0;
        for (; i < 10; ) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
                return;
            } else if (i % 2 == 1) {
                System.out.println(i + " ");
            } else if (i % 3 == 1) {
                System.out.println(i + " ");
            }

            i++;
        }
        System.out.println();

        for (int j = 0; j < 10; j = j + 2) {
            System.out.println(j + " ");
        }
        System.out.println();
    }
}