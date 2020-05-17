class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        for (List<String> list : favoriteCompanies)
            Collections.sort(list);
        List<Integer> indices = new ArrayList<Integer>();
        int peopleCount = favoriteCompanies.size();
        for (int i = 0; i < peopleCount; i++) {
            boolean flag = true;
            List<String> list1 = favoriteCompanies.get(i);
            for (int j = 0; j < peopleCount; j++) {
                if (i == j)
                    continue;
                List<String> list2 = favoriteCompanies.get(j);
                if (isSubset(list1, list2)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                indices.add(i);
        }
        return indices;
    }

    public boolean isSubset(List<String> list1, List<String> list2) {
        int size1 = list1.size(), size2 = list2.size();
        if (size1 > size2)
            return false;
        int index1 = 0, index2 = 0;
        while (index1 < size1 && index2 < size2) {
            if (list1.get(index1).equals(list2.get(index2)))
                index1++;
            index2++;
        }
        return index1 == size1;
    }
}