class DiningPhilosophers {
    private volatile Semaphore[] semaphores = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++)
            semaphores[i] = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;
        if (philosopher % 2 == 0) {
            semaphores[leftFork].acquire();
            semaphores[rightFork].acquire();
        } else {
            semaphores[rightFork].acquire();
            semaphores[leftFork].acquire();
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        semaphores[leftFork].release();
        semaphores[rightFork].release();
    }
}