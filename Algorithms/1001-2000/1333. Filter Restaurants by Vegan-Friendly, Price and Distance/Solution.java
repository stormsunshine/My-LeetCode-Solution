class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> restaurantsList = new ArrayList<int[]>();
        for (int[] restaurant : restaurants) {
            if ((veganFriendly == 0 || restaurant[2] == 1) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                restaurantsList.add(restaurant);
        }
        Collections.sort(restaurantsList, new Comparator<int[]>() {
            public int compare(int[] restaurant1, int[] restaurant2) {
                if (restaurant1[1] != restaurant2[1])
                    return restaurant2[1] - restaurant1[1];
                else
                    return restaurant2[0] - restaurant1[0];
            }
        });
        List<Integer> restaurantsIDsList = new ArrayList<Integer>();
        int size = restaurantsList.size();
        for (int i = 0; i < size; i++)
            restaurantsIDsList.add(restaurantsList.get(i)[0]);
        return restaurantsIDsList;
    }
}