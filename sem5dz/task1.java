package sem5dz;

import java.util.*;

public class task1 {
    private Map<String, Set<String>> contacts;

    public task1() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        Set<String> phoneNumbers = contacts.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public void printContacts() {
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(contacts.entrySet());
        Collections.sort(sortedEntries, (entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            System.out.println("На имя " + name + " Номеров:" + phoneNumbers.size());

            for (String phoneNumber : phoneNumbers) {
                System.out.println(phoneNumber);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task1 phoneBook = new task1();

        System.out.println("Введите имя латиницей и номер телефона абонента. напишите 'done', когда закончите");
        String input;

        while (true) {
            System.out.print("Имя: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            String name = input;

            System.out.print("Номер: ");
            String phoneNumber = scanner.nextLine();

            phoneBook.addContact(name, phoneNumber);
        }

        System.out.println("\nСписок контактов:");
        phoneBook.printContacts();
    }
}
