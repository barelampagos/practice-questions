class Solution {
    public int romanToInt(String s) {
        System.out.println(s);
        
        // Create roman character map
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int value = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Character nextChar = i + 1 < s.length() ? s.charAt(i + 1) : null;
            
            if (nextChar != null && currentChar == nextChar) {
                value += romanMap.get(currentChar);
                System.out.println("+" + romanMap.get(currentChar));
            } else if (nextChar != null && romanMap.get(currentChar) < romanMap.get(nextChar)) {
                // if different and greater, subtract from sum
                value += romanMap.get(nextChar) - romanMap.get(currentChar);
                System.out.println("+" + (romanMap.get(nextChar) - romanMap.get(currentChar)));
                
                i++;
            } else {
                value += romanMap.get(currentChar);
                System.out.println("+" + romanMap.get(currentChar));
            }
        }
        
        return value;
    }
}