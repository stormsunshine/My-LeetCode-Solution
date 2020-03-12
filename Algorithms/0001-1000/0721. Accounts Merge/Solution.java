class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<String, List<Set<String>>>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            Set<String> emails = new HashSet<String>();
            for (int i = 1; i < size; i++)
                emails.add(account.get(i));
            List<Set<String>> list = map.getOrDefault(name, new ArrayList<Set<String>>());
            List<Set<String>> loopList = new ArrayList<Set<String>>(list);
            for (Set<String> prevSet : loopList) {
                Set<String> intersection = new HashSet<String>(prevSet);
                intersection.retainAll(emails);
                if (intersection.size() > 0) {
                    list.remove(prevSet);
                    emails.addAll(prevSet);
                }
            }
            list.add(emails);
            map.put(name, list);
        }
        List<List<String>> mergedAccounts = new ArrayList<List<String>>();
        Set<String> keySet = map.keySet();
        for (String name : keySet) {
            List<Set<String>> list = map.get(name);
            for (Set<String> set : list) {
                List<String> accountList = new ArrayList<String>(set);
                Collections.sort(accountList);
                accountList.add(0, name);
                mergedAccounts.add(accountList);
            }
        }
        return mergedAccounts;
    }
}