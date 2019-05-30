package experiment5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    System.out.println("请选择你要选择的算法：");
	    System.out.println("1-FIFO,2-OPI,3-LRU");
        Scanner scanner=new Scanner(System.in);
        int w=scanner.nextInt();
        switch (w){
            case 1:{
                MemoryManager manager=new FIFO();
                manager.run();
                break;
            }
            case 2:{
                MemoryManager manager=new OPI();
                manager.run();
                break;
            }
            case 3:{
                MemoryManager manager=new LRU();
                manager.run();
                break;
            }
        }
    }
}