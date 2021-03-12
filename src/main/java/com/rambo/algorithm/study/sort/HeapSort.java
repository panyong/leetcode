package com.rambo.algorithm.study.sort;

/**
 * @author rambo.pan
 * @version 1.0
 * @date 2021/2/24 5:52 PM
 */
public class HeapSort implements Sort{
    @Override
    public int[] sort(int[] array) {

        // 构建大顶堆
        buildMaxHeap(array);
        // 大顶堆的规模从 array.length 到 1 不断缩减；每次从根结点取出当前堆的最大值放到已排序数列的最左侧
        for (int i = array.length - 1; i > 0; i--) {
            // 取出大顶堆的根结点：array[0]
            // 将当前最大值与已排序数列的最小值进行交换
            swap(array, 0, i);
            // 重构大顶堆
            refactorHeap(array, 0, i);
        }

        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 调整指定节点的堆结构
     * @param array 待调整的堆，数组形式，含有不属于堆的数据
     * @param nodeIndex 指定节点的索引
     * @param length 限定数组中属于堆结构的数据
     */
    private void refactorHeap(int[] array, int nodeIndex, int length) {
        int leftIndex = nodeIndex * 2 + 1;
        int rightIndex = nodeIndex * 2 + 2;
        // 暂定最大值的结点为当前结点
        int largestIndex = nodeIndex;
        // 当左子结点的值大于当前结点且左子结点属于堆结构时，将最大值结点设定为左子结点
        if (leftIndex < length && array[leftIndex] > array[largestIndex]){
            largestIndex = leftIndex;
        }
        // 同上
        if ((rightIndex < length && array[rightIndex] > array[largestIndex])){
            largestIndex = rightIndex;
        }

        // 判断当前结点的值是否需要发生变化
        if (largestIndex != nodeIndex){
            // 交换值，将数值最大的结点设置为当前子树的父结点
            swap(array, largestIndex, nodeIndex);
            // 结构发生变化后，重构发生变化的左子树or右子树
            refactorHeap(array, largestIndex, length);
        }
    }

    // 从上到下，从右到左地构建大顶堆
    private void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--){
            refactorHeap(array, i, array.length);
        }
    }
}
