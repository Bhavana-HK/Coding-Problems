// Print the pattern 123123123.. using 3 threads

class Pattern {
    static Object monitor = new Object();

    static boolean one = true;
    static boolean two = false;
    static boolean three = false;

    static boolean exit = false;

    static class CutomRunnableImpl implements Runnable {
        int threadId;

        CutomRunnableImpl(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            print();
        }

        public void stop() {
            exit = true;
        }

        void print() {
            try {
                while (!exit) {
                    Thread.sleep(500);
                    synchronized (monitor) {
                        if (threadId == 1) {
                            if (!one)
                                monitor.wait();
                            System.out.print(1 + " ");
                            one = false;
                            two = true;
                            monitor.notifyAll();
                        }
                        if (threadId == 2) {
                            if (!two)
                                monitor.wait();
                            System.out.print(2 + " ");
                            two = false;
                            three = true;
                            monitor.notifyAll();
                        }
                        if (threadId == 3) {
                            if (!three)
                                monitor.wait();
                            System.out.print(3 + " ");
                            three = false;
                            one = true;
                            monitor.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Thread t1 = new Thread(new CutomRunnableImpl(1));
        Thread t2 = new Thread(new CutomRunnableImpl(2));
        Thread t3 = new Thread(new CutomRunnableImpl(3));

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(10000);
            t1.stop();
            t2.stop();
            t3.stop();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}