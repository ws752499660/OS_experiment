package experiment3;

import java.util.Scanner;

public class Process {
    private int[] allocation;
    private int[] need;
    private String name;
    private boolean isFinish;

    public Process(int m,String name) {
        Scanner scanner=new Scanner(System.in);
        allocation=new int[m];
        need=new int[m];
        for(int i=0;i<m;i++){
            allocation[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            need[i]=scanner.nextInt();
        }
        this.name=name;
        this.isFinish = false;
    }

    public String getName() {
        return name;
    }

    public int[] getAllocation() {
        return allocation;
    }

    public void setAllocation(int[] allocation) {
        this.allocation = allocation;
    }

    public int[] getNeed() {
        return need;
    }

    public void setNeed(int[] need) {
        this.need = need;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}
