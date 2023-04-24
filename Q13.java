import java.util.*;
//PAGING

public class Q13{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long processSize = 0, pageSize = 0, mainSize = 0;
        System.out.print("Enter the Size of a process (in KB): ");
        processSize = sc.nextLong();
        System.out.print("Enter the Page Size (in bytes): ");
        pageSize = sc.nextLong();
        System.out.print("Enter the Size of the Physical Memory (in MB): ");
        mainSize = sc.nextLong();

        long totalFrames = (mainSize * (long) Math.pow(2, 20)) / pageSize;
        long numberOfPages = (processSize * (long) Math.pow(2, 10)) / pageSize;

        double bitsOfPageSize = Math.log(pageSize) / Math.log(2);
        double bitsOfTotalFrames = Math.log(totalFrames) / Math.log(2);
        double bitsOfNumberOfPages = Math.log(numberOfPages) / Math.log(2);

        System.out.println("\n1. Total number of frames in main memory: " + totalFrames);
        System.out.println("2. Total number of entries in page table: " + numberOfPages);

        System.out.println("3. Number of bits in Physical Address: " + (bitsOfPageSize + bitsOfTotalFrames) + " bits");
        System.out.println("4. Number of bits in Logical Address: " + (bitsOfPageSize + bitsOfNumberOfPages) + " bits");

        long sizeOfPageTable = 0;
        System.out.print("\nEnter the number of entries in the Page Table: ");
        sizeOfPageTable = sc.nextLong();

        Map<Long, Long> pageTable = new HashMap<>();

        for (int i = 0; i < sizeOfPageTable; i++) {
            System.out.println();
            long pageNumber, frameNumber;
            System.out.print("Enter Page Number: ");
            pageNumber = sc.nextLong();
            System.out.print("Enter Frame Number: ");
            frameNumber = sc.nextLong();

            pageTable.put(pageNumber, frameNumber);
        }

        System.out.println("Page No.  Frame No.  Valid Bit");

        for (int i = 0; i < numberOfPages; i++) {
            // Page No.
            System.out.print(i + " \t ");

            // Frame No. & Valid Bit
            System.out.println(pageTable.getOrDefault((long) i, 0L) + " \t " + ((pageTable.getOrDefault((long) i, 0L) != 0) ? "1" : "0"));
        }

        System.out.println();
        boolean ok = true;
        while (ok) {
            String logicalAddress;
            System.out.print("\nEnter " + (bitsOfPageSize + bitsOfNumberOfPages) + " bits of Logical Address: ");
            logicalAddress = sc.next();
            logicalAddress = new StringBuilder(logicalAddress).reverse().toString();
            long number = 0, j = 0;
            for (int i = 0; i < logicalAddress.length(); i++) {
                number += (logicalAddress.charAt(i) - '0') * Math.pow(2, j++);
            }
            System.out.println("Number: " + number);
            System.out.println((pageTable.getOrDefault(number, 0L) != 0) ? "PAGE HIT" : "PAGE MISS");
            System.out.print("\nContinue? [true/false]: ");
            ok = sc.nextBoolean();
        }

        sc.close();
    }
}
