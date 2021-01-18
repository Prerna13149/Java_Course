package hw2;

public interface MyStackInterface<AT> {
    void push(AT item);
    AT pop();
    AT peek();
    boolean isEmpty();
}
