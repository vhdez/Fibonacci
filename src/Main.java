import javax.swing.plaf.basic.BasicBorders;

public class Main {
    public static void main(String[] args) {

        System.out.println("The fibonacci sequences:");

        FibLike fib1 = new FibLike(10, 2, 4);
        FibLike fib2 = new FibLike(5, -3, 1);

        // sequential version
        if (true) {
            fib1.run();
            fib2.run();
        }

        // multi-threaded/concurrent version
        if (false) {
            Thread thread1 = new Thread(fib1);
            thread1.start();

            Thread thread2 = new Thread(fib2);
            thread2.start();

            if (false) {
                PrintFibonacci printer = new PrintFibonacci(fib1, fib2);
                Thread printingThread = new Thread(printer);
                printingThread.start();
            }
        }
    }
}