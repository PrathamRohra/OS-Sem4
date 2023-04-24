import java.util.Scanner;
//LL Allocation
public class Q16 {
    static class Block {
        int bno;
        Block next;
    }

    static class FileTable {
        String name;
        int nob;
        Block sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j;
        String s;
        FileTable[] ft = new FileTable[30];
        Block temp;

        System.out.println("Enter no of files: ");
        int n = scanner.nextInt();

        for (i = 0; i < n; i++) {

            ft[i] = new FileTable();
            System.out.println("Enter file name " + (i+1) + ": ");
            ft[i].name = scanner.nextLine();

            System.out.println("Enter no of blocks in file " + (i+1) + ": ");
            ft[i].nob = scanner.nextInt();

            ft[i].sb = new Block();
            temp = ft[i].sb;
            System.out.println("Enter the blocks of the file: ");
            temp.bno = scanner.nextInt();

            temp.next = null;
            for (j = 1; j < ft[i].nob; j++) {
                temp.next = new Block();
                temp = temp.next;
                temp.bno = scanner.nextInt();
                temp.next = null;
            }
        }

        System.out.print("\nEnter the file name to be searched -- ");
        s = scanner.nextLine();

        for (i = 0; i < n; i++) {
            if (s.equals(ft[i].name)) {
                break;
            }
        }

        if (i == n) {
            System.out.println("\nFile Not Found");
        } else {
            System.out.println("\nFILE NAME  NO OF BLOCKS   BLOCKS OCCUPIED");
            System.out.printf("    %s\t\t%d\t", ft[i].name, ft[i].nob);
            temp = ft[i].sb;
            for (j = 0; j < ft[i].nob; j++) {
                System.out.printf("%d -> ", temp.bno);
                temp = temp.next;
            }
        }

        scanner.close();
    }
}
