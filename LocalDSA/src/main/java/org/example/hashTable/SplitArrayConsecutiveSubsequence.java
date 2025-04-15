package org.example.hashTable;

import java.util.HashMap;

public class SplitArrayConsecutiveSubsequence {

    public boolean isPossible(int[] nums){
        HashMap<Integer,Integer> freqs= new HashMap<>(),
                append = new HashMap<>();

        for(int n:nums){
            freqs.put(n,freqs.getOrDefault(n,0)+1);
        }

        for(int num:nums) {
            if (freqs.get(num)==0)continue;
            //
            if(append.getOrDefault(num-1,0)>0){
                append.put(num-1,append.get(num-1)-1);
                append.put(num,append.getOrDefault(num,0)+1);
            }
            else if(freqs.getOrDefault(num+1,0)>0 && freqs.getOrDefault(num+2,0)>0){
                freqs.put(num+1,freqs.get(num+1)-1);
                freqs.put(num+2,freqs.get(num+2)-1);
                append.put(num+2,append.getOrDefault(num+2,0)+1);

            }else return false;
            freqs.put(num,freqs.get(num)-1);
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,5};//{1,2,3,3,4,4,5,5};//{1,2,3,3,4,5};
        System.out.println(new SplitArrayConsecutiveSubsequence().isPossible(nums));
    }
}
