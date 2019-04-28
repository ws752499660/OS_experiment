package processScheduling;

public class Process implements Comparable<Process> {
    private int arrivalTime;
    private int serviceTime;
    private int finishTime;
    private int wholeTime;
    private double weightWholeTime;

//    接口实现详见：https://blog.csdn.net/qq_23179075/article/details/78753136

    public int compareTo(Process p){
        return this.serviceTime-p.serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getWholeTime() {
        return wholeTime;
    }

    public void setWholeTime(int wholeTime) {
        this.wholeTime = wholeTime;
    }

    public double getWeightWholeTime() {
        return weightWholeTime;
    }

    public void setWeightWholeTime(double weightWholeTime) {
        this.weightWholeTime = weightWholeTime;
    }
}
