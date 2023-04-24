//OPTIMAL
import java.util.*;

public class Q10{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the number of pages: ");
        int pages = inp.nextInt();
        int[] pageStream = new int[pages];
        System.out.println("Enter the page/reference string: ");
        for(int i = 0; i < pages; i++){
            pageStream[i] = inp.nextInt();
        }
        
        System.out.println("Enter number of frames: ");
        int frames = inp.nextInt();

        LRU(pageStream, pages, frames);

    }
    static void LRU(int[] pageStream, int pages, int frames){

        int pageFaults = 0;
        int hitCount = 0;
        boolean alreadyPresent = false;
        int[] frameArr = new int[frames];
        int pos = 0;

        System.out.println("Incoming Page \t Frames");
        for(int i = 0; i < pages; i++){
            alreadyPresent = false;
            for(int j = 0; j < frames; j++){
                if(frameArr[j] == pageStream[i]){
                    hitCount++;
                    alreadyPresent = true;
                    break;
                }
            }
            if(alreadyPresent != true){
                pageFaults++;
                //Initially empty, hence FIFO.
                if(pos < frames){
                    frameArr[pos] = pageStream[i];
                    pos++;
                }

                //OPTIMAL
                else{
                    int farthest = -1, replaceIdx = -1;
                    for(int j = 0; j < frames; j++){
                        //Check in front now.
                        int k;
                        for(k = i+1; k < pages; k++){
                            if(frameArr[j] == pageStream[k]){
                                if(k > farthest){
                                    farthest = k;
                                    replaceIdx = j;
                                }
                                break;
                            }
                        }

                        //If all pages are scanned and match not found then add to last position.
                        if (k == pages) {
                            replaceIdx = j;
                            break;
                        }

                    }
                    frameArr[replaceIdx] = pageStream[i];
                }
            }
            System.out.print(pageStream[i] + "\t\t");
            for(int j: frameArr){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("Page Faults: "+ pageFaults+ "\n" + "Hit Count: "+ hitCount);
    }
    
}
