package experiment3;

import java.util.*;

public class ProcessList {
    List<Process> list;
    private int n;
    private double averageWT;
    private double averageWWT;

    public ProcessList(){
        list=new ArrayList<Process>();
        averageWT=0;
        averageWWT=0;
        System.out.println("请输入n：");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        this.InitList();
    }

    public int getN() {
        return n;
    }

    public void InitList(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入到达时间：");
        for(int i=0;i<n;i++){
            Process process=new Process();
            process.setArrivalTime(scanner.nextInt());
            list.add(process);
        }
        System.out.println("请输入服务时间：");
        for(int i=0;i<n;i++){
            list.get(i).setServiceTime(scanner.nextInt());
        }
        Collections.sort(this.list, new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return o1.getArrivalTime()-o2.getArrivalTime();
            }
        });
    }

    public void endRun(){
        for(int i=0;i<n;i++){
            list.get(i).calculateNums();
            averageWT=list.get(i).getWholeTime()+averageWT;
            averageWWT=list.get(i).getWeightWT()+averageWWT;
        }
        averageWT=averageWT/n;
        averageWWT=averageWWT/n;
        Collections.sort(this.list, new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return o1.getArrivalTime()-o2.getArrivalTime();
            }
        });
        System.out.println("完成时间为：");
        for (int i=0;i<n;i++){
            System.out.print(list.get(i).getFinishTime()+" ");
        }
        System.out.println();
        System.out.println("周转时间为：");
        for (int i=0;i<n;i++){
            System.out.print(list.get(i).getWholeTime()+" ");
        }
        System.out.println();
        System.out.println("带权周转时间为：");
        for (int i=0;i<n;i++){
            System.out.print(list.get(i).getWeightWT()+" ");
        }
        System.out.println();
        System.out.println("平均周转时间为："+averageWT);
        System.out.println("平均带权周转时间为："+averageWWT);
    }

    public void refleshAllPri(int time){
        for(int i=0;i<n;i++){
            list.get(i).calculatePri(time);
        }
        Collections.sort(this.list, new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return (int)(o2.getPriority()-o1.getPriority());
            }
        });
    }
}
