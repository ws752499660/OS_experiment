package experiment6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SCAN extends DiskManager {
    private int direction;  //0-正向；1-反向


    SCAN(List<Integer> trackNum) {
        super(trackNum);
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择扫描方向：0-正向；1-反向");
        direction=scanner.nextInt();
//        升序排列
        if(direction==0) {
            Collections.sort(trackNum);
        }
//        降序排列
        if(direction==1){
            Collections.sort(trackNum, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }
    }

    @Override
    void run() {
        int i=0;
        int pointer=initNum;
        for (; i<trackNum.size(); i++) {
            if ((direction==0 && trackNum.get(i)>initNum) ||
                    (direction==1 && trackNum.get(i)<initNum))
            {
                pathLength.add(Math.abs(pointer-trackNum.get(i)));
                pointer = trackNum.get(i);
                trackSeq.add(trackNum.get(i));
            }
        }
        for (i = trackNum.size()-trackSeq.size()-1; i>=0; i--) {
            pathLength.add(Math.abs(pointer-trackNum.get(i)));
            pointer = trackNum.get(i);
            trackSeq.add(trackNum.get(i));
        }
        printRes();
    }
}
