import java.util.Scanner;

public class TowerOfHanoi
{
    StackInterface<Integer> pole1 = new MyStack<>();
    StackInterface<Integer> pole2 = new MyStack<>();
    StackInterface<Integer> pole3 = new MyStack<>();
    int turnCount = 0; 
    public static void main(String[] args) {
        TowerOfHanoi yay = new TowerOfHanoi();
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
        int from = 0;
        int to = 0;
        do {
            do {
                System.out.println("Enter your from pole (1-3):");
                from = kb.nextInt();
                System.out.println("Enter your to pole (1-3):");
                to = kb.nextInt();
                if((from >= 1 && from <= 3) && (to >= 1 && to <= 3) && (from != to))
                    break;
                else
                    System.out.println("\tInvalid Move.");
            } while(true);
            if (!moveDisk(yay.getPole(from), yay.getPole(to))) {
                System.out.println("\tInvalid Move.");
            } else {
                yay.turnCount++;
                printPoles(yay.pole1, yay.pole2, yay.pole3, x);
            }
        } while (!isWinner(yay.pole3, x));
        if (x == 3)
            System.out.printf("Congratulations you solved 3 disks in %d moves. A perfect solutions is 7 moves.", yay.turnCount);
        else if (x == 4)
            System.out.printf("Congratulations you solved 4 disks in %d moves. A perfect solutions is 15 moves.", yay.turnCount);
        else if (x == 5)
            System.out.printf("Congratulations you solved 5 disks in %d moves. A perfect solutions is 31 moves.",  yay.turnCount);
        else if (x == 6)
            System.out.printf("Congratulations you solved 6 disks in %d moves. A perfect solutions is 63 moves.", yay.turnCount);
    }
    public static void zeros(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        for(int i = x - pole1.size(); i > 0; i--)
            pole1.push(0);
        for(int i = x - pole2.size(); i > 0; i--)
            pole2.push(0);
        for(int i = x - pole3.size(); i > 0; i--)
            pole3.push(0);
    }
    public static void removeZeros(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3)
    {
        for(int i = pole1.size(); i > 0; i--)
            if(pole1.peek() == 0)
                pole1.pop();
        for(int i = pole2.size(); i > 0; i--)
            if(pole2.peek() == 0)
                pole2.pop();
        for(int i = pole3.size(); i > 0; i--)
            if(pole3.peek() == 0)
                pole3.pop();
    }
    public static void printPoles(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        zeros(pole1, pole2, pole3, x+2);
        if (x == 3)
            System.out.println("    -       -       -    \n" + "    -       -       -    ");
        else if (x == 4)
            System.out.println("     -         -         -     \n" + "     -         -         -     ");
        else if(x == 5)
            System.out.println("      -           -           -      \n" + "      -           -           -      ");
        else
            System.out.println("       -             -             -       \n" + "       -             -             -       ");
        String s = "";
        for(int i = x - 1; i >= 0; i--)
        {
            s = (" " + printHelper(pole1, i, x*2+1) + " " + printHelper(pole2, i, x*2+1) + " " + printHelper(pole3, i, x*2+1) + " ");
            System.out.println(s);
        }
        System.out.println("-".repeat(s.length()) + "\n");
        removeZeros(pole1, pole2, pole3);
    }
    public static String printHelper(StackInterface<Integer> pole, int i, int len)
    {
        String spaces = "";
        String disk = "";
        if(pole.get(i) == 0)
            disk = "-";
        else
            disk = "X".repeat(pole.get(i)*2+1);
    spaces = " ".repeat((len - (pole.get(i)*2+1)) /2);
        return spaces + disk + spaces;
}
public static boolean moveDisk(StackInterface<Integer> from, StackInterface<Integer> to) {
        while (!from.isEmpty() && from.peek() == 0) {
            from.pop();
        }
        while (!to.isEmpty() && to.peek() == 0) {
            to.pop();
        }
        if (from.isEmpty()) {
            return false;
        }
        if (!to.isEmpty() && from.peek() > to.peek()) {
            return false;
        }
        to.push(from.pop());
        return true;
    }
    public static boolean isWinner(StackInterface<Integer> pole3, int numDisks) {
        if (pole3.size() != numDisks) {
            return false; 
        }
        for (int i = 1; i <= numDisks; i++) {
            if (pole3.pop() != i) {
                return false;
            }
        }
        return true;
    }
    public StackInterface<Integer> getPole(int poleNumber) {
        if (poleNumber == 1)
            return this.pole1;
        else if (poleNumber == 2)
            return this.pole2;
        return this.pole3;
    }
}