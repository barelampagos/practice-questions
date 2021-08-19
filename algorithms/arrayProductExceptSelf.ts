function productExceptSelf(nums: number[]): number[] {
  
  let result:number[] = [];
  result.push(1);
  
  for (let i = 0; i < nums.length-1; i++) {
    
    result[i+1] = result[i] * nums[i];
    
  }
  
  console.log(result);
  
  let sideProduct = 1;
  for (let i = nums.length-2; i >= 0; i--) {
    sideProduct = sideProduct*nums[i+1];
    result[i] = result[i]*sideProduct
  }  
  
  console.log(result);
  
  return result;
};



// multiply arr and then divide by nums[i]

// 24 / 1 = 24
// 24 / 2 = 12
// 24 / 3 = 8
// ..



// start [1 2 3 4]

// result [1, start[0]*result[0] = 1, start[1]*result[1] = 2, start[2]*result[2] = 6]
// result = [1,1,2,6]

// result[1] = previous value * start array at 1

// going from start to end keeping track of a product and skipping an index
// [1, 1*1, 2*1, 3*2]

// do something similar from end to front now
// result = [1,1,2,6]

// start [1 2 3 4]


// [1, 1*1, 2*1, 3*2] == result = [1,1,2,6]
// [2*3*4, 1*3*4, 1*(2*4), 1*(2*3)]

// result = [,3*4,4*2=8,6]

// result = [2*3*4, 1*3*4, 1*2*4, 1*2*3]



// places a 1 at index results[0]

// ================================
// trace algorithm

// result = [1,1,2,6]

// sideProd = 1
// i = 3
// nums[i] = 4
// sideProd = 4 * sideProd = 4
// result[i-1] = 2
// results[i-1] = results[i-1] * sideProd
// result = [1,1,8,6]

// i = 2
// nums[i] = 3
// sideProd = 3 * sideProd = 12
// result[i-1] = 1
// results[i-1] = results[i-1] * sideProd = 12
// result = [1,12,8,6]

// i = 1
// nums[i] = 2
// sideProd = 2 * sideProd = 24
// result[i-1] = 1
// results[i-1] = results[i-1] * sideProd = 24
// result = [24,12,8,6]





