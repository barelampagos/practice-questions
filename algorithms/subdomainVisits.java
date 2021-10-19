/**
A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.

Example 1:
Input: cpdomains = ["9001 discuss.leetcode.com"]
Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
Explanation: We only have one website domain: "discuss.leetcode.com".
As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 */
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> countDomain = new HashMap<>();
        
        // Process each domain (and sub levels)
        for (String countPairDomain : cpdomains) {
            String[] countSplit = countPairDomain.split(" ");
            int count = Integer.parseInt(countSplit[0]);
            String[] domainSplit = countSplit[1].split("\\.");
            
            // For each piece of the domain:
            for (int i = 0; i < domainSplit.length; i++) {                
                String[] currDomainToGen = Arrays.copyOfRange(domainSplit, i, domainSplit.length);
                String currDomain = String.join(".", currDomainToGen);
                
                //System.out.println(currDomain);
                
                if (countDomain.containsKey(currDomain)) {
                    int existCount = countDomain.get(currDomain);
                    countDomain.put(currDomain, existCount + count);
                } else {
                    countDomain.put(currDomain, count);
                }                
            }
        }
        
        List<String> results = new ArrayList<>();
        
        for (String domain : countDomain.keySet()) {
            results.add(countDomain.get(domain) + " " + domain);
        }
        
        return results;
    }
}