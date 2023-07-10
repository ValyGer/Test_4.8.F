import java.util.ArrayList;
import java.util.List;

// Ограничьте класс ContactBook так, чтобы он мог хранить в себе только список контактов
public class ContactBook<T extends Contact> {
    // Объявите поле класса contacts - список контактов книги
    List<Contact> contacts = new ArrayList<>();

    public void addContact(T contact) {
        contacts.add(contact);
    }

    public void printList() {
        // Выведите на экран весь список контактов книги
        for (Contact contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }
    }

    public void congratulate(String name) {
        int number = 0;
        boolean contactPresented = false; //проверяем есть ли контакт в базе
        // Найдите контакт в книге по имени, и отправьте ему сообщение с помощью метода sendMessage()
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (name.equals(contact.getName())) {
                contactPresented = true;
                number = i;
            }
        }
        if (contactPresented) {
            Contact contact = contacts.get(number);
            System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
            contact.sendMessage();
        } else {
            // Если контакт не найден, выведите соответсвующее сообщение
            System.out.println("Не найден контакт с указанным именем.");
        }
    }
}

