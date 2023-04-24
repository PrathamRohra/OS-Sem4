//INDEXED FILE ALLOCATION.
import java.util.*;

public class Q14 {
    
    static class FileTable {
        String name;
        int nob;
        int[] blocks;
        
        public FileTable(String name, int nob) {
            this.name = name;
            this.nob = nob;
            this.blocks = new int[nob];
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter no of files: ");
        n = sc.nextInt();
        FileTable[] ft = new FileTable[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("\nEnter file name %d: ", i + 1);
            String name = sc.next();
            System.out.printf("Enter no of blocks in file %d: ", i + 1);
            int nob = sc.nextInt();
            FileTable file = new FileTable(name, nob);
            System.out.print("Enter the blocks of the file: ");
            for (int j = 0; j < nob; j++) {
                file.blocks[j] = sc.nextInt();
            }
            ft[i] = file;
        }
        System.out.print("\nEnter the file name to be searched: ");
        String s = sc.next();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (s.equals(ft[i].name)) {
                found = true;
                System.out.println("\nFILE NAME\tNO OF BLOCKS\tBLOCKS OCCUPIED");
                System.out.printf("    %s\t\t%d\t\t", ft[i].name, ft[i].nob);
                for (int j = 0; j < ft[i].nob; j++) {
                    System.out.printf("%d, ", ft[i].blocks[j]);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("\nFile Not Found");
        }
    }
}
