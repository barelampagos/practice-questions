/**
Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each email[i], return the number of different addresses that actually receive mails.

Example 1:
Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 */

function numUniqueEmails(emails: string[]): number {
    let uniqueEmails: Set<string> = new Set();
    
    // Iterate through emails array
    for (let i = 0; i < emails.length; i++) {
        let currEmail: string = normalizeEmail(emails[i]);
        
        if (!uniqueEmails.has(currEmail)) {
            uniqueEmails.add(currEmail);
        }
    }
    
    // Keep track of unique email addresses and return count    
    return uniqueEmails.size;
};

// Normalize the input email 
// Each email has 2 parts: local & domain
    // Validation logic:
    // 1. Local can have . - local will ignore this and send
    // 2. Local can have + - everything after first + ignored 
function normalizeEmail(email: string): string {
    let normalizedEmail: string = email;
    
    let emailParts: string[] = normalizedEmail.split('@');
    let localName: string = emailParts[0]
    let domainName: string = emailParts[1]
    
    // Format Local name
    // R1
    localName = localName.split('.').join('');
    
    // R2
    let localNameSplit: string[] = localName.split('+');
    localName = localNameSplit[0];
    
    normalizedEmail = `${localName}@${domainName}`;
    console.log(normalizedEmail);
    
    return normalizedEmail;
}