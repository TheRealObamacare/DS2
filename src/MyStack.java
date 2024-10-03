import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>
{
    private ArrayList<T> yay = new ArrayList<>();

    @Override
    public void push(T o)
    {
        yay.add(o);
    }
    @Override
    public T peek()
    {
        return yay.get(yay.size()-1);
    }
    @Override
    public T pop()
    {
        return yay.remove(yay.size()-1);
    }
    @Override
    public T get(int x)
    {
        return yay.get(x);
    }
    @Override
    public int size()
    {
        return yay.size();
    }
    @Override
    public boolean isEmpty()
    {
        return yay.isEmpty();
    }
    @Override
    public void clear()
    {
        yay.clear();
    }
    @Override
    public String toString()
    {
        return yay.toString();
    }
}
