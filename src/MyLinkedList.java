import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList implements Iterator<Node>, ListIterator<Node> {
    private Node head;

    private Node current;

    private Node previous;

    public void pushToTail(int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            current = node;
            return;
        }
        Node tempCurrent = head;
        while (tempCurrent.getNext() != null) {
            tempCurrent = tempCurrent.getNext();
        }
        tempCurrent.setNext(node);
    }

    public void add(int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            current = node;
            return;
        }
        node.setNext(head);
        head = node;
        current = node;
    }

    public void printValue() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        if (head == null) {
            return 0;
        }
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.getNext();
        }
        return size;
    }

    public int get(int i) {
        if (head == null) {
            return -1;
        }
        if (i >= size() || i < 0) {
            return -1;
        }
        int count = -1;
        Node curr = head;
        while (curr != null) {
            count++;
            if (count == i) {
                return curr.getData();
            }
            curr = curr.getNext();
        }
        return -1;
    }

    // Task 1 Add by index
    public void addByIndex(int value, int index) {
        Node node = new Node(value, null);
        if (head == null) {
            System.out.println("The List is empty, so your element will be the first");
            head = node;
            current = node;
            return;
        }
        if (index > size()) {
            System.out.println("Your index is out of bound. It must be no more then " + size());
            return;
        } else if (index < 0) {
            System.out.println("Index can not be negative!");
            return;
        }
        if (index == 0) {
            add(value);
        }

        int count = -1;
        current = head;
        while (current != null) {
            count++;
            if (count == (index - 1)) {
                node.setNext(current.getNext());
                current.setNext(node);
                return;
            }
            current = current.getNext();
        }
    }


    //Task 2. Remove by index
    public void removeByIndex(int index) {
        if (head == null) {
            System.out.println("The List is empty, there is nothing to remove");
            return;
        }
        if (index >= size()) {
            System.out.println("Your index is out of bound. It must be no more then " + (size() - 1));
            return;
        } else if (index < 0) {
            System.out.println("Index can not be negative!");
            return;
        } else if (index == 0) {
            current = head;
            head = current.getNext();
            current = head;
            //current.setNext(null);
            return;
        }

        current = head;
        int count = -1;
        while (current != null) {
            count++;
            if (count == (index - 1)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    // Iterator
    @Override
    public boolean hasNext() {
        if (head == null) {
            return false;
        }
        if (current.getNext() != null) {
            return true;
        }
        current = head;
        return false;
    }

    @Override
    public Node next() {
        if (!hasNext())
            throw new NoSuchElementException();
        current = current.getNext();
        return current;
    }

    //ListIterator

    private Node nodeByIndex(int index) {
        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode;
    }

    @Override
    public boolean hasPrevious() {
        return nextIndex() > 1;
    }

    @Override
    public Node previous() {
        if (!hasPrevious()) {
            System.out.println("No previous elements available");
            //throw new NoSuchElementException();
            return null;
        }
        previous = nodeByIndex(previousIndex());
        current = previous;
        return current;
    }

    @Override
    public int nextIndex() {
        if (head == null) {
            return -1;
        }
        int counter = 0;
        Node currentPosition = current.getNext();
        while (currentPosition != null) {
            counter++;
            currentPosition = currentPosition.getNext();
        }
        return size() - counter;
    }

    @Override
    public int previousIndex() {
        if (head == null) {
            return -1;
        }
        int counter = 0;
        Node currentPosition = current;
        while (currentPosition != null) {
            counter++;
            currentPosition = currentPosition.getNext();
        }
        if ((size() - (counter + 1)) < 0) {
            System.out.println("There is no elements before current");
            return -1;
            //throw new NoSuchElementException();
        }
        return size() - (counter + 1);
    }

    @Override
    public void remove() {
        if (current == null) {
            System.out.println("None of the elements can be removed");
            return;
        }
        Node nodeToRemove = current;
        previous = previous();
        previous.setNext(nodeToRemove.getNext());
        nodeToRemove.setNext(null);
        current = head;
        previous = head;
    }

    @Override
    public void set(Node node) {
        if (current == null) {
            System.out.println("None of the elements can be replaced");
            return;
        }
        current = node;
    }


    @Override
    public void add(Node node) {
        if (head == null) {
            head = node;
            current = node;
        } else if (nextIndex() == 1) {
            node = head;
            node.setNext(current);
        } else {
            previous = previous();
            current = previous.getNext();
            previous.setNext(node);
            node.setNext(current);
        }
    }
}






