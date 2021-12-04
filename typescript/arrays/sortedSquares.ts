/**
 * 
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 * @param nums 
 * @returns 
 */
function sortedSquares(nums: number[]): number[] {
    let posPtr: number = 0;
    let negPtr: number = 0;
    let results: number[] = [];
    
    for (let i = 1; i < nums.length; i++) {
        let curr = nums[i];
        posPtr = i;
        negPtr = i - 1;
        
        if (curr >= 0) {
            break;
        }
    }
    
    // console.log(posPtr);
    // console.log(negPtr);
    
    if (posPtr == negPtr && nums.length == 1) {
        results.push(Math.pow(nums[posPtr], 2))
        return results;
    } else if (posPtr == negPtr) {
        posPtr = nums.length;
    }
    
    while (negPtr >= 0 && posPtr < nums.length) {
        let posSqr: number = Math.pow(nums[posPtr], 2);
        let negSqr: number = Math.pow(nums[negPtr], 2);
        
        if (posSqr < negSqr) {
            results.push(posSqr);
            posPtr++;
        } else {
            results.push(negSqr);
            negPtr--;
        }
    }
    
    while (negPtr >= 0) {
        let negSqr: number = Math.pow(nums[negPtr], 2);
        results.push(negSqr);
        negPtr--;
    }
    
    while (posPtr < nums.length) {
        let posSqr: number = Math.pow(nums[posPtr], 2);
        results.push(posSqr);
        posPtr++;
    }
    
    return results;
};