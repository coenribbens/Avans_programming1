
public class Checkerboard {
    public static void main(String[] args) {
        printCheckerBoard(9,10);

        }

    public static void printCheckerBoard(int rows, int cols) {

        for (int i = 0; i <= rows; i++)
        {
            if (i % 2 == 0)
            {
                System.out.print("#");
            }
            for (int j = 0; j <= cols; j++)
            {
                if (j % 2 == 0)
                {
                    System.out.print(" ");
                }
                else if (j != rows || i % 2 != 0)
                {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }
    
}
