class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestedProducts = new ArrayList<List<String>>();
        Arrays.sort(products);
        int productsCount = products.length;
        int searchLength = searchWord.length();
        StringBuffer search = new StringBuffer();
        for (int i = 0; i < searchLength; i++) {
            search.append(searchWord.charAt(i));
            String curSearch = search.toString();
            List<String> curSuggestedProducts = new ArrayList<String>();
            int suggestCount = 0;
            for (int j = 0; j < productsCount; j++) {
                String product = products[j];
                if (product.indexOf(curSearch) == 0) {
                    curSuggestedProducts.add(product);
                    suggestCount++;
                    if (suggestCount == 3)
                        break;
                }
            }
            suggestedProducts.add(curSuggestedProducts);
        }
        return suggestedProducts;
    }
}