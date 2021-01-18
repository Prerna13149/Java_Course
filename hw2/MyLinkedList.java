package hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AT> implements Iterable<AT>{
    private Node<AT> head;
    public MyLinkedList() {
        head = null;
    }
    public void insertFront(AT item) {
        head = new Node(item, head);
    }
    public void insertEnd(AT item) {
        if(head==null) {
            head = new Node(item, head);
        }
        else {
            Node<AT> temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = new Node(item, null);
        }
        return;
    }
    public void insertAfter(AT key, AT item) {
        if(head == null) {
            return;
        }
        Node<AT> temp = head;
        while (temp!=null && !temp.data.equals(key)) {
            temp = temp.next;
        }
        if(temp==null) {
            return;
        }
        temp.next = new Node(item, null);
        return;
    }
    public void insertBefore(AT key, AT item) {
        if(head == null) {
            return;
        }
        Node<AT> temp = head;
        Node<AT> prev = null;
        while(temp!=null && !temp.data.equals(key)) {
            prev = temp;
            temp = temp.next;
        }
        if(temp==null) {
            return;
        }
        prev.next = new Node(item, temp);
        return;
    }
    void remove(AT key) {
        if(head==null) {
            return;
        }
        if(head.data.equals(key)) {
            head = head.next;
            return;
        }
        Node<AT> curr = head;
        Node<AT> prev = null;
        while(curr!=null && !curr.data.equals(key)) {
            prev = curr;
            curr = curr.next;
        }
        if(curr==null) {
            return;
        }
        prev.next = curr.next;
        //curr.next = null;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    private static class Node<AT> {
        private AT data;
        private Node<AT> next;
        Node(AT item){
            data = item;
            next = null;
        }
        Node(AT newData, Node<AT> newNext) {
            data = newData;
            next = newNext;
        }
    }
    @Override
    public Iterator<AT> iterator() {
        // TODO Auto-generated method stub
        return new MyIterator();
    }
    private class MyIterator implements Iterator<AT> {
        private Node<AT> nextNode;

        /**
         * No-arg constructor that starts the iteration from the head.
         */
        MyIterator() {
            // access to the head instance variable of the Outer class
            nextNode = head;
        }

        /**
         * Checks whether there is next element or not.
         *
         * @return true if there is next element or false if not
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * Returns next element in the sequence and moves forward.
         *
         * @return next element (data)
         * @throws throws NoSuchElementException if there is no element.
         */
        @Override
        public AT next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AT result = nextNode.data;
            nextNode = nextNode.next;
            return result;
        }
    }

}
