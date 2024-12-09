package Controllers;

import Materia.Models.Contact;
import Materia.Models.LinkedList;

public class ContactManager {
    
    private LinkedList<Contact<?, ?>> contacts;
    
    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void printList(){
        contacts.print();
    }

    // Agregar un contacto
    public void addContact(Contact<?, ?> contact) {
        contacts.appendToTail(contact);
    }

    // Buscar un contacto por nombre
    public Contact<?, ?> findContact(String name) {
  
        return null; // Si no se encuentra el contacto
    }

    // Eliminar un contacto por nombre
    public boolean deleteContact(String name) {
    
     
        return false; // Si no se encuentra el contacto
    }

    // Obtener todos los contactos
    public LinkedList<Contact<?, ?>> getContacts() {
        return contacts;
    }
}
