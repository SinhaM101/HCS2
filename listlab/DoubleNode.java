public class DoubleNode<E>
{
    private E value;
    private DoubleNode<E> next;
    private DoubleNode<E> past;
    
    public DoubleNode(E value, DoubleNode<E> next, DoubleNode<E> past)
    {
        this.value = value;
        this.next = next;
        this.past = past;
    }
    
    public E getValue()
    {
        return value;
    }
    
    public DoubleNode<E> getNext()
    {
        return next;
    }

    public DoubleNode<E> getPrevious()
    {
        return past;
    }
    
    public void setValue(E value)
    {
        this.value = value;
    }
    
    public void setNext(DoubleNode<E> next)
    {
        this.next = next;
    }

    public void setPrevious(DoubleNode<E> past)
    {
        this.past = past;
    }
}
