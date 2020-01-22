class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<String>();
        for (String email : emails) {
            int atIndex = email.indexOf("@");
            String localName = email.substring(0, atIndex);
            String domainName = email.substring(atIndex);
            localName = localName.replaceAll("\\.", "");
            if (localName.indexOf('+') >= 0)
                localName = localName.substring(0, localName.indexOf('+'));
            String actualEmail = localName + domainName;
            emailsSet.add(actualEmail);
        }
        return emailsSet.size();
    }
}