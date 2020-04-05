class TrafficLight {
    private Semaphore semaphore;
    private boolean road1;
    private boolean road2;

    public TrafficLight() {
        semaphore = new Semaphore(1, true);
        road1 = true;
        road2 = false;
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        try {
            semaphore.acquire();
            if (roadId == 1 && road1 || roadId == 2 && road2)
                crossCar.run();
            else if (roadId == 1 && !road1) {
                turnGreen.run();
                road1 = true;
                road2 = false;
                crossCar.run();
            } else if (roadId == 2 && !road2) {
                turnGreen.run();
                road2 = true;
                road1 = false;
                crossCar.run();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}