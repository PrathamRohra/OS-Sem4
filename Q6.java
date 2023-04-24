import java.util.*;
//BEST FIT

public class Q6 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter number of blocks");
        int blockCount = inp.nextInt();
        int[] blockSize = new int[blockCount];
        System.out.println("Enter the size of each block");
        for(int i = 0; i < blockCount; i++){
            blockSize[i] = inp.nextInt();
        }

        System.out.println("Enter number of processes");
        int processCount = inp.nextInt();
        int[] processSize = new int[processCount];
        System.out.println("Enter the size of each process");
        for(int i = 0; i < processCount; i++){
            processSize[i] = inp.nextInt();
        }
        
        firstFit(blockSize, blockCount, processSize, processCount);

    }
    static void firstFit(int[] blockSize, int blockCount ,int[] processSize, int processCount){
        int[] allocation = new int[processCount];
        //Initial allocation = -1;
        Arrays.fill(allocation, -1);
        
        //For each process, iterating the whole block.
        for(int i = 0; i < processCount; i++){
            int bestBlock = -1;
            for(int j = 0; j < blockCount; j++){
                
                if(blockSize[j] >= processSize[i]){//If jth block is GTE to process size

                    //And, block is not allocated || smallest block condition (best fit)
                    if(bestBlock == -1 || blockSize[bestBlock] > blockSize[j]){
                        bestBlock = j;
                    }
                }
            }
            //Reducing block size after finding best block.
            if(bestBlock != -1){
                allocation[i] = bestBlock;
                blockSize[bestBlock] -= processSize[i];
            }
            
        }

        //Printing the results
        System.out.println("Process \tProcess Size \tBlock Allocated");
        for(int i = 0; i < processCount; i++){
            System.out.println("P"+ i + "\t\t" + processSize[i] + "\t\t" + (allocation[i]== -1 ? "Not allocated": allocation[i]));
        }

    }
}
