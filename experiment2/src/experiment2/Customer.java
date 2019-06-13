package experiment2;

public class Customer extends Thread {
    private Buffer buffer;
    private int num;

    public Customer(Buffer buffer,int num){
        this.buffer=buffer;
        this.num=num;
    }

    @Override
    public void run() {
        synchronized (buffer){
            while (true){
                buffer.notifyAll();
                while (buffer.isEmpty()){
                    try {
                        System.out.println("No."+num+" 消费者等待消费因为缓冲区为空");
                        buffer.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                buffer.bufferOutput();
                try {
                    int time=(int)(1+Math.random()*10);
                    System.out.println("No."+num+" 消费者消费中并读出缓冲区，用时"+time+"s");
                    sleep(time*10);
                    buffer.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
                buffer.notifyAll();
            }
        }
    }
}
