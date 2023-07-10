package org.example.StackAndQueue.MaxValArrInGenerateWindow;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成双端队列qmax，qmax
 * 中存放数组arr中的下标
 * 假设遍历到arr[i]，qmax 的放入规则为：
 * 1．如果qmax为空，直接把下标i放进qmax，放入过程结束。
 * 2．如果qmax不为空，取出当前qmax队尾存放的下标，假设为j。
 * 1）如果arr[j]>arr[i]，直接把下标 i放进qmax 的队尾，放入过程结束。
 * 2）如果arr[j]<=arr[i]，把 j 从 qmax 中弹出，重复qmax 的放入规则。
 * 也就是说，如果qmax是空的，就直接放入当前的位置。如果qmax不是空的，qmax队尾
 * 的位置所代表的值如果不比当前的值大，将一直弹出队尾的位置，直到 qmax 队尾的位置所代
 * 表的值比当前的值大，当前的位置才放入qmax的队尾。
 * 假设遍历到arr[i]，qmax 的弹出规则为：
 * 如果qmax队头的下标等于i-w，说明当前qmax队头的下标已过期，弹出当前对头的下标即可。
 * 根据如上的放入和弹出规则，qmax 便成了一个维护窗口为 w 的子数组的最大值更新的结构
 */
public class ByDeque {
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWindow(arr, 3);
        Arrays.stream(res).forEach(System.out :: print);
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if(arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if(i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()] ;
            }
        }
        return res;
    }


}
