package experiment2;

public class Main {

    public static void main(String[] args) {
        Buffer buffer=new Buffer();
        Thread producer1=new Producer(buffer,1);
        Thread producer2=new Producer(buffer,2);
        Thread producer3=new Producer(buffer,3);
        Thread producer4=new Producer(buffer,4);
        Thread customer1=new Customer(buffer,1);
        Thread customer2=new Customer(buffer,2);
        Thread customer3=new Customer(buffer,3);
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        customer1.start();
        customer2.start();
        customer3.start();
    }
}
