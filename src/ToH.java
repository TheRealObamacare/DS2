import java.util.Scanner;

public class ToH
{
    StackInterface<Integer> pole1 = new MyStack<>();
    StackInterface<Integer> pole2 = new MyStack<>();
    StackInterface<Integer> pole3 = new MyStack<>();


    public static void main(String[] args) {
        ToH yay = new ToH();
        System.out.println("Enter the number of disks you would like to play with (3-6):");
        Scanner kb = new Scanner(System.in);
        for(int i = kb.nextInt(); i > 0; i--)
            yay.pole1.push(i);
        printPoles(yay.pole1, yay.pole2, yay.pole3);
    }
    public static void printPoles(StackInterface<Integer> pole1,StackInterface<Integer> pole2, StackInterface<Integer> pole3)
    {
        System.out.printf(pole1.toString() + pole2.toString() + pole3.toString());
    }
}
