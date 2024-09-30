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

        }while(isWinner(yay.pole3))
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
    public static void printPoles(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        String s = "";
        for(int i = x - 1; i >= 0; i--)
        {
            s = (printHelper(pole1, i) + printHelper(pole2, i) + printHelper(pole3, i));
            System.out.println(s);
        }
        System.out.println("-".repeat(s.length()));
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
    public static void isWinner()
    {

    }
}
