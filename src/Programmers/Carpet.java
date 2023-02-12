package Programmers;

import java.util.ArrayList;
import java.util.Collections;
/**
 * level 2
 * 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Carpet {
    public static void main(String[] args) {
        solution(24, 24);
    }
    public static void solution(int brown, int yellow) {
        int[] answer = {}; // answer[0] = width, answer[1] = height

        int width = 0;
        int height = 0;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0 && i >= (yellow / i)) {
                if (((i * 2) + (yellow / i) * 2 + 4) == brown) {
                    width = i + 2;
                    height = (yellow / i) + 2;
                    break;
                }
            }
        }

        int[] newArr = new int[2];
        newArr[0] = width;
        newArr[1] = height;

        answer = newArr;

        System.out.println(answer[0] + " " + answer[1]);
        }
    }

