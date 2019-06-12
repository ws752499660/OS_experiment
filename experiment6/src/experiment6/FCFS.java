package experiment6;

import java.util.List;

public class FCFS extends DiskManager{

    FCFS(List<Integer> trackNum) {
        super(trackNum);
    }

    @Override
    public void run(){
        pathLength.add(Math.abs(initNum-trackNum.get(0)));
        for(int i=0;i<trackNum.size()-1;i++){
            pathLength.add(Math.abs(trackNum.get(i+1)-trackNum.get(i)));
            trackSeq.add(trackNum.get(i));
        }
        trackSeq.add(trackNum.get(trackNum.size()-1));
        printRes();
    }

}
