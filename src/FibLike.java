import java.util.ArrayList;

public class FibLike implements Runnable {

    private int amountField;
    private int num1Field;
    private int num2Field;
    private ArrayList sequence = new ArrayList();
    private boolean done;

    public FibLike(int amount, int num1, int num2) {
        this.amountField = amount;
        this.num1Field = num1;
        this.num2Field = num2;
        done = false;
    }

    public int getAmountField() {
        return amountField;
    }

    public void setAmountField(int amountField) {
        this.amountField = amountField;
    }

    public int getNum1Field() {
        return num1Field;
    }

    public void setNum1Field(int num1Field) {
        this.num1Field = num1Field;
    }

    public int getNum2Field() {
        return num2Field;
    }

    public void setNum2Field(int num2Field) {
        this.num2Field = num2Field;
    }

    public ArrayList getSequence() {
        return sequence;
    }

    public void setSequence(ArrayList sequence) {
        this.sequence = sequence;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void print() {
        System.out.println("Sequence with " + amountField + " numbers starting at " + num1Field + ", " + num2Field + ": ");
        for (Object eachNumber: sequence) {
            System.out.println(eachNumber);
        }
        System.out.println("");
    }

    synchronized void theRealFib(int amount, int num1, int num2) {
        if (amount == 0) {
            // DO NOTHING
            return;
        }

        if (amount == 1) {
            //System.out.println(num1);
            sequence.add(num1);
            done = true;
            return;
        }

        if (amount > 1) {
            //System.out.println("Sequence with " + amountField + " numbers starting at " + num1Field + "," + num2Field + ": " + num1);
            sequence.add(num1);
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            int newNum = num1 + num2;
            theRealFib(amount-1 , num2, newNum);
        }
    }

    public void run() {
        // use the fields ONCE: to pass the original 3 numbers to theRealFib
        theRealFib(amountField, num1Field, num2Field);
        if (true) {
            print();
        }
    }
}
