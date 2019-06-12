package experiment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入要找寻的磁盘号");
        List<Integer> trackNum=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String trackNumStr=scanner.nextLine();
        for (String strt:trackNumStr.split(" ")){
            trackNum.add(Integer.parseInt(strt));
        }
        DiskManager manager=new SCAN(trackNum);
        manager.run();
    }
}
