package com.example.baseballGame;

import lombok.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static org.hibernate.Hibernate.contains;

@RequiredArgsConstructor
@SpringBootApplication
public class randomNumber {

    private static List<Integer> numbers = null;

    public static void main(String[] args) {

        int ball = 0;
        int strike = 0;
        int out = 0;
        if (numbers == null) {
            numbers = new ArrayList<>();
            int firstRandomNumber = (int) (Math.random() * 9) + 1;
            numbers.add(firstRandomNumber);

            while (numbers.size() < 3) {
                int randomNumber = (int) (Math.random() * 10);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }
        }
        String inputNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("3자리 자연수의 숫자를 맞춰주세요:");
        inputNumber = sc.next();

        int[] inputNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            inputNumbers[i] = Character.getNumericValue(inputNumber.charAt(i));
        }

        // 비교 결과 출력
        for (int i = 0; i < 3; i++) {
            if (inputNumbers[i] == numbers.get(i)) {
                strike++;
            } else if (contains(numbers, inputNumbers[i])) {
                ball++;
            } else {
                out++;
            }
        }

        if (strike == 3) {
            System.out.println("정답!");
            return;
        } else {
            System.out.println(strike + "스트라이크, " + ball + "볼, " + out + "아웃");
            main(null);
        }

    }
}