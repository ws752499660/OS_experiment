package experiment5;

public class FIFO extends MemoryManager {

    private void addToMem(){
        int addPage=pageSeq.get(seqPointer);
        if(!memory.add(addPage) && !memory.isExist(addPage)){
            memory.removeByIndex(0);
            memory.add(addPage);
            leakTimes++;
        }
    }

    @Override
    public void run(){
        while (seqPointer<pageSeq.size()){
            addToMem();
            seqPointer++;
//            memory.logStates();
        }
        printRes();
    }
}
