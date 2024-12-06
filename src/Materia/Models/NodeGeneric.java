package Materia.Models;

public class NodeGeneric <T> {
    private T value;
    private NodeGeneric<T> next;

    public NodeGeneric(T value){
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString(){
        return "Node [value=]" + value + "]";
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeGeneric getNext() {
        return next;
    }

    public void setNext(NodeGeneric next) {
        this.next = next;
    }
    

}
