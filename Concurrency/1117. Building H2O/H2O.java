class H2O {
    private Semaphore semaphoreHydrogen = new Semaphore(2);
    private Semaphore semaphoreOxygen = new Semaphore(0);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		semaphoreHydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphoreOxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreOxygen.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        semaphoreHydrogen.release(2);
    }
}