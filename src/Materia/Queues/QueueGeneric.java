package Materia.Queues;

import java.util.NoSuchElementException;
import Materia.Models.NodeGeneric;

public class QueueGeneric<T> {

    private NodeGeneric<T> front;
    private NodeGeneric<T> rear;

    public QueueGeneric() {
        this.front = null;
        this.rear = null;
    }

    
    public void enqueue(T value) {
        NodeGeneric<T> newNode = new NodeGeneric<>(value); 
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }


    public NodeGeneric<T> dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        NodeGeneric<T> node = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return node; 
    }

    public NodeGeneric<T> peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return front;
    }


    public boolean isEmpty() {
        return front == null;
    }
}
