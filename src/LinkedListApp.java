public class LinkedListApp {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(5);
        myLinkedList.add(2);
        myLinkedList.add(4);

        myLinkedList.pushToTail(3);
        myLinkedList.pushToTail(6);
        myLinkedList.pushToTail(1);


        System.out.println("Size: " + myLinkedList.size());
        System.out.println("List before adding by index: ");
        myLinkedList.printValue();
        myLinkedList.addByIndex(7, 3);
        System.out.println("\nList after adding by index: ");
        myLinkedList.printValue();
        System.out.println("Size: " + myLinkedList.size());

        myLinkedList.removeByIndex(2);
        System.out.println("\nList after removing by index: ");
        myLinkedList.printValue();
        System.out.println("Size: " + myLinkedList.size());

        //Task 3 Add iterator

        while (myLinkedList.hasNext()) {
            System.out.println(myLinkedList.next());
        }

        //Task 3 Add Listiterator

        System.out.println("==========================");
        myLinkedList.next();
        myLinkedList.next();
        System.out.println("Next index: " + myLinkedList.nextIndex());
        System.out.println("Previous index: " + myLinkedList.previousIndex());
        System.out.println("Method \"HasPrevious\": "  + myLinkedList.hasPrevious());
        myLinkedList.next();
        myLinkedList.next();
        System.out.println("Next index: " + myLinkedList.nextIndex());
        System.out.println("Previous index: " + myLinkedList.previousIndex());
        myLinkedList.remove();
        myLinkedList.printValue();
        System.out.println("==========================");

        Node newNode = new Node(5, null);
        myLinkedList.add(8);
        myLinkedList.next();
        myLinkedList.next();
        System.out.println("Next index: " + myLinkedList.nextIndex());
        System.out.println("Previous index: " + myLinkedList.previousIndex());
        myLinkedList.add(newNode);
        System.out.println("New List\n================");
        myLinkedList.printValue();







    }




}

