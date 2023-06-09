import java.util.*;
//FCFS disk

public class Q18 {
    public static void main(String[] args) {

        int[] requestQueue = new int[] { 90, 120, 30, 40, 115, 130, 110, 80, 190, 25 };
        int globalCurrentHead = 86;

        int queueLength = requestQueue.length;
        int[] orderOfProcessing = new int[queueLength];
        int totalHeadMovement = 0;
        Scanner s = new Scanner(System.in);

        int currentHead = globalCurrentHead;
        
        System.out.println();
        System.out.println("\t\t+--------------------------------------+");
        System.out.println("\t\t|Output for FCFS Disk Scheduling Policy|");
        System.out.println("\t\t+--------------------------------------+");
        System.out.println("\n\tHead currently at: " + currentHead);
        
        System.out.println("\n     Iteration \t Current Head \t Disk Movement \t Total Disk Movement");
        System.out.println("------------------------------------------------------------------------");
        
        for(int i = 0; i < requestQueue.length; ++i) {
            int currentDiskMovement = Math.abs(currentHead - requestQueue[i]);
            totalHeadMovement += currentDiskMovement;
            orderOfProcessing[i] = requestQueue[i];
            currentHead = requestQueue[i];
            
            System.out.println( "\t" + (i + 1) +"\t\t" + currentHead + "\t\t" + currentDiskMovement + "\t\t" + totalHeadMovement);
        }
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("\n\tTotal Head Movement: " + totalHeadMovement);
        System.out.print("\n\tOrder of Processing: " + (orderOfProcessing[0]));
        for(int i = 1; i < orderOfProcessing.length; ++i) {
            System.out.print( " -> " + orderOfProcessing[i]);
        }
        printAverageSeekTime(totalHeadMovement, requestQueue.length);
        System.out.println();
    }
    static void printAverageSeekTime(int totalHeadMovement, int totalLength) { 
        System.out.println("\n\n\tAverage Seek Time: " + (totalHeadMovement) + " / " + (totalLength) + " = " + ((double)totalHeadMovement / (double)totalLength));
    }
}
