/**
Given an integer array nums of unique elements, return all possible subsets (the power set)
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @param nums 
 * @returns 
 */
function subsets(nums: number[]): number[][] {
    let results: number[][] = [[]];
    
    for (let i = 0; i < nums.length; i++) {
        let currNum: number = nums[i];
        let numSets: number = results.length;
        
        for (let j = 0; j < numSets; j++) {
            let updatedSet: number[] = results[j].slice(0);
            updatedSet.push(nums[i]);
            results.push(updatedSet);
        }
        
    }
    
    return results;
};