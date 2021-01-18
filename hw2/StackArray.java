package hw2;

public class StackArray<AT> implements MyStackInterface<AT> {
    private Object[] elements;
    private static final int CAP = 10;
    private int top;
    StackArray(int capacity){
        if(capacity<1) {
            elements = new Object[CAP];
        }
        else {
            elements = new Object[capacity];
        }
        top = -1;
    }
    
    @Override
    public void push(Object item) {
        // TODO Auto-generated method stub
        top = top + 1;
        if(top ==  elements.length) {
            return;//throw new StackException("stack is full");
        }
        elements[top] = item;
        
    }

    @Override
    public AT pop() {
        // TODO Auto-generated method stub
        if(top==-1) {
            return null;
        }
        @SuppressWarnings("unchecked")
        AT temp = (AT) elements[top];
        elements[top] = null;
        top = top - 1;
        return temp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AT peek() {
        // TODO Auto-generated method stub
        if(top==-1) {
            return null;
        }
        return (AT) elements[top];
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(top==-1) {
            return true;
        }
        return false;
    }
    
}
