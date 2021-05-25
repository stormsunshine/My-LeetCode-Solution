class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> products = new ArrayList<List<Integer>>();
        int product = 0, count = 0;
        int length1 = encoded1.length, length2 = encoded2.length;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int val1 = encoded1[index1][0], val2 = encoded2[index2][0];
            int freq = Math.min(encoded1[index1][1], encoded2[index2][1]);
            encoded1[index1][1] -= freq;
            encoded2[index2][1] -= freq;
            int curProduct = val1 * val2;
            if (curProduct == product)
                count += freq;
            else {
                if (count > 0)
                    products.add(Arrays.asList(product, count));
                product = curProduct;
                count = freq;
            }
            if (encoded1[index1][1] == 0)
                index1++;
            if (encoded2[index2][1] == 0)
                index2++;
        }
        products.add(Arrays.asList(product, count));
        return products;
    }
}