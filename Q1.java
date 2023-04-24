//FCFS
import java.util.*;
class Q1{
    static float avgTAT = 0;
    static float avgWT = 0;
    public static void main(String[] args) {
        

        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the no of processes: ");
        int n = inp.nextInt();
        int[] processes = new int[n];

        //Inititalizing process numbers
        for(int i = 0; i < n; i++){
            processes[i] = i;
        }

        System.out.println("Enter the burst time: ");
        int[] burst = new int[n];
        for(int i = 0; i < n; i++){
            burst[i] = inp.nextInt();
        }
        int[] wt = new int[n];
        findWaitingTime(processes, n, burst, wt);
        
        int[] tat = new int[n];
        findTurnAroundTime(processes, n, wt, burst, tat);

        findAvgTAT(processes, n, tat);
        findAvgWT(processes, n, wt);


        genTable(processes, burst, wt, tat, n);
        System.out.println("Average Turnaround Time: "+avgTAT);
        System.out.println("Average Waiting Time: "+avgWT);
    }
    static void findWaitingTime(int[] processes, int n, int[]bt, int[] wt){
        //Waiting time of first is 0.
        wt[0] = 0;
        for(int i = 1; i < n; i++){

            //Waiting time of ith process
            wt[i] = wt[i-1] + bt[i-1];
        }
    }
    static void findTurnAroundTime(int[] processes, int n, int[] wt, int[] bt, int[] tat){

        for(int i = 0; i < n; i++){
            tat[i] = bt[i]+wt[i];
        }

    }
    static void findAvgTAT(int[] processes, int n, int[] tat){
        for(int i: tat){
            avgTAT += i;
        }
        avgTAT /= n;
        System.out.println(avgTAT);
    }
    static void findAvgWT(int[] processes, int n, int[] wt){
        for(int i: wt){
            avgWT += i;
        }
        avgWT /= n;
        System.out.println(avgWT);
    }

    static void genTable(int[] processes, int[] bt, int[] wt, int[] tat, int n){
        System.out.print("Process Burst Time Waiting Time Turunaround Time \n");
        for(int i = 0; i < n; i++){
            System.out.println(String.format("%d \t | %d \t | \t %d \t  | %d", processes[i], bt[i], wt[i], tat[i]));
        }
    }
}