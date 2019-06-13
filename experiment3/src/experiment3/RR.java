package experiment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RR {
    private ProcessList processList;
    private List<Process> waitingList;
    private int flag;
    private int index;
    private int time;
    private int q;
    private int qFlag;

    public RR(ProcessList processList){
        this.waitingList=new ArrayList<Process>();
        this.processList=processList;
        this.time=0;
        this.flag=0;
        this.index=0;
        this.qFlag=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入RR的时间片大小q：");
        this.q=scanner.nextInt();
    }

    public void run(){
        while(flag<processList.getN()){
            putToWaiting();
            time++;
            doProcess(waitingList.get(0));
        }
        processList.endRun();
    }

    private void putToWaiting(){
        if(index<processList.getN()) {
            if (processList.list.get(index).getArrivalTime() >= time) {
                waitingList.add(processList.list.get(index));
                index++;
            }
        }
    }

    private void doProcess(Process process){
        int leftTime=process.doOneSec();
        qFlag++;
        if(leftTime>0) {
            if (qFlag == q) {
                removeToEnd(process);
                qFlag=0;
            }
//            System.out.println("进程"+process.getArrivalTime()+"正在运行");
        }
        else if(leftTime==0) {
            process.setFinishTime(time);
            waitingList.remove(0);
            flag++;
            qFlag=0;
//            System.out.println("进程"+process.getArrivalTime()+"运行结束");
        }
    }

    private void removeToEnd(Process process){
        if(index<processList.getN()) {
            if (processList.list.get(index).getArrivalTime() == time) {
                putToWaiting();
            }
        }
        waitingList.remove(0);
        waitingList.add(process);
    }
}
