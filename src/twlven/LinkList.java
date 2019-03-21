package twlven;


/**
 * 使用 Java 语言实现 单链表
 *
 * @param <T>
 */
public class LinkList<T> {
    /**
     * 定义节点
     */
    private class Node {
        // 数据
        private T data;
        // 指向下一个节点的引用 next
        private Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // 链表的头节点
    private Node header;
    // 链表的尾节点
    private Node tail;
    private int size;

    // 初始化一个空链表
    public LinkList() {
        header = null;
        tail = null;
    }

    public LinkList(T elelment) {
        header = new Node(elelment, null);
        tail = header;
        size++;
    }

    public int length() {
        return size;
    }

    // 获取 index 处的元素
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("链表索引越界");
        }
        Node current = header;
        for (int i = 0; i < size && current != null; i++, current = header.next) {
            if (index == i) {
                return current;
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
        if (index < 0 || index > size ) {
            throw new IndexOutOfBoundsException("链表索引越界");
        }
        if (header == null) {
            add(element);
        } else {
            if (index == 0) {
                addAtHeader(element);
            } else {
                Node prev = getNodeByIndex(index - 1);
                prev.next = new Node(element, prev.next);
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
            prev.next = del.next;
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

    /**
     * 在链表头部插曲数据
     *
     * @param element
     */
    private void addAtHeader(T element) {
        Node newNode = new Node(element, header);
        if (tail == null) {
            tail = header;
        }
        size++;
    }

    public void add(T element) {
        if (header == null) {
            header = new Node(element, null);
            tail = header;
        } else {
            Node newNode = new Node(element, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
}
