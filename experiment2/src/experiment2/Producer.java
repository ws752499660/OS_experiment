package experiment2;

public class Producer extends Thread {
    private Buffer buffer;
    private int num;

    public Producer(Buffer buffer,int num){
        this.buffer=buffer;
        this.num=num;
    }

    @Override
    public void run() {
        synchronized(buffer) {
            while (true) {
                buffer.notifyAll();
                while (buffer.isFull()){
                    try {
                        System.out.println("No."+num+" 生产者等待生产因为缓冲区已满");
                        buffer.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                buffer.bufferInput();
                try {
                    int time = (int) (1 + Math.random() * 10);
                    System.out.println("No."+num+" 生产者生产中并写入缓冲区，用时" + time + "s");
                    sleep(time*10);
                    buffer.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                buffer.notifyAll();
            }
        }

    }
}
