package experiment3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	ProcessList processList=new ProcessList();
    	System.out.println("选择算法:");
    	System.out.println("1-RR");
    	System.out.println("2-HRRN");
		Scanner scanner=new Scanner(System.in);
		if(scanner.nextInt()==1) {
			RR rr=new RR(processList);
			rr.run();
		}
		else {
			HRRN hrrn=new HRRN(processList);
			hrrn.run();
		}
    }
}
