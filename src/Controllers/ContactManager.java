package Controllers;

import Materia.Models.Contact;
import Materia.Models.LinkedList;
import Materia.Models.NodeGeneric;

public class ContactManager {

    private LinkedList<Contact<?, ?>> contacts;

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void printList() {
        contacts.print();
    }

    // Agregar un contacto
    public void addContact(Contact<?, ?> contact) {
        contacts.appendToTail(contact);
    }

    // Buscar un contacto por nombre
    public Contact<?, ?> findContact(String name) {
        NodeGeneric<Contact<?, ?>> current = contacts.getHead();

        while (current != null) {

            if (current.getValue().getName() != null && current.getValue().getName().equals(name)) {
                return current.getValue();
            }
            current = current.getNext();
        }

        return null;
    }

    // Eliminar un contacto por nombre1

    public void deleteContact(String name) {
        NodeGeneric<Contact<?, ?>> current = contacts.getHead();

        if (current == null)
            return;

        if (((String) current.getValue().getName()).equalsIgnoreCase(name)) {
            contacts.setHead(contacts.getHead().getNext());
            contacts.setSize(contacts.getSize() - 1);
        }

        while (current.getNext() != null) {
            if (((String) current.getNext().getValue().getName()).equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext());
                contacts.setSize(contacts.getSize() - 1);
            }

        }
        // Si no se encuentra el contacto
    }

    // Obtener todos los contactos
    public LinkedList<Contact<?, ?>> getContacts() {
        return contacts;
    }
}
