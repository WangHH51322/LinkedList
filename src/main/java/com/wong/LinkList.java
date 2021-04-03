package com.wong;

public class LinkList<T> extends AbstractList<T>{

    private Node<T> first;
    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    /**
     * 获取index位置对应的node节点
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return node(index).element;
    }

    /**
     * 替换index位置处的element并返回旧element
     * @param index
     * @param element
     * @return
     */
    @Override
    public T set(int index, T element) {
        Node<T> node = node(index);
        T old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        if (index == 0) {
            Node<T> node = new Node<>(element, first);
            first = node;
        } else {
            Node<T> preNode = node(index - 1);
            Node<T> nextNode = preNode.next;
            Node<T> node = new Node<>(element, nextNode);
            preNode.next = node;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> oldNode = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<T> preNode = node(index - 1);
            oldNode = preNode.next;
            preNode.next = oldNode.next;
        }
        size --;
        return oldNode.element;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = this.first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     *获取index位置对应的node节点
     * @param index
     * @return
     */
    private Node<T> node(int index) {
        rangeCheck(index);
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        Node<T> node = first;
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();

//        Node<T> node1 = first;
//        while (node1 != null) {
//
//            node1 = node1.next;
//        }
    }
}
