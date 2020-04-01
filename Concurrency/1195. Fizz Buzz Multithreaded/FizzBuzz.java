class FizzBuzz {
    private int n;
    private volatile int i;
    private Semaphore semaphore;

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
        semaphore = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            semaphore.acquire();
            try {
                if (i > n)
                    break;
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            semaphore.acquire();
            try {
                if (i > n)
                    break;
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            semaphore.acquire();
            try {
                if (i > n)
                    break;
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            semaphore.acquire();
            try {
                if (i > n)
                    break;
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                }
            } finally {
                semaphore.release();
            }
        }
    }
}