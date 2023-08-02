package Test3;

import java.util.*;
import java.util.stream.Stream;

public class PayPayTest {
    public static void main(String[] args) {
        /*int[] nums1 = new int[]{1,2,3,0,0,0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
*/
        int[] nums1 = new int[]{-1,-1,0,0,0,0};
        merge(nums1, 4, new int[]{-1,0}, 2);

        /*int[] nums1 = new int[]{0};
        merge(nums1, 0, new int[]{1}, 1);*/
        for(int v: nums1){
            System.out.println(v);
        }

        System.out.println("maxProfit: "+maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,iCount=0;

        while(j<n){
            if(nums1[i]>nums2[j]){
                int prev = nums1[i];

                nums1[i] = nums2[j++];

                for(int k=i+1;k<m+n;k++){
                    int temp = nums1[k];
                    nums1[k] = prev;
                    prev = temp;
                }

            }else if(iCount>=m && nums2[j] >= nums1[i]){
                nums1[i] = nums2[j++];
            }else{
                iCount++;
            }
            i++;
        }
    }

    public static int maxProfit(int[] prices) {
        int max=0,len = prices.length, buyPrice=prices[0],leftPointer=1,rightPointer=len-1;

        for(int i=0;i<len;i++){
            buyPrice=prices[i];
            leftPointer=i+1;
            rightPointer=len-1;

            while(leftPointer<=rightPointer){


                if(prices[leftPointer]>buyPrice){
                    if(prices[leftPointer]-buyPrice>max) max = prices[leftPointer]-buyPrice;
                }
                if(prices[rightPointer]>buyPrice){
                    if(prices[rightPointer]-buyPrice>max) max = prices[rightPointer]-buyPrice;
                }

                leftPointer++;
                rightPointer--;
            }
        }

        return max;
    }
}
