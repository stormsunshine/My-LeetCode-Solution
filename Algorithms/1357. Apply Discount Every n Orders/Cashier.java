class Cashier {
    int discountCustomers;
    int discount;
    Map<Integer, Integer> productsMap;
    int[] prices;
    int customerCount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.discountCustomers = n;
        this.discount = discount;
        productsMap = new HashMap<Integer, Integer>();
        int length = products.length;
        for (int i = 0; i < length; i++)
            productsMap.put(products[i], i);
        this.prices = prices;
        customerCount = 0;
    }
    
    public double getBill(int[] product, int[] amount) {
        customerCount = (customerCount + 1) % discountCustomers;
        double total = 0;
        int length = product.length;
        for (int i = 0; i < length; i++) {
            int curProduct = product[i];
            int productIndex = productsMap.get(curProduct);
            int curAmount = amount[i];
            total += prices[productIndex] * curAmount;
        }
        if (customerCount == 0)
            total -= (discount * total) / 100;
        return total;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */