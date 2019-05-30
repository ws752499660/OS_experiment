package experiment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private List<Process> processList;
    private int n;
    private int m;
    private int[] available;
    private List<Process> actualList;

    public Manager(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入系统多少种资源");
        m=scanner.nextInt();
        available=new int[m];
        System.out.println("请输入不同资源的个数");
        for(int i=0;i<m;i++){
            available[i]=scanner.nextInt();
        }
        System.out.println("请输入有多少进程");
        n=scanner.nextInt();
        processList=new ArrayList<Process>();
        for(int i=0;i<n;i++){
            System.out.print("请输入进程"+(i)+"的allocation和need：");
            processList.add(new Process(m,"p"+i));
        }
        actualList=new ArrayList<Process>();
    }

    public void run(){
        int i=0;
        while (true){
            Process process=processList.get(i);
            if(isAMoreThanB(available,process.getNeed()) && !process.isFinish()){
                allocate(processList.get(i));
                i=0;
            }else {
                i++;
            }

            if(i>=n){
                if(isAlltrue()){
                    successToRunAll();
                }else {
                    failToRunAll();
                }
                return;
            }
        }

    }

    private boolean isAMoreThanB(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]<b[i])
                return false;
        }
        return true;
    }

    private void allocate(Process process){
        int[] ta=process.getAllocation();
        for(int i=0;i<m;i++){
            available[i]=available[i]+ta[i];
        }
        process.setFinish(true);
        actualList.add(process);
    }

    private void failToRunAll(){
        System.out.println("此队列不安全，已经执行的进程有：");
        for(int i=0;i<actualList.size();i++){
            System.out.print(actualList.get(i).getName()+" ");
        }
        System.out.println();
    }

    private void successToRunAll(){
        System.out.println("运行结束，已经执行的进程有：");
        for(int i=0;i<actualList.size();i++){
            System.out.print(actualList.get(i).getName()+" ");
        }
        System.out.println();
    }

    private boolean isAlltrue(){
        for (int i = 0; i <processList.size() ; i++) {
            if(!processList.get(i).isFinish())
                return false;
        }
        return true;
    }
}
