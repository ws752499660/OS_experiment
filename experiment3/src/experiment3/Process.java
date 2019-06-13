package experiment3;

public class Process{
    private int arrivalTime;
    private int serviceTime;
    private int leftTime;
    private int finishTime;
    private int wholeTime;
    private double weightWT;
    private double priority;

    public Process(){
        arrivalTime=0;
        serviceTime=0;
        leftTime=serviceTime;
        finishTime=-1;
        wholeTime=-1;
        weightWT=0;
        priority=1;
    }

    public int doOneSec(){
        leftTime--;
        return leftTime;
    }

    public void calculateNums(){
        wholeTime=finishTime-arrivalTime;
        weightWT=(double)wholeTime/serviceTime;
    }

    public void calculatePri(int time){
        if(finishTime>0) {
            priority=1; //以及执行过的将响应比设为1
            return;
        }
        if(time>=arrivalTime)
            priority=1+(double) (time-arrivalTime)/serviceTime; //将响应比人为加1确保未执行的响应比始终比执行过的大
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
        this.leftTime=serviceTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public double getPriority() {
        return priority;
    }

    public int getLeftTime() {
        return leftTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getWholeTime() {
        return wholeTime;
    }

    public double getWeightWT() {
        return weightWT;
    }

    public int getServiceTime() {
        return serviceTime;
    }
}
