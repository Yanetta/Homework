package multuthreadingAndBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Synchronized and volatile examples");

        Account account = new Account(100, 100, new String[]{"Petrov", "Ivan", "Sydorovych"});
        System.out.println("Initial dollar balance = " + account.getDollarBalance());
        System.out.println("Initial hryvnya balance = " + account.getHryvnyaBalance());


        Runnable withdrawObj = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Dollar balance before withdrawal = " + account.getDollarBalance());
                    account.withdrawDollars(10);
                    System.out.println("Dollar balance after withdrawal = " + account.getDollarBalance());
                }
            }
        };

        Runnable depositObj = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Dollar balance before deposit = " + account.getDollarBalance());
                    account.depositDollars(10);
                    System.out.println("Dollar balance after deposit = " + account.getDollarBalance());
                }
            }
        };
        Runnable withdrawObj2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hryvnya balance after withdrawal = " + account.getHryvnyaBalance());
                    account.withdrawHryvhya(10);
                    System.out.println("Hryvnya balance after withdrawal = " + account.getHryvnyaBalance());

                }
            }
        };

        Runnable depositObj2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hryvnya balance before deposit = " + account.getHryvnyaBalance());
                    account.depositHryvhya(10);
                    System.out.println("Hryvnya balance after deposit = " + account.getHryvnyaBalance());
                }
            }
        };
        Thread depositThread = new Thread(depositObj);
        Thread withdrawalThread = new Thread(withdrawObj);


        Thread depositThread2 = new Thread(depositObj2);
        Thread withdrawalThread2 = new Thread(withdrawObj2);

        depositThread.start();
        withdrawalThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        depositThread2.start();
        withdrawalThread2.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BlockingQueue examples");
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(10);

        Producer producer = new Producer(bq);
        Consumer consumer = new Consumer(bq);

        new Thread(producer).start();
        new Thread(consumer).start();
        
        InterestPayment interestPayment = new InterestPayment(account);
        InterestInfo interestInfo = new InterestInfo(account);

        new Thread(interestPayment).start();
        new Thread(interestInfo).start();
    }
}
class InterestPayment implements Runnable {
    private Account account;

    public InterestPayment(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            for (int i = 0; i < 5; i++) {

                long interest = account.getDollarBalance() * 20 / 100;
                System.out.println("interest is " + interest);
                account.setDollarBalance(interest + account.getDollarBalance());
                System.out.println(account.getDollarBalance());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class InterestInfo implements Runnable {
    private Account account;

    public InterestInfo(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {

            System.out.println("You received interest and your dollar balance is: " + account.getDollarBalance());
        }

    }
}



