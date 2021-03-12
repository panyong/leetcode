package com.rambo.algorithm.study.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author rambo.pan
 * @version 1.0
 * @date 2021/2/24 5:49 PM
 */
public class BootApplication {
    public static void main(String[] args) {
        int[] ary = randomAry(1,100, 15);
        System.out.println(Arrays.stream(ary).mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(",")));

//        Sort sort = new BubbleSort();

//        Sort sort = new SelectionSort();

//        Sort sort = new InsertionSort();

        Sort sort = new HeapSort();
        ary = sort.sort(ary);

        System.out.println(Arrays.stream(ary).mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(",")));


    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        List<Integer> retList = new ArrayList();

        for(int i = 0; i < nums1.length; i++){
            Integer count = map1.get(Integer.valueOf(nums1[i]));
            count = count == null ? 1 : count + 1;
        }

        for(int i = 0; i < nums2.length; i++){
            Integer count = map2.get(Integer.valueOf(nums2[i]));
            count = count == null ? 1 : count + 1;
        }

        Map<Integer, Integer> mapS = map1.size() > map2.size() ? map2 : map1;
        Map<Integer, Integer> mapB = map1.size() > map2.size() ? map1 : map2;

        for (Integer num : map1.keySet()) {
            if(map2.get(num) == null){
                continue;
            }
            int count = map1.get(num) < map2.get(num) ? map1.get(num) : map2.get(num);
            System.out.println(""+num+":"+count);
            for(int i = 0; i < count; i++){
                retList.add(num);
            }
        }

        System.out.println(retList.stream().map(num -> String.valueOf(num)).collect(Collectors.joining(",")));

        int[] retAry = new int[retList.size()];
        for(int i = 0; i < retList.size(); i++){
            retAry[i] = retList.get(i);
        }

        return retAry;
    }


    private static int[] randomAry(int start, int end, int count){
        if (start > end || count > (end - start)){
            throw new RuntimeException("error");
        }
        int[] ary = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            ary[i] = random.nextInt(end - start) + start;
        }

        return  ary;
    }
}
