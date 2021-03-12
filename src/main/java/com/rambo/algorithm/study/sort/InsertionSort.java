package com.rambo.algorithm.study.sort;

/**
 * @author rambo.pan
 * @version 1.0
 * @date 2021/2/24 5:52 PM
 */
public class InsertionSort implements Sort{
    @Override
    public int[] sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1, k = i; j >= 0 && k > 0; j--, k--) {
                if (array[k] < array[j]){
                    int temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                }else {
                    break;
                }
            }
        }

        return array;
    }
}
