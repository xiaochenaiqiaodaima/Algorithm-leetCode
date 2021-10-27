package 山峰数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/10/14 14:37
 **/
public class Solution {
    public static int peakIndexInMountainArray(int[] arr) {
        int l = arr.length - 2;
        int i = 1;
        while (i <= l){
            int mid = (i + l ) / 2;
            if (arr[mid] < arr[mid + 1]){
                i = mid + 1;
            } else {
                l = mid - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,0};
        int i = peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}
