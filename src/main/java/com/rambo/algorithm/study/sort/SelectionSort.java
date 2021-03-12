package com.rambo.algorithm.study.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rambo.pan
 * @version 1.0
 * @date 2021/2/24 5:52 PM
 */
public class SelectionSort implements Sort{
    @Override
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min){
                    min = array[j];
                    index = j;
                }
            }

            if (i != index){
                array[index] = array[i];
                array[i] = min;
            }

            System.out.printf("");
        }

        int[] a = {1,2,3};
        return array;
    }
}
