package org.larry.normal.queue;

public interface YQueue<T> {

    public boolean enQueue(T data);

    public T deQueue();
}
