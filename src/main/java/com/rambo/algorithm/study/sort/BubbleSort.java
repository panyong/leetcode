package com.rambo.algorithm.study.sort;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author rambo.pan
 * @version 1.0
 * @date 2021/2/2 11:25 AM
 */
public class BubbleSort implements Sort{

    private int[] bubbleSort(int[] ary){
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary.length - i - 1; j++) {
                if (ary[j] > ary[j+1]){
                    int temp = ary[j+1];
                    ary[j+1] = ary[j];
                    ary[j] = temp;
                }
            }
        }

        return ary;
    }

    @Override
    public int[] sort(int[] array) {
        return bubbleSort(array);
    }
}
