class Solution {
    public boolean isPalindrome(int x) {
        // if negative, return false
        if (x < 0) {
            return false;
        }
        
        int copyX = new Integer(x);
        
        int numDigits = 0;
        while (copyX != 0) {
            numDigits++;
            copyX /= 10;
        }
        
        //System.out.println(numDigits);
        
        // Get us to halfway
        int pow = numDigits / 2 - 1;
        int newNum = 0;
        copyX = new Integer(x);
        
        int currDigit = 0;
        while (pow >= 0) {
            currDigit = copyX % 10;
            copyX /= 10;
            newNum += currDigit * Math.pow(10, pow);
            pow--;
        }
        
        // Odd number? skip middle
        if (numDigits % 2 == 1) {
            copyX /= 10;
        }
        
        // System.out.println("NEW NUM: " + newNum);
        // System.out.println("COPYX: " + copyX);
        
        // Compare original w/ new Num (equal ? true : false) 
        return newNum == copyX;
    }
}

// 1221 % 10 = 1
// 1221 / 10 = 122
// newNum = 1 * 10 ^ 1 (pow = length / 2 - 1) ?
// newNum = 10

// 122 % 10 = 2
// 122 / 10 = 12
// newNum += 2 * 10 ^ 0 (pow = pow--)
// newNum = 12