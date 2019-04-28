package processScheduling;

import java.util.ArrayList;
import java.util.Collections;

public class SJF {
    private int curTime;
    private ProcessesArray processesArray;
    private ArrayList<Process> waitProcesses;
    private int getInwaitCount;

    SJF(ProcessesArray processesArray){
        curTime=0;
        this.processesArray=processesArray;
        waitProcesses=new ArrayList<>();
        getInwaitCount=0;
    }

    public void run(){
        int times=0;
        while(times<processesArray.getNum()){
            if(getInwaitCount<processesArray.getNum())
                processWait(times);
            if(!waitProcesses.isEmpty()){
                doProcess();
                times++;
            }
            else
                curTime++;
        }
    }

    private void processWait(int times) {
        if (waitProcesses.isEmpty()) {
            for (int i = times; i < processesArray.getNum(); i++) {
                if (processesArray.getProcesses()[i].getArrivalTime() <= curTime) {
                    waitProcesses.add(processesArray.getProcesses()[i]);
                    getInwaitCount++;
                }
            }
        } else {
            for (int i = times; i < processesArray.getNum(); i++) {
                if (processesArray.getProcesses()[i].getArrivalTime() <= curTime && processesArray.getProcesses()[i].getArrivalTime() > latestArrivalTime()) {
                    waitProcesses.add(processesArray.getProcesses()[i]);
                    getInwaitCount++;
                }
            }
        }
        Collections.sort(waitProcesses);
    }

    private void doProcess(){
        Process process=waitProcesses.get(0);
        curTime=curTime+process.getServiceTime();
        process.setFinishTime(curTime);
        process.setWholeTime(process.getFinishTime()-process.getArrivalTime());
        process.setWeightWholeTime((double)process.getWholeTime()/(double)process.getServiceTime());
        waitProcesses.remove(0);
    }

    private int latestArrivalTime(){
        int max=waitProcesses.get(0).getArrivalTime();
        for(int i=1;i<waitProcesses.size();i++){
            if(waitProcesses.get(i).getArrivalTime()>max)
                max=waitProcesses.get(i).getArrivalTime();
        }
        return max;
    }
}
