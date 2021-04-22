package com.hehe.javalib.code.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MinKNumber_40 {

    /**
     * 大小为 K 的最小堆
     * 复杂度：O(NlogK) + O(K)
     * 特别适合处理海量数据
     * 维护一个大小为 K 的最小堆过程如下：使用大顶堆。在添加一个元素之后，
     * 如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，
     * 从而使得留在堆中的元素都比被去除的元素来得小。
     *
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     *
     * Java 的 PriorityQueue 实现了堆的能力，PriorityQueue 默认是小顶堆，
     * 可以在在初始化时使用 Lambda 表达式 (o1, o2) -> o2 - o1 来实现大顶堆。其它语言也有类似的堆数据结构。
     */

    public static List<Integer> getMinKNumber(int[] datas, int k){
        if (k> datas.length || k<=0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int data : datas){
            maxHeap.add(data);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public  ArrayList<Integer> getMinKNumberQuickSort(int[] datas, int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k> datas.length){
            for (int data : datas){
                arrayList.add(data);
            }
            return arrayList;
        }
        DoQuickSort(datas,k);
        for (int i=0; i<k; i++){
            arrayList.add(datas[i]);
        }
        return arrayList;
    }

    private void DoQuickSort(int[] datas, int k) {
        //快速排序
        int l = 0; int h = datas.length - 1;
        while (l<h){
            int j = QuickSort(datas, l ,h);
            if (j == k){
                break;
            }else if (j<k){
                l = j+1;
            }else{
                h = j-1;
            }
        }
    }

    private int QuickSort(int[] datas, int l, int h) {
        int p = datas[l];
        int i = l; int j = h;
        while (i != j){
            while (i<j && p<datas[j]){
              j--;
            }

            while (i<j && p>datas[i]){
                i++;
            }

            if (i<j){
                swap(datas,i,j);
            }
        }
        swap(datas,l,i);
        return i;
    }

    private void swap(int[] datas, int i, int j) {
        int t = datas[i];
        datas[i] = datas[j];
        datas[j] = t;
    }
}
