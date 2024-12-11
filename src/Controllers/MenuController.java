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
                    exit = false; // Cambié exit a false para salir correctamente
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
        contactManager.printList();
    }

    private void findContact() {
        String name = ConsoleView.getInput("Entrer a name to Search");
        Contact<?, ?> contact = contactManager.findContact(name);
        if (contact != null) {
            ConsoleView.showMessage("Contact Found: " + contact);
        }

    }

    private void deleteContact() {
        String name = ConsoleView.getInput("Entrer a name to Search");
        contactManager.deleteContact(name);
        ConsoleView.showMessage("Contact deleted if exist");
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
