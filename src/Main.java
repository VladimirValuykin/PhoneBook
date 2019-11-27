import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        PhoneBook PhoneBook = null;
        System.out.println("Введите файл откуда прочитать/сохранить книгу");
        String path;
        path = in.nextLine();
        PhoneBook = PhoneBook.restore(path);
        if (PhoneBook == null) {
            System.out.println("Записная книга пустая, воспользуйтесь методом add и создайте контакт");
        }

        System.out.println("Введите пожалуйста команду, которую хотите выполнить: add or list or listAll or delete");

        while (true) {

            String input = in.nextLine();
            String[] arrayinput = input.split(" ", 3);
            String instruction = arrayinput[0];


            if (instruction.equals("add")) {
                String name = arrayinput[1];
                String phone = arrayinput[2];
                PhoneBook.add(name, phone);
                PhoneBook.save(path, PhoneBook);


            } else if (instruction.equals("list")) {
                String name = arrayinput[1];
                List<String> phones = PhoneBook.list(name);

                if (phones.isEmpty()) {
                    System.out.println("Нет записи с таким именем");
                } else {
                    for (String phone : phones) {
                        System.out.println(phone);
                    }
                }

            } else if (instruction.equals("listAll")) {
                Map<String, List<String>> phones = PhoneBook.listAll();
                for (Map.Entry entry : phones.entrySet()) {
                    System.out.println(entry);
                }

            } else if (instruction.equals("delete")) {
                String name = arrayinput[1];
                PhoneBook.delete(name);
                System.out.println("Вы удалили" + " " + name);
                PhoneBook.save(path, PhoneBook);

            } else if (instruction.equals("openNewPB")) {
                System.out.println("Введите файл с которого хотите прочитать Phone Book");
                path = in.nextLine();
                PhoneBook newPB = PhoneBook.restore(path);
                PhoneBook = newPB;
            } else if (instruction.equals("quit")) {
                System.exit(0);

            } else {
                System.out.println("Вы ввели не то что надо");
                System.exit(1);
            }
        }

    }

}