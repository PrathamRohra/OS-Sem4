import java.util.Scanner;

//MVT
public class Q11 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the total available memory (in Bytes): ");
        int mem = inp.nextInt();

        int temp = mem;
        int[] memOfProcess = new int[10];

        int n = 0;
        boolean flag = true;

        for(int i = 0; flag == true; i++, n++){
            System.out.println("Enter memory required for process " + i);
            memOfProcess[i] = inp.nextInt();

            if(memOfProcess[i] <= temp){
                temp -= memOfProcess[i];
            }
            else{
                System.out.println("Memory is full :( ");
                break;
            }

            System.out.println("Do you wish to continue? true/false ");
            flag = inp.nextBoolean();
        }

        System.out.println("TOTAL MEMORY: "+ mem);
        System.out.println("\tPROCESS\t\t MEM ALLOCATED");
        for(int i = 0; i < n; i++){
            System.out.println("\t"+ i + "\t\t" + memOfProcess[i]);
        }

        System.out.println("Total Memory Allocated is " +  (mem - temp));
        System.out.println("Total External Fragmentation is "+ temp);


    }
}
