import java.io.*;
import java.util.*;

public class PhoneBook{


    private Map<String, List<String>> phones = new HashMap<>();

    public void add(String name, String phone) {

        if (phones.containsKey(name)) {
            List<String> userPhones = phones.get(name);
            if (!userPhones.contains(phone)) {
                userPhones.add(phone);
            }

        } else {
            List<String> userPhones = new ArrayList<>();
            userPhones.add(phone);
            phones.put(name, userPhones);
        }
    }

    public List<String> list(String name) {

        return phones.getOrDefault(name, Collections.emptyList());

    }

    public Map<String, List<String>> listAll() {

        return phones;
    }

    public void delete(String name) {

        phones.remove(name);
    }

    public static PhoneBook restore(String pathFile) throws FileNotFoundException {

        BufferedReader bufferedReader = null;

        try {

            PhoneBook restorePhoneBook = new PhoneBook();
            File file = new File(pathFile);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String namePhone;
            while ((namePhone = bufferedReader.readLine()) != null) {
                String[] arrayNamePhone = namePhone.split(" ");

                for (int i = 1; i < arrayNamePhone.length;
                     i++) {

                    restorePhoneBook.add(arrayNamePhone[0], arrayNamePhone[i]);
                }
            }

            return (restorePhoneBook);

        } catch (
                IOException e) {
            e.printStackTrace();

        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (null);
    }

    public static void save(String pathFile, PhoneBook WriterPhoneBook) throws IOException {

        BufferedWriter bufferedWriterNamePhone = null;

        try {
            File file = new File(pathFile);
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriterNamePhone = new BufferedWriter(fileWriter);

            for (String name : WriterPhoneBook.phones.keySet()) {
                for (String listPhones : WriterPhoneBook.phones.get(name)) {
                    bufferedWriterNamePhone.write(name + " ");
                    bufferedWriterNamePhone.write(listPhones + "\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (bufferedWriterNamePhone != null) {
                    bufferedWriterNamePhone.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}