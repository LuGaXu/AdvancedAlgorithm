package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lujxu on 2018/3/12.
 * description: Given an array of integers, return indices(指数) of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * link:https://leetcode.com/problems/two-sum/description/
 *example: Given nums = [2, 7, 11, 15], target = 9,
 *Because nums[0] + nums[1] = 2 + 7 = 9,
 *return [0, 1].
 * result: 8ms
 */
public class TwoSum {

    public static  void  main(String args[]){
        TwoSum sum=new TwoSum();
        System.out.println(sum.twoSum(new int[]{3,2,4},6));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int num=target-nums[i];
            if(map.containsKey(num)){
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
