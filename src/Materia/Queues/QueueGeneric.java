package Materia.Queues;

import java.util.NoSuchElementException;

import Materia.Models.Node;
import Materia.Models.NodeGeneric;

public class QueueGeneric <T> {
    
    
    private NodeGeneric<T>   front;
    private NodeGeneric<T>  rear;

    public Queue <T> () {
        this.front = null;
        this.rear = null;
    }

    // Método para agregar elementos a la cola
    public <T>  enqueue(int value) {
        Node newNode = new Node(value); // Corregir el error tipográfico
        if (isEmpty()) {
            front =  newNode ;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // Método para eliminar el primer elemento de la cola
    public Node dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        Node node = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return node; // Se debe devolver el nodo eliminado, no el siguiente nodo
    }

    // Método para obtener el primer elemento de la cola sin eliminarlo
    public Node peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return front;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }
}



}
