package experiment3;

public class Process{
    private int arrivalTime;
    private int serviceTime;
    private int leftTime;
    private int finishTime;
    private int wholeTime;
    private double weightWT;

    public Process(){
        arrivalTime=0;
        serviceTime=0;
        leftTime=serviceTime;
        finishTime=-1;
        wholeTime=-1;
        weightWT=0;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
        this.leftTime=serviceTime;
    }

    public int doOneSec(){
        leftTime--;
        return leftTime;
    }

//    public int getAndComputeLeftTime(int q){
//        if(leftTime-q>=0)
//        {
//            leftTime=leftTime-q;
//            return leftTime;
//        }
//        else
//        {
//            leftTime=0;
//            return leftTime-q;
//        }
//    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void calculateNums(){
        wholeTime=finishTime-arrivalTime;
        weightWT=wholeTime/serviceTime;
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
}
