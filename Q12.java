import java.util.Scanner;

//MFT
public class Q12 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the total available memory (in Bytes): ");
        int mem = inp.nextInt();

        System.out.println("Enter the block size: ");
        int blockSize = inp.nextInt();

        int noOfBlocks = mem/blockSize;
        int externalFrag = mem - noOfBlocks*blockSize;

        System.out.println("Enter the number of processes: ");
        int n = inp.nextInt();


        int temp = mem;
        int[] memOfProcess = new int[10];

        for(int i = 0; i < n; i++){
            System.out.println("Enter memory reqd for process "+i);
            memOfProcess[i] = inp.nextInt();
        }

        System.out.println("The number of blocks available in the memory: " + noOfBlocks);
        System.out.println("PROCESS\tMEMORY REQD\tALLOCATED\tINTERNAL FRAG");
        int p = 0, i = 0;
        int totalIntFrag = 0;
        for(i = 0; i<n && p < noOfBlocks; i++){
            System.out.print("\n" + i + "\t\t" + memOfProcess[i]);
            if(memOfProcess[i] > blockSize){
                System.out.print("\t\tNO\t\t --");
            }
            else{
                System.out.print("\t\tYES\t\t"+(blockSize-memOfProcess[i]));
                totalIntFrag = totalIntFrag + blockSize - memOfProcess[i];
                p++;
            }
        }
        if(i < n){
            System.out.println("Memory is full. Fuck Off");
            System.out.println("Total Int frag: "+ totalIntFrag);
            System.out.println("Total external fragmentation: "+ externalFrag);
        }
    }
}
