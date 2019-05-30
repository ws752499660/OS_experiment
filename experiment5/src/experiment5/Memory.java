package experiment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Memory {
    private int blockNum;
    private List<Integer> blockList;

    public Memory(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入内存的块数:");
        blockNum=scanner.nextInt();
        blockList=new ArrayList<Integer>();
    }

    void logStates(){
        for (int i = 0; i < blockList.size(); i++) {
            System.out.print(blockList.get(i)+" ");
        }
        System.out.println();
    }

    boolean isFull(){
        if(blockList.size()<blockNum){
            return false;
        }else {
            return true;
        }
    }

    boolean add(int page){
        if(!isFull()){
            blockList.add(page);
            return true;
        }else
            return false;
    }

    boolean removeByIndex(int index){
        if(blockList.size()==0)
            return false;
        else {
            blockList.remove(index);
            return true;
        }
    }

    boolean removeByValue(Integer page){
        if(blockList.size()==0)
            return false;
        else {
            blockList.remove(page);
            return true;
        }
    }

    boolean isExist(int page){
        if(blockList.indexOf(page)==-1){
            return false;
        }else {
            return true;
        }
    }

    int getBlockNum() {
        return blockNum;
    }

    List<Integer> getBlockList() {
        return blockList;
    }
}
