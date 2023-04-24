import java.io.File;
import java.util.Scanner;

public class Q15 {
    //CONTIGUOUS FILE
    static class FileTable{
        String name;
        int startBlock, noOfBlocks;
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter number of files: ");
        int n = inp.nextInt();

        FileTable[] ft = new FileTable[30]; //Contains 30 blocks

        for(int i = 0; i < n; i++){

            ft[i] = new FileTable();

            System.out.println("Enter File Name: ");
            String name = inp.next();
            ft[i].name = name;

            System.out.println("Enter starting block: ");
            int sb = inp.nextInt();
            ft[i].startBlock = sb;

            System.out.println("Enter number of blocks: ");
            int nob = inp.nextInt();
            ft[i].noOfBlocks = nob;
        }

        for(int i = 0; i < n; i++){
            System.out.println("FN: "+ft[i].name + "SB" + ft[i].startBlock + "NB" +ft[i].noOfBlocks);
        }

        
    }
}
