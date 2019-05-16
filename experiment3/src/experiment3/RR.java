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
        this.qFlag=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入RR的时间片大小q：");
        this.q=scanner.nextInt();
    }

    public void run(){
        while(flag<processList.getN()){
            if(index<processList.getN()) {
                if (processList.list.get(index).getArrivalTime() >= time) {
                    putToWaiting(processList.list.get(index));
                    index++;
                }
            }
            doProcess(waitingList.get(0));
            time++;
        }
        processList.endRun();
    }

    private void putToWaiting(Process process){
        waitingList.add(process);
    }

    private void doProcess(Process process){
        if(time==0)
            return;
        qFlag++;
        if(process.doOneSec()>0) {
            if (time % q == 0) {
                waitingList.remove(0);
                waitingList.add(process);
            }
            System.out.println("正在执行进程"+process.getArrivalTime());
        }
        else if(process.doOneSec()==0) {
            process.setFinishTime(time);
            waitingList.remove(0);
            flag++;
            qFlag=1;
            System.out.println("进程"+process.getArrivalTime()+"运行结束");
        }
        if(qFlag==2)
            qFlag=1;
    }

//    private void doProcess(Process process){
//        if(time%q==0 && time!=0) {
//            int leftTime = process.getAndComputeLeftTime(q);
//            if (leftTime == 0) {
//                waitingList.remove(0);
//                flag++;
//                process.setFinishTime(time);
//            } else if (leftTime < 0) {
//                time = time + leftTime;
//                waitingList.remove(0);
//                process.setFinishTime(time);
//                flag++;
//            } else {
//                waitingList.add(process);
//                waitingList.remove(0);
//            }
//        }
//        time++;
//    }



}
