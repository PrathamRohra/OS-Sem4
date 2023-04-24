import java.util.*;
//C-SCAN disk

public class Q21 {
    public static void main(String[] args) {

        int[] requestQueue = new int[] { 90, 120, 30, 40, 115, 130, 110, 80, 190, 25 };
        int globalCurrentHead = 86;

        int queueLength = requestQueue.length;
        int[] orderOfProcessing = new int[queueLength];
        int totalHeadMovement = 0;
        Scanner s = new Scanner(System.in);

        int currentHead = globalCurrentHead;
        
        ArrayList<Integer> firstHalf = new ArrayList<Integer>();
        ArrayList<Integer> secondHalf = new ArrayList<Integer>();
        
        for(int i = 0; i < requestQueue.length; ++i) {
            if(currentHead > requestQueue[i])
            firstHalf.add(requestQueue[i]);
            else
            secondHalf.add(requestQueue[i]);
        }
        Collections.sort(firstHalf);   
        Collections.sort(secondHalf);   
        System.out.print(firstHalf);
        System.out.println(secondHalf);
        
        System.out.print("\nTraverse to the inner track or the outer track? \n [0] Inner Track\n [1] Outer Track \n Your Choice? ");
        int outer = s.nextInt();
        
        System.out.println();
        System.out.println("\t\t+----------------------------------------+");
        System.out.println("\t\t|Output for C-SCAN Disk Scheduling Policy|");
        System.out.println("\t\t+----------------------------------------+");
        System.out.println("\n\tHead currently at: " + currentHead);
        
        System.out.println("\n     Iteration \t Current Head \t Disk Movement \t Total Disk Movement");
        System.out.println("------------------------------------------------------------------------");
        
        int j = 0;
        // Inner Track First
        if(outer == 0) {
            for(int i = firstHalf.size() - 1; i >= 0 ; --i) {
                
                int currentDiskMovement = Math.abs(currentHead - firstHalf.get(i));
                totalHeadMovement += currentDiskMovement;
                orderOfProcessing[j] = firstHalf.get(i);
                currentHead = firstHalf.get(i);
                
                System.out.println( "\t" + (++j) +"\t\t" + currentHead + "\t\t" + currentDiskMovement + "\t\t" + totalHeadMovement);
            }
            
            // going to 0;
            totalHeadMovement += (currentHead - 0);
            orderOfProcessing[j] = 0;
            System.out.println( "\t" + (++j) +"\t\t" + 0 + "\t\t" + (currentHead - 0) + "\t\t" + totalHeadMovement);
            currentHead = 0;

            // going to 199;
            totalHeadMovement += Math.abs(currentHead - 199);
            orderOfProcessing[j] = 199;
            System.out.println( "\t" + (++j) +"\t\t" + 199 + "\t\t" + 199 + "\t\t" + totalHeadMovement);
            currentHead = 199;
            
            for(int i = secondHalf.size() - 1; i >= 0; --i)  {
                
                int currentDiskMovement = Math.abs(currentHead - secondHalf.get(i));
                totalHeadMovement += currentDiskMovement;
                orderOfProcessing[j] = secondHalf.get(i);
                currentHead = secondHalf.get(i);
                
                System.out.println( "\t" + (++j) +"\t\t" + currentHead + "\t\t" + currentDiskMovement + "\t\t" + totalHeadMovement);
            }
        }

        // Outer Track First;
        else {
            for(int i = 0; i < secondHalf.size(); i++) {
                int currentDiskMovement = Math.abs(currentHead - secondHalf.get(i));
                totalHeadMovement += currentDiskMovement;
                orderOfProcessing[j] = secondHalf.get(i);
                currentHead = secondHalf.get(i);
                
                System.out.println( "\t" + (++j) +"\t\t" + currentHead + "\t\t" + currentDiskMovement + "\t\t" + totalHeadMovement);
            }
            
            // going to 199;
            totalHeadMovement += Math.abs(currentHead - 199);
            orderOfProcessing[j] = 199;
            System.out.println( "\t" + (++j) +"\t\t" + 199 + "\t\t" + Math.abs(currentHead - 199) + "\t\t" + totalHeadMovement);
            currentHead = 199;
            
            // going to 0;
            totalHeadMovement += Math.abs(currentHead - 0);
            orderOfProcessing[j] = 0;
            System.out.println( "\t" + (++j) +"\t\t" + 0 + "\t\t" + 199 + "\t\t" + totalHeadMovement);
            currentHead = 0;
            
            for(int i = 0; i < firstHalf.size(); i++) {
                int currentDiskMovement = Math.abs(currentHead - firstHalf.get(i));
                totalHeadMovement += currentDiskMovement;
                orderOfProcessing[j] = firstHalf.get(i);
                currentHead = firstHalf.get(i);
                
                System.out.println( "\t" + (++j) +"\t\t" + currentHead + "\t\t" + currentDiskMovement + "\t\t" + totalHeadMovement);
            }
        }
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("\n\tTotal Head Movement: " + totalHeadMovement);
        System.out.print("\n\tOrder of Processing: " + (orderOfProcessing[0]));
        for(int i = 1; i < orderOfProcessing.length; ++i) {
            System.out.print( " -> " + orderOfProcessing[i]);
        }
    }
    static void printAverageSeekTime(int totalHeadMovement, int totalLength) { 
        System.out.println("\n\n\tAverage Seek Time: " + (totalHeadMovement) + " / " + (totalLength) + " = " + ((double)totalHeadMovement / (double)totalLength));
    }
}
