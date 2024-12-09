package Controllers;

import Materia.Models.Contact;
import Views.ConsoleView;
import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView ConsoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.ConsoleView = new ConsoleView();
    }

    public void showMenu() {
        boolean exit = true;
        while (exit) {
            ConsoleView.displayMenu();
            String option = ConsoleView.getInput("");
            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    printList();
                    break;
                case "5":
                    exit = false;  // Cambié exit a false para salir correctamente
                    ConsoleView.showMessage("Exiting................");
                    break;
                default:
                    ConsoleView.showMessage("Invalid option.");
                    break;
            }
        }
    }

    private void printList() {
        // Mostrar todos los contactos
        ConsoleView.showMessage("Printing list of contacts:");
        List<Contact<String, String>> contacts = contactManager.getContacts();
        if (contacts.isEmpty()) {
            ConsoleView.showMessage("No contacts available.");
        } else {
            for (Contact<String, String> contact : contacts) {
                ConsoleView.showMessage("Name: " + contact.getName() + ", Phone: " + contact.getPhone());
            }
        }
    }

    private void findContact() {
        // Buscar un contacto por nombre
        String name = ConsoleView.getInput("Enter the name of the contact to find: ");
        Contact<String, String> contact = contactManager.findContact(name);
        if (contact != null) {
            ConsoleView.showMessage("Contact found: Name: " + contact.getName() + ", Phone: " + contact.getPhone());
        } else {
            ConsoleView.showMessage("Contact not found.");
        }
    }

    private void deleteContact() {
        // Eliminar un contacto por nombre
        String name = ConsoleView.getInput("Enter the name of the contact to delete: ");
        boolean success = contactManager.deleteContact(name);
        if (success) {
            ConsoleView.showMessage("Contact deleted.");
        } else {
            ConsoleView.showMessage("Contact not found.");
        }
    }

    private void addContact() {
        // Agregar un nuevo contacto
        String name = ConsoleView.getInput("Enter name: ");
        String phone = ConsoleView.getInput("Enter phone: ");
        Contact<String, String> contact = new Contact<>(name, phone);
        contactManager.addContact(contact);
        ConsoleView.showMessage("Contact Added");
    }
}
