package experiment3;

public class HRRN {
    private ProcessList processList;
    private int time;
    private int flag;

    public HRRN(ProcessList processList){
        this.processList=processList;
        time=0;
        flag=0;
    }

    public void run(){
        while (flag<processList.getN()){
            processList.refleshAllPri(time);
            if(processList.list.get(0).getArrivalTime()<=time){
                processRun(processList.list.get(0));
            }
        }
        processList.endRun();
    }

    private void processRun(Process process){
        process.setFinishTime(time+process.getServiceTime());
        process.calculateNums();
        time=time+process.getServiceTime();
//        System.out.println(time+"时刻，"+process.getArrivalTime()+"进程运行");
        flag++;
    }

}
