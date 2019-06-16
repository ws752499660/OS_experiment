package experiment5;

import java.util.List;

public class LRU extends MemoryManager {
    private void addToMem(){
        int addPage=pageSeq.get(seqPointer);
        if(!memory.add(addPage) && !memory.isExist(addPage)) {
            memory.removeByValue(mostShouldRemove());
            memory.add(addPage);
            leakTimes++;
        }
    }

    private int mostShouldRemove(){
        int i=0;
        int[] temparray=new int[memory.getBlockNum()];
        for(;i<temparray.length;i++){
            temparray[i]=memory.getBlockList().get(i);
        }
        int getOutPage=temparray[0];
        for(i=1;i<temparray.length;i++){
            if(getAheadDisOfPage(getOutPage)<getAheadDisOfPage(temparray[i])){
                getOutPage=temparray[i];
            }
        }
        return getOutPage;
    }

    private int getAheadDisOfPage(int page) {
        List<Integer> tempList = pageSeq.subList(0, seqPointer);
        if (tempList.lastIndexOf(page) == -1) {
            return seqPointer;
        } else {
            return seqPointer-tempList.lastIndexOf(page);
        }
    }

    @Override
    public void run() {
        while (seqPointer<pageSeq.size()){
            addToMem();
            seqPointer++;
            memory.logStates();
        }
        printRes();
    }
}
