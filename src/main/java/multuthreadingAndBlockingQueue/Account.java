package multuthreadingAndBlockingQueue;

public class Account {
    private String[] nameOfClient;
    private long dollarBalance;
    private volatile long hryvnyaBalance;

    public Account(long dollarBalance, long hryvnyaBalance, String[] nameOfClient) {
        this.nameOfClient = nameOfClient;
        this.dollarBalance = dollarBalance;
        this.hryvnyaBalance = hryvnyaBalance;
    }

    public long getDollarBalance() {
        return dollarBalance;
    }

    public void setDollarBalance(long dollarBalance) {
        this.dollarBalance = dollarBalance;
    }

    public long getHryvnyaBalance() {
        return hryvnyaBalance;
    }

    public void setHryvnyaBalance(long hryvnyaBalance) {
        this.hryvnyaBalance = hryvnyaBalance;
    }


    public synchronized void depositDollars(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        } else {
            dollarBalance += amount;
        }
    }

    public void withdrawDollars(long amount) {
        synchronized (this) {
            if (amount < 0) {
                throw new IllegalArgumentException("negative amount");
            } else if (dollarBalance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            dollarBalance -= amount;
        }
    }

    public void depositHryvhya(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        } else {
            hryvnyaBalance += amount;
        }
    }

    public void withdrawHryvhya(long amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        } else if (hryvnyaBalance < amount) {
            throw new IllegalArgumentException("not enough money");
        }
        hryvnyaBalance -= amount;
    }
}
