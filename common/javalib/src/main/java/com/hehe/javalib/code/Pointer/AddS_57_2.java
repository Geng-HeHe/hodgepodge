package com.hehe.javalib.code.Pointer;

import com.hehe.javalib.list.ArrayList;

/*
 *  @项目名：  hodgepodge
 *  @包名：    com.hehe.javalib.code.Pointer
 *  @文件名:   AddS_57_2
 *  @创建者:   Seven
 *  @创建时间:  2021/4/29 11:44
 *  @描述：    TODO
 */
public class AddS_57_2 {
    /**
     * 输出所有和为 S 的连续正数序列。例如和为 100 的连续序列有：
     *
     * [9, 10, 11, 12, 13, 14, 15, 16]
     * [18, 19, 20, 21, 22]。
     */

    public ArrayList<Integer> getAddSArray(int[] data, int sum ){

        ArrayList<Integer> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end<sum){
            if (curSum > sum){
                curSum -=start;
                start++;
            }else if(curSum < sum){
                end++;
                curSum += end;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=start; i<end; i++)
                     list.add(i);
                ret.add(list);
                curSum-=start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
