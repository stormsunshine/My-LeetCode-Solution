class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMap = new HashMap<String, Integer>();
        for (String cpdomain : cpdomains) {
            String[] cpdomainArray = cpdomain.split(" ");
            int count = Integer.parseInt(cpdomainArray[0]);
            String domain = cpdomainArray[1];
            while (domain.length() > 0) {
                int prevCount = domainCountMap.getOrDefault(domain, 0);
                int newCount = prevCount + count;
                domainCountMap.put(domain, newCount);
                if (domain.indexOf('.') < 0)
                    break;
                domain = domain.substring(domain.indexOf('.') + 1);
            }
        }
        List<String> subdomainVisits = new ArrayList<String>();
        Set<String> domainsSet = domainCountMap.keySet();
        for (String domain : domainsSet) {
            int count = domainCountMap.getOrDefault(domain, 0);
            String subdomainVisit = count + " " + domain;
            subdomainVisits.add(subdomainVisit);
        }
        return subdomainVisits;
    }
}