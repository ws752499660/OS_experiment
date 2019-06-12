package experiment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class DiskManager {
    List<Integer> trackNum;
    List<Integer> pathLength;
    List<Integer> trackSeq;
    int initNum;
    private double avePathLength;

    DiskManager(List<Integer> trackNum){
        System.out.println("请输入初始磁盘号");
        Scanner scanner=new Scanner(System.in);
        initNum=scanner.nextInt();
        this.trackNum=trackNum;
        pathLength=new ArrayList<>();
        trackSeq=new ArrayList<>();
        avePathLength=0;
    }

    void run(){}

    private void culAvePathLength(){
        for (int t:pathLength) {
            avePathLength=avePathLength+t;
        }
        avePathLength=avePathLength/pathLength.size();
    }

    void printRes(){
        culAvePathLength();
        System.out.println("下一个磁道号"+"   "+"寻道长度");
        for(int i=0;i<trackSeq.size();i++){
            System.out.println(trackSeq.get(i)+"            "+pathLength.get(i));
        }
        System.out.println("平均寻道长度为："+avePathLength);
    }
}
