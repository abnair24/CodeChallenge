package com.abn.dsalgos.challenges.problems;


import java.util.ArrayList;
import java.util.List;

/*
Arbitary shopping
    A shopper goes to shop and picks an outfit.Later shopper buys all consecutive outfits starting with that outfit up to
    nth outfit as long as money is available. Determine max number of outfits shopper can buy.

    n = 7
    [2,3,5,1,1,2,1]
    money = 5

    no of subarrays with sum = [2,3],[5],[1,1,2,1]
    o/p : longest one : 4

 */
public class MaximumOutfits {

    public static int getMaximumOutfits(List<Integer> outfits,int money) {
        int[] array = outfits.stream().mapToInt(i->i).toArray();
        int size = array.length;
        int sum = 0;
        int count = 0;
        int maxCount = 0;

        for(int i=0;i<size;i++){
            if((sum + array[i])<= money) {
                sum+= array[i];
                count++;
            }

            else if(sum!=0) {
                sum = sum - array[i-count] +array[i];
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        List<Integer> outfitValue = new ArrayList<>();
        outfitValue.add(2);
        outfitValue.add(3);
        outfitValue.add(2);
        outfitValue.add(1);
        outfitValue.add(1);
        outfitValue.add(2);
        outfitValue.add(1);

        getMaximumOutfits(outfitValue,5);
    }
}
