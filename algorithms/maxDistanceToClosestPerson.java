/**
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:
Input: seats = [1,0,0,0,1,0,1]
Output: 2

Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

**/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        System.out.println(Arrays.toString(seats));
        
        // Iterate seats
        for (int i = 0; i < seats.length; i++) {
            //System.out.println("[SEAT INDEX: " + i +"]");
            
            // If seat is taken, we can skip
            if (seats[i] == 1) {
                continue;
            }
            
            // If seat is empty:
            // Calculate distance from left & right (nearest person)
            int leftDistance = 0;
            boolean personOnLeft = false;
            for (int left = i - 1; left >= 0; left--) {
                leftDistance++;
                
                if (seats[left] == 1) {
                    personOnLeft = true;
                    break;
                }
            }
            //System.out.println("--LEFT: " + leftDistance);
            
            int rightDistance = 0;
            boolean personOnRight = false;
            for (int right = i + 1; right < seats.length; right++) {
                rightDistance++;
                
                if (seats[right] == 1) {
                    personOnRight = true;
                    break;
                }
            }
            //System.out.println("--RIGHT: " + rightDistance);
                
            // Keep miniumum of distances to people
            int minDistance = 0;
            if (personOnLeft && personOnRight) {
                minDistance = Math.min(leftDistance, rightDistance);
            } else if (!personOnLeft && personOnRight) {
                minDistance = rightDistance;
            } else if (personOnLeft && !personOnRight) {
                minDistance = leftDistance;
            }
            //System.out.println("MIN: " + minDistance);
        
            // Compare against current maxDistance
            maxDistance = Math.max(minDistance, maxDistance);
            //System.out.println("MAX: " + minDistance);
        }
        
        // Once all seats evaluated, return maxDistance
        return maxDistance;
    }
}