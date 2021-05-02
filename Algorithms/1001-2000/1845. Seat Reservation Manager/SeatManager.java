class SeatManager {
    int n;
    int curr;
    TreeSet<Integer> set;

    public SeatManager(int n) {
        this.n = n;
        curr = 1;
        set = new TreeSet<Integer>();
    }
    
    public int reserve() {
        if (!set.isEmpty()) {
            int reserveSeat = set.first();
            set.remove(reserveSeat);
            return reserveSeat;
        } else {
            int reserveSeat = curr;
            curr++;
            return reserveSeat;
        }
    }
    
    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */