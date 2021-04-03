package com.wong;

public abstract class AbstractList<T> implements List<T>{

    /**
     * 元素的数量
     */
    protected int size;


    /**
     * 获取元素的数量
     * @return
     */
    public int size() {
        return size;
    }
    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    /**
     * 添加元素到末尾
     * @param element
     */
    public void add(T element) {
        add(size,element);
    }
    /**
     * 抛出异常
     * @param index
     */
    protected void OutOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index=" + index + ",Size=" + size);
    }
    /**
     * 判断传入的index是否超出范围
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            OutOfBounds(index);
        }
    }
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            OutOfBounds(index);
        }
    }
}
