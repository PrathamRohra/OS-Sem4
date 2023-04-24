//SJF
import java.util.*;

public class Q2 {
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

        sortingSJF(processes, n, burst);


        int[] wt = new int[n];
        findWaitingTime(processes, n, burst, wt);
        
        int[] tat = new int[n];
        findTurnAroundTime(processes, n, wt, burst, tat);

        findAvgTAT(processes, n, tat);
        findAvgWT(processes, n, wt);


        genTable(processes, burst, wt, tat, n);

        genGanntChart(processes, n);
        System.out.println("Average Turnaround Time: "+avgTAT);
        System.out.println("Average Waiting Time: "+avgWT);

    }

    static void sortingSJF(int[] processes, int n, int[] bt){
        for(int i= 0; i < n; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (bt[j] > bt[j + 1]) {
                    //BT
                    int temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    //Processes
                    int temp2 = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp2;
                }
            }   
        }

        for(int i: processes){
            System.out.println(i);
        }
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

    static void genGanntChart(int[] processes, int n){
        System.out.print("|");
        for(int process: processes){
            System.out.print("P"+process+ " | ");
        }
    }
}
