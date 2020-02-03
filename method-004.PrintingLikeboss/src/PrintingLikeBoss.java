public class PrintingLikeBoss {

    // copy or rewrite the method of Assignment 39.1 here
    public static void printStars(int amount) {
        for(int i = 0; i < amount; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void printWhitespaces(int amount) {
        // 40.1
        for(int w = 0; w < amount; w++) {
            System.out.println(" ");
        }
    }

    public static void printTriangle(int size) {
        // 40.2
        for (int i = 0; i <= size; i = i + 1) {
            for (int j = 0; j < size-i; ++j) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void xmasTree(int height) {
        // 40.3
    }

    public static void main(String[] args) {
        // Tests do not use main, yo can write code here freely!

        printTriangle(5);
        System.out.println("---");
        xmasTree(4);
        System.out.println("---");
        xmasTree(10);
    }
}
