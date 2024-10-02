import java.util.Scanner;

public class ToH
{
    StackInterface<Integer> pole1 = new MyStack<>();
    StackInterface<Integer> pole2 = new MyStack<>();
    StackInterface<Integer> pole3 = new MyStack<>();
    public static void main(String[] args) {
        ToH yay = new ToH();
        int x = 0;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of disks you would like to play with (3-6):");
        do {
            x = kb.nextInt();
            if(x <= 6 && x >= 3)
                break;
            else
                System.out.println("That value is out of range, please try again.\nEnter the number of disks you would like to play with (3-6):");
        }while(true);
        for(int i = x; i > 0; i--)
            yay.pole1.push(i);
        zeros(yay.pole1, yay.pole2, yay.pole3, x+2);
        printPoles(yay.pole1, yay.pole2, yay.pole3, x);
        do {
            System.out.println("Enter the pole you would like to move from (1-3):");
            int from = kb.nextInt();
            System.out.println("Enter the pole you would like to move to (1-3):");
            int to = kb.nextInt();
            while(from < 1 || from > 3 || to < 1 || to > 3)
            {
                System.out.println("Invalid pole, please try again.");
                System.out.println("Enter the pole you would like to move from (1-3):");
                from = kb.nextInt();
                System.out.println("Enter the pole you would like to move to (1-3):");
                to = kb.nextInt();
            }
            do {
                if(!moveDisk(yay.pole1, yay.pole2))
                    System.out.println("Invalid move, please try again.");
                else if(!moveDisk(yay.pole1, yay.pole3))
                    System.out.println("Invalid move, please try again.");
                else if(!moveDisk(yay.pole2, yay.pole1))
                    System.out.println("Invalid move, please try again.");
                else if(!moveDisk(yay.pole2, yay.pole3))
                    System.out.println("Invalid move, please try again.");
                else if(!moveDisk(yay.pole3, yay.pole1))
                    System.out.println("Invalid move, please try again.");
                else if(!moveDisk(yay.pole3, yay.pole2))
                    System.out.println("Invalid move, please try again.");
            }while(!moveDisk(yay.pole1, yay.pole2) && !moveDisk(yay.pole1, yay.pole3) && !moveDisk(yay.pole2, yay.pole1) && !moveDisk(yay.pole2, yay.pole3) && !moveDisk(yay.pole3, yay.pole1) && !moveDisk(yay.pole3, yay.pole2));
            zeros(yay.pole1, yay.pole2, yay.pole3, x+2);
            printPoles(yay.pole1, yay.pole2, yay.pole3, x);
        }while(isWinner(yay.pole3, x) == false);
    }
    public static void zeros(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        for(int i = x - pole1.size(); i > 0; i--)
            pole1.push(0);
        for(int i = pole1.size(); i > 0; i--)
            pole2.push(0);
        for(int i = pole1.size(); i > 0; i--)
            pole3.push(0);
    }
    public static void removeZeros(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3)
    {
        for(int i = pole1.size(); i > 0; i--)
            if(pole1.peek() == 0)
                pole1.pop();
        for(int i = pole1.size(); i > 0; i--)
            if(pole2.peek() == 0)
                pole2.pop();
        for(int i = pole1.size(); i > 0; i--)
            if(pole3.peek() == 0)
                pole3.pop();
    }
    public static void printPoles(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        String s = "";
        for(int i = x - 1; i >= 0; i--)
        {
            s = (printHelper(pole1, i) + printHelper(pole2, i) + printHelper(pole3, i));
            System.out.println(s);
        }
        System.out.println("-".repeat(s.length()));
        removeZeros(pole1, pole2, pole3);
    }
    public static String printHelper(StackInterface<Integer> pole, int i)
    {
        String spaces = "";
        String disk = "";
        if(pole.get(i) == 0)
            disk = "-";
        else
            disk = "X".repeat(pole.get(i)*2+1);
        spaces = " ".repeat(6 - pole.get(i));
        return spaces + disk + spaces;
    }
    public static boolean moveDisk(StackInterface<Integer> pole1, StackInterface<Integer> pole2)
    {
        if (pole1.isEmpty() || (!pole2.isEmpty() && pole1.peek() > pole2.peek()))
            return false;
        pole2.push(pole1.pop());
        return true;
    }
    public static boolean isWinner(StackInterface<Integer> pole3, int x)
    {
        return pole3.size() == x;
    }
}
