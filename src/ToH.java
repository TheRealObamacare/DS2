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
        }while();
        for(int i = x; i > 0; i--)
            yay.pole1.push(i);
        printPoles(yay.pole1, yay.pole2, yay.pole3, x);
    }
    public static void printPoles(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        System.out.printf(pole1.toString() + pole2.toString() + pole3.toString());
        for(int i = x; i > 0; i++)
        {
            System.out.println(printHelper(pole1, i) + printHelper(pole2, i) + printHelper(pole3, i));
        }
        //25 dashes System.out.println("-------------------------");
    }
    public static void setUp(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3, int x)
    {
        for(int i = x - pole1.size(); i > 0; i++)
            pole1.push(0);
        for(int i = x - pole2.size(); i > 0; i++)
            pole1.push(0);
        for(int i = x - pole3.size(); i > 0; i++)
            pole1.push(0);
    }
    public static String printHelper(StackInterface<Integer> pole, int i)
    {
        String spaces = "";
        String disk = "";
        if(pole.get(i) == 0)
            disk = "-";
        else if(pole.get(i) == 1)
            disk = "XXX";
        else if(pole.get(i) == 2)
            disk = "XXXXX";
        else if(pole.get(i) == 3)
            disk = "XXXXXXX";
        else if(pole.get(i) == 4)
            disk = "XXXXXXXXX";
        else if(pole.get(i) == 5)
            disk = "XXXXXXXXXXX";
        else if(pole.get(i) == 6)
            disk = "XXXXXXXXXXXXX";
        for(int x = 6 - pole.get(i); x > 0; x--)
        {
            spaces+=" ";
        }
    }
}
