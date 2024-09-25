import java.util.ArrayList;

public class MyQueue <E> implements QueueInterface<E>
{
    public ArrayList<E> yay = new ArrayList<>();

    @Override
    public void offer(E o)
    {
        yay.add(o);
    }
    @Override
    public E element()
    {
        return yay.get(0);
    }
    @Override
    public E poll()
    {
        return yay.remove(0);
    }
    @Override
    public E get(int x)
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
