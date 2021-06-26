class MovieRentingSystem {
    class Movie implements Comparable<Movie> {
        int shop;
        int id;
        int price;

        public Movie(int shop, int id, int price) {
            this.shop = shop;
            this.id = id;
            this.price = price;
        }

        public int hashCode() {
            return shop + id + price;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Movie) {
                Movie movie2 = (Movie) obj;
                return this.shop == movie2.shop && this.id == movie2.id && this.price == movie2.price;
            }
            return false;
        }

        public int compareTo(Movie movie2) {
            if (this.price != movie2.price)
                return this.price - movie2.price;
            else if (this.shop != movie2.shop)
                return this.shop - movie2.shop;
            else
                return this.id - movie2.id;
        }
    }

    static final int LIMIT = 5;
    int n;
    Map<Integer, HashMap<Integer, Integer>> movieShopPriceMap;
    Map<Integer, TreeMap<Integer, TreeSet<Integer>>> moviePriceShopMap;
    Map<Long, Integer> priceLookupMap;
    TreeSet<Movie> set;

    public MovieRentingSystem(int n, int[][] entries) {
        this.n = n;
        movieShopPriceMap = new HashMap<Integer, HashMap<Integer, Integer>>();
        moviePriceShopMap = new HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>>();
        priceLookupMap = new HashMap<Long, Integer>();
        set = new TreeSet<Movie>();
        for (int[] entry : entries) {
            int shop = entry[0], id = entry[1], price = entry[2];
            HashMap<Integer, Integer> shopPriceMap = movieShopPriceMap.getOrDefault(id, new HashMap<Integer, Integer>());
            shopPriceMap.put(shop, price);
            movieShopPriceMap.put(id, shopPriceMap);
            TreeMap<Integer, TreeSet<Integer>> priceShopMap = moviePriceShopMap.getOrDefault(id, new TreeMap<Integer, TreeSet<Integer>>());
            TreeSet<Integer> shopSet = priceShopMap.getOrDefault(price, new TreeSet<Integer>());
            shopSet.add(shop);
            priceShopMap.put(price, shopSet);
            moviePriceShopMap.put(id, priceShopMap);
            long key = getKey(shop, id);
            priceLookupMap.put(key, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> list = new ArrayList<Integer>();
        TreeMap<Integer, TreeSet<Integer>> priceShopMap = moviePriceShopMap.getOrDefault(movie, new TreeMap<Integer, TreeSet<Integer>>());
        boolean flag = true;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : priceShopMap.entrySet()) {
            TreeSet<Integer> shops = entry.getValue();
            for (int shop : shops) {
                list.add(shop);
                if (list.size() == LIMIT) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
        }
        return list;
    }
    
    public void rent(int shop, int movie) {
        HashMap<Integer, Integer> shopPriceMap = movieShopPriceMap.get(movie);
        int price = shopPriceMap.get(shop);
        shopPriceMap.remove(shop);
        TreeMap<Integer, TreeSet<Integer>> priceShopMap = moviePriceShopMap.get(movie);
        TreeSet<Integer> shopSet = priceShopMap.get(price);
        shopSet.remove(shop);
        set.add(new Movie(shop, movie, price));
    }
    
    public void drop(int shop, int movie) {
        long key = getKey(shop, movie);
        int price = priceLookupMap.get(key);
        Movie dropMovie = new Movie(shop, movie, price);
        set.remove(dropMovie);
        HashMap<Integer, Integer> shopPriceMap = movieShopPriceMap.get(movie);
        shopPriceMap.put(shop, price);
        TreeMap<Integer, TreeSet<Integer>> priceShopMap = moviePriceShopMap.get(movie);
        TreeSet<Integer> shopSet = priceShopMap.get(price);
        shopSet.add(shop);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int count = Math.min(LIMIT, set.size());
        List<Movie> movieList = new ArrayList<Movie>(set).subList(0, count);
        for (int i = 0; i < count; i++) {
            Movie movie = movieList.get(i);
            list.add(Arrays.asList(movie.shop, movie.id));
        }
        return list;
    }

    private long getKey(int shop, int movie) {
        return (long) movie * n + shop;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */