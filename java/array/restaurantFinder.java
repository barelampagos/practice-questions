/**
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

 

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
 */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> results = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        HashMap<String, Integer> restMap = new HashMap<>();
        
        // Iterate the first list
        for (int i = 0; i < list1.length; i++) {
            // Store the value of the element (K: Restaurant name, V: Index)
            restMap.put(list1[i], i);
        }
            
        // Iterate second list
        for (int i = 0; i < list2.length; i++) {
            String currKey = list2[i];
            // If map contains restaurant name, fetch value (first list index)
            if (restMap.containsKey(currKey)) {
                int list1Index = restMap.get(currKey);
                int list2Index = i;
                
                // Calculate index sum 
                int indexSum = list1Index + list2Index;
                
                if (indexSum < minIndexSum) {
                    //System.out.println("NEW LOW: " + indexSum);
                    results = new ArrayList<>();
                    results.add(currKey);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    results.add(currKey);
                }
            }
            
            //System.out.println("Results: " + results.toString());
        }
        
        // Convert results to output array
        String[] resultArray = new String[results.size()];
        resultArray = results.toArray(resultArray);
        return resultArray;
    }
}