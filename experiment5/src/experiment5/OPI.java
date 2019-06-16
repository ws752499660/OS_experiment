package experiment5;

import java.util.List;

public class OPI extends MemoryManager{

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
            if(getBehindDisOfPage(getOutPage)<getBehindDisOfPage(temparray[i])){
                getOutPage=temparray[i];
            }
        }
        return getOutPage;
    }

    private int getBehindDisOfPage(int page) {
        List<Integer> tempList = pageSeq.subList(seqPointer, pageSeq.size());
        if (tempList.indexOf(page) == -1) {
            return pageSeq.size() - seqPointer;
        } else {
            return tempList.indexOf(page);
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
