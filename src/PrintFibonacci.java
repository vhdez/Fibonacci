public class PrintFibonacci implements Runnable {
    FibLike fib1;
    boolean fib1Printed;
    FibLike fib2;
    boolean fib2Printed;

    public PrintFibonacci(FibLike fib1, FibLike fib2) {
        this.fib1 = fib1;
        fib1Printed = false;
        this.fib2 = fib2;
        fib2Printed = false;
    }

    public void run() {
        while (!fib1Printed || !fib2Printed) {
            if (!fib1Printed && fib1.isDone()) {
                fib1.print();
                fib1Printed = true;
            }
            if (!fib2Printed && fib2.isDone()) {
                fib2.print();
                fib2Printed = true;
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
