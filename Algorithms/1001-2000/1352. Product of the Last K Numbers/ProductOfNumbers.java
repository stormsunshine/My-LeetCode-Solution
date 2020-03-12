class ProductOfNumbers {
    List<Integer> productList;
    int size;

    public ProductOfNumbers() {
        productList = new ArrayList<Integer>();
        size = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            for (int i = size - 1; i >= 0; i--) {
                int product = productList.get(i);
                if (product == 0)
                    break;
                productList.set(i, 0);
            }
        } else if (num > 1) {
            for (int i = size - 1; i >= 0; i--) {
                int product = productList.get(i);
                if (product == 0)
                    break;
                productList.set(i, product * num);
            }
        }
        productList.add(num);
        size++;
    }
    
    public int getProduct(int k) {
        return productList.get(size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */