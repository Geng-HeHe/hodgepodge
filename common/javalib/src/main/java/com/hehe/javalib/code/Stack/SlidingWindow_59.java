package com.hehe.javalib.code.Stack;

import com.hehe.javalib.list.ArrayList;
import com.sun.glass.ui.Size;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.zip.Adler32;

/*
 *  @项目名：  hodgepodge
 *  @包名：    com.hehe.javalib.code.Stack
 *  @文件名:   SlidingWindow_59
 *  @创建者:   Seven
 *  @创建时间:  2021/4/27 15:54
 *  @描述：    TODO
 */
public class SlidingWindow_59 {

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     *
     * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，
     * 那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
     */

    public ArrayList<Integer> getSlidingWindow(int[] data, int window){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */

        for (int i=0; i<size; i++)
            heap.add(data[i]);

        arrayList.add(heap.peek());
        for (int i = 0, j = i+ Size; j<data.length; i++,j++){
            heap.remove(data[i]);
            heap.add(data[j]);
            arrayList.add(heap.peek());

        }

        return arrayList;
    }

}
