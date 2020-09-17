package ru.gb2.lesson8;

public class DoublyLinkedList implements GeekBrainsList {
    private Node head;
//    private Node preview;

    @Override
    public void add(String o) {
        if (head == null) {
            head = new Node(o);
            return;
        }
        add(head, o);
    }

    private void add(Node current, String o) {
        if (current.getNext() == null) {
            Node nodeAdd = new Node(o);
            current.setNext(nodeAdd);
            nodeAdd.setPreview(current);
            return;
        }
        add(current.getNext(), o);
    }

    @Override
    public void remove(String o) {
        if (head == null) {
            return;
        } else {
            if (head.getVal().equals(o)) {
                Node nodeRemove = head.getPreview();
                head = head.getNext();
                head.setPreview(nodeRemove);
                return;
            }
        }

        remove(head, head.getNext(), o);
    }

    private void remove(Node prev, Node current, String o) {
        if (current == null) {
            return;
        }
        if (current.getVal().equals(o)) {
            Node nodeRemove2 = current.getNext();
            prev.setNext(nodeRemove2);
            nodeRemove2.setPreview(prev);
            return;
        }
        remove(current, current.getNext(), o);
    }

    private static class Node {
        private Node preview;
        private String val;
        private Node next;


        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node preview, Node next) {
            this.preview = preview;
            this.val = val;
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        public Node getPreview() {
            return preview;
        }

        public void setPreview(Node preview) {
            this.preview = preview;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "preview=" + preview +
//                    ", val='" + val + '\'' +
//                    ", next=" + next +
//                    '}';
//        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + ((preview != null) ? preview.getVal() : null) +
                    ", val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "{" +
                head +
                '}';
    }
}
