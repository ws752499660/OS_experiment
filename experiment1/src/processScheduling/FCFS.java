package processScheduling;

public class FCFS {
    private int curTime;
    private ProcessesArray processesArray;

    FCFS(ProcessesArray processesArray){
        curTime=0;
        this.processesArray=processesArray;
    }

    public void run(){
        int i=0;
        while (i<processesArray.getNum()) {
            if (processesArray.getProcesses()[i].getArrivalTime() <= curTime) {
                doThisProcess(processesArray.getProcesses()[i]);
                i++;
            } else {
                curTime++;
            }
        }
    }

    private void doThisProcess(Process process){
        curTime=curTime+process.getServiceTime();
        process.setFinishTime(curTime);
        process.setWholeTime(process.getFinishTime()-process.getArrivalTime());
        process.setWeightWholeTime((double)process.getWholeTime()/(double)process.getServiceTime());
    }

}
