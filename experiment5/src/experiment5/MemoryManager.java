package experiment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MemoryManager {
    Memory memory;
    int leakTimes;
    double leakRate;
    List<Integer> pageSeq;
    int seqPointer;

    public MemoryManager(){
        memory=new Memory();
        pageSeq=new ArrayList<Integer>();
        seqPointer=0;
        leakTimes=0;
        leakRate=0.0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入页面访问序列:");
        strTopageSeq(scanner.nextLine());
    }

    private void strTopageSeq(String str){
        for(String strA:str.split(" ")){
            pageSeq.add(Integer.parseInt(strA));
        }
    }

    private void calLeakRate(){
        leakTimes=leakTimes+memory.getBlockNum();
        leakRate=(double) leakTimes/pageSeq.size();
    }

    private void outputRes(){
        System.out.println("缺页次数为"+leakTimes);
        System.out.println("缺页率为"+String.format("%.2f",leakRate));
    }

    void printRes(){
        calLeakRate();
        outputRes();
    }

    public void run(){}
}
