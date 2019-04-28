package processScheduling;

public class run {
    public static void main(String[] args) {
        ProcessesArray processesArray=new ProcessesArray();
        if(processesArray.getMethod()==1) {
            FCFS fcfs=new FCFS(processesArray);
            fcfs.run();
        }else if(processesArray.getMethod()==2){
            SJF sjf=new SJF(processesArray);
            sjf.run();
        }
        processesArray.outputRes();
    }
}
