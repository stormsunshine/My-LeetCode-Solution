class UndergroundSystem {
    Map<Integer, String> customerTripMap;
    Map<String, List<Integer>> tripsMap;

    public UndergroundSystem() {
        customerTripMap = new HashMap<Integer, String>();
        tripsMap = new HashMap<String, List<Integer>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        String value = stationName + ", " + t;
        customerTripMap.put(id, value);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String prevValue = customerTripMap.get(id);
        String[] array = prevValue.split(", ");
        String startStation = array[0];
        int startTime = Integer.parseInt(array[1]);
        String trip = startStation + ", " + stationName;
        int duration = t - startTime;
        List<Integer> list = tripsMap.getOrDefault(trip, new ArrayList<Integer>());
        list.add(duration);
        tripsMap.put(trip, list);
        customerTripMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String trip = startStation + ", " + endStation;
        List<Integer> list = tripsMap.getOrDefault(trip, new ArrayList<Integer>());
        if (list.size() == 0)
            return 0;
        int size = list.size();
        double sum = 0;
        for (int time : list)
            sum += time;
        return sum / size;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */