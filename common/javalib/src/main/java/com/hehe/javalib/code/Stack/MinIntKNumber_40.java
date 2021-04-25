package com.hehe.javalib.code.Stack;


import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 *  @项目名：  hodgepodge
 *  @包名：    com.hehe.javalib.code.Stack
 *  @文件名:   MinIntKNumber
 *  @创建者:   Seven
 *  @创建时间:  2021/4/21 10:18
 *  @描述：    TODO
 */
public class MinIntKNumber_40 {
    /**
     * 维护一个大小为 K 的最小堆过程如下：使用大顶堆。在添加一个元素之后，
     * 如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，
     * 也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
     *
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     */

    public ArrayList<Integer> getMinKUseQueue(int[] data, int k){
        if (data.length<k || k<0){
            return null;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i: data){
            priorityQueue.add(i);
            if (priorityQueue.size()>k)
                priorityQueue.poll();
        }
        return new ArrayList<>(priorityQueue);

    }
}
