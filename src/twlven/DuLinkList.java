package twlven;

/**
 * 使用Java 语言实现双向链表
 *
 * @param <T>
 */
public class DuLinkList<T> {
    private class Node {
        private T data;
        private Node prev;
        private Node next;

        public Node() {
        }

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node header;
    private Node tail;
    private int size;

    public DuLinkList() {
        header = null;
        tail = null;
    }

    public DuLinkList(T element) {
        header = new Node(element, null, null);
        tail = header;
        size++;
    }

    public int length() {
        return size;
    }

    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    public Node getNodeByIndex(int index) {

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("双向链表越界");
        }
//        boolean half = index < size / 2;
//        Node current = half ? header : tail;
//        for(int i){
//
//        }

        // 从 header 开始遍历索引
        if (index <= size / 2) {
            Node current = header;
            for (int i = 0; i <= size / 2 && current != null; i++,current = header.next) {
                if (index == i) {
                    return current;
                }
            }
        } else {
            Node current = tail;
            for (int i = size - 1; i > size / 2 && current != null;i--, current = current.prev) {
                if (index == i) {
                    return current;
                }
            }
        }
        return null;
    }

    /**
     * 查询指定元素的索引
     *
     * @param element
     * @return
     */
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size && current != null; i++, current = header.next) {
            if (element.equals(current.data)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 向指定index 位置插入元素
     *
     * @param element
     * @param index
     */
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("链表索引越界");
        }
        if (header == null) {
            add(element);
        } else {
            if (index == 0) {
                addAtHeader(element);
            } else {
                Node prev = getNodeByIndex(index - 1);
                Node next = prev.next;
                Node newNode = new Node(element, prev, next);
                prev.next = newNode;
                next.prev = newNode;
                size++;
            }
        }
    }

    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("链表索引越界");
        }
        Node del = null;
        if (index == 0) {
            del = header;
            header = header.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            del = prev.next;
            Node next = del.next;
            prev.next = next;
            del.next = null;
        }
        size--;
        return del.data;
    }

    /**
     * 删除链表的最后一个元素
     *
     * @return
     */
    public T remove() {
        return delete(size - 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void addAtHeader(T element) {
        Node newNode = new Node(element, null, header);
        if (tail == null) {
            tail = header;
        }
        size++;
    }


    public void add(T element) {
        if (header == null) {
            header = new Node(element, null, null);
            tail = header;
        } else {
            Node newNode = new Node(element, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addFirst(T element){
        if(header == null){
            header = new Node(element,null,null);
            tail = header;
        }else {
            Node newNode = new Node(element,null,header);
            header.prev = newNode;
            header = newNode;
        }
        size++;
    }

    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.next) {
                sb.append(current.data.toString() + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }

}
