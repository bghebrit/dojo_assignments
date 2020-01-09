class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(6);
        sl.add(10);
        sl.add(15);
        sl.removeAt(6);
        sl.removeAt(10);
        sl.remove();
        sl.printValues();
    }
}