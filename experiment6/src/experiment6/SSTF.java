package experiment6;

import java.util.List;

public class SSTF extends DiskManager{
    private int pointer;

    SSTF(List<Integer> trackNum) {
        super(trackNum);
        pointer=initNum;
    }

    @Override
    void run() {
        int times=trackNum.size();
        for(int i=0;i<times;i++){
            int miniIndex=findNextTrackIndex();
            int track= trackNum.get(miniIndex);
            pathLength.add(Math.abs(pointer-track));
            pointer=track;
            trackSeq.add(trackNum.get(miniIndex));
            trackNum.remove(miniIndex);
        }
        printRes();
    }

    private int findNextTrackIndex(){
        int min=Math.abs(pointer-trackNum.get(0));
        int miniIndex=0;
        for(int i = 0; i<trackNum.size(); i++){
            int temp=Math.abs(pointer-trackNum.get(i));
            if(temp<min) {
                min=temp;
                miniIndex=i;
            }
        }
        return miniIndex;
    }
}
