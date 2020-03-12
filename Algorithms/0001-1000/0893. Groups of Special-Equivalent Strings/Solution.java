class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<String>();
        for (String str : A) {
            int length = str.length();
            StringBuffer even = new StringBuffer();
            StringBuffer odd = new StringBuffer();
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if (i % 2 == 0)
                    even.append(c);
                else
                    odd.append(c);
            }
            char[] evenArray = even.toString().toCharArray();
            char[] oddArray = odd.toString().toCharArray();
            Arrays.sort(evenArray);
            Arrays.sort(oddArray);
            StringBuffer sorted = new StringBuffer();
            int evenLength = evenArray.length, oddLength = oddArray.length;
            int evenIndex = 0, oddIndex = 0;
            while (oddIndex < oddLength) {
                sorted.append(evenArray[evenIndex++]);
                sorted.append(oddArray[oddIndex++]);
            }
            if (evenIndex < evenLength)
                sorted.append(evenArray[evenIndex++]);
            set.add(sorted.toString());
        }
        return set.size();
    }
}