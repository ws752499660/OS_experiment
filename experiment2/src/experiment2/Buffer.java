package experiment2;

public class Buffer {
    static final private int n=16;
    private int left;
    private boolean empty;  //是否为空
    private boolean full;   //是否为满

    public Buffer(){
        left=n;
        empty=true;
        full=false;
    }

    private void statusFlesher(){
        if(left==0) {
            full = true;
            empty= false;
        }
        if(left==n){
            full=false;
            empty=true;
        }
        if(left>0 && left<n){
            full=false;
            empty=false;
        }
    }

    public boolean bufferInput(){
        if(full)
            return false;
        left=left-1;
        this.statusFlesher();
        return true;
    }

    public boolean bufferOutput(){
        if(empty)
            return false;
        left=left+1;
        this.statusFlesher();
        return true;
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isFull(){
        return full;
    }
}
