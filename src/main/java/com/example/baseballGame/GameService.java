package com.example.baseballGame;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private List<Integer> numbers = null;

    public void generateNumbers() {
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
    }

    public String checkGuess(String inputNumber) {
        int[] inputNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            inputNumbers[i] = Character.getNumericValue(inputNumber.charAt(i));
        }

        int ball = 0;
        int strike = 0;
        int out = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNumbers[i] == numbers.get(i)) {
                strike++;
            } else if (numbers.contains(inputNumbers[i])) {
                ball++;
            } else {
                out++;
            }
        }

        if (strike == 3) {
            numbers = null; // 게임 종료 후 초기화
            return "정답!";
        } else {
            return strike + " 스트라이크, " + ball + " 볼, " + out + " 아웃";
        }
    }
}
