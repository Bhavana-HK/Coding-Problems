class Pattern010203 {
    // Print the pattern 01020304.. using 2 threads
    static Object monitor = new Object();

    static boolean first = true;
    static boolean second = false;

    static class CustomRunnableImpl implements Runnable {
        int threadId;

        CustomRunnableImpl(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            int num=1;
            try {
                synchronized (monitor) {
                    while (true) {
                        if (threadId == 1)
                            printZeros();
                        else if (threadId == 2)
                            printInts(num++);
                    }
                }
            } catch (InterruptedException e) {
                System.out.print("Exception occured" + e.getMessage());
            }
        }

        void printZeros() throws InterruptedException{
            Thread.sleep(400);
            if (!first)
                monitor.wait();
            System.out.print(0 + " ");
            first = false;
            second = true;
            monitor.notifyAll();
        }

        void printInts(int num) throws InterruptedException{
            Thread.sleep(400);
            if (!second)
                monitor.wait();
            System.out.print(num + " ");
            first = true;
            second = false;
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new CustomRunnableImpl(1));
        Thread t2 = new Thread(new CustomRunnableImpl(2));
        t1.start();
        t2.start();
    }
}