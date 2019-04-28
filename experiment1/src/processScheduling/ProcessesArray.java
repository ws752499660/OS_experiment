package processScheduling;

import java.util.Scanner;

public class ProcessesArray {
    private Process[] processes;
    private int num;
    private double averageWT_FCFS,averageWT_SJF;
    private double averageWWT_FCFS,averageWWT_SJF;
    private int method;

    ProcessesArray(){
        num=0;
        method=0;
        inputNum();
        processes=new Process[num];
        for(int i=0;i<num;i++)
            processes[i]=new Process();
        inputArrivalTime();
        inputServiceTime();
        choseMethod();
    }

    private void inputNum(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入进程总数n");
        num=scanner.nextInt();
    }

    private void inputArrivalTime(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入进程各自的到达时间");
        for(int i=0;i<num;i++){
            processes[i].setArrivalTime(scanner.nextInt());
        }
    }

    private void inputServiceTime(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入进程各自的服务时间");
        for(int i=0;i<num;i++){
            processes[i].setServiceTime(scanner.nextInt());
        }
    }

    private void choseMethod(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择模式：1-FCFS;2-SJF");
        method=scanner.nextInt();
    }

    public Process[] getProcesses() {
        return processes;
    }

    public int getNum() {
        return num;
    }

    public int getMethod() {
        return method;
    }

    public void calculateAve(){
        double averageWT=0;
        for (int i = 0; i < num; i++) {
            averageWT = processes[i].getWholeTime() + averageWT;
        }
        averageWT=averageWT/num;
        double averageWWT=0;
        for(int i=0;i<num;i++){
            averageWWT=processes[i].getWeightWholeTime()+averageWWT;
        }
        averageWWT=averageWWT/num;
        if(method==1) {
            averageWT_FCFS = averageWT;
            averageWWT_FCFS=averageWWT;
        }
        if(method==2){
            averageWT_SJF=averageWT;
            averageWWT_SJF=averageWWT;
        }
    }

    public void outputRes(){
        calculateAve();
        System.out.println("终止时间:");
        for(int i=0;i<num;i++){
            System.out.print(processes[i].getFinishTime()+"   ");
        }
        System.out.println();
        System.out.println("周转时间:");
        for(int i=0;i<num;i++){
            System.out.print(processes[i].getWholeTime()+"   ");
        }
        System.out.println();
        System.out.println("带权周转时间:");
        for(int i=0;i<num;i++){
            System.out.print(processes[i].getWeightWholeTime()+"   ");
        }
        System.out.println();
        if(method==1) {
            System.out.println("平均周转时间:" +averageWT_FCFS);
            System.out.println("平均带权周转时间:"+averageWWT_FCFS);
        }
        if(method==2){
            System.out.println("平均周转时间:" +averageWT_SJF);
            System.out.println("平均带权周转时间:"+averageWWT_SJF);
        }
    }
}
