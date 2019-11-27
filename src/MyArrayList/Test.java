package MyArrayList;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        MyArrayList list = new MyArrayList(2);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.remove(-1);
        list.remove(2);
        list.remove(0);
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException("Condition is not satisfied: " + message);
        }
    }

    static class MyArrayList {

        int counterIndex = 0;
        private String array[];

        public MyArrayList(int initialCapacity) {
            this.array = new String[initialCapacity];
        }

        public void add(String element) {
            if (array.length <= counterIndex) {
                String[] arrayNew = new String[array.length * 2];
                for (int counterIndex = 0; counterIndex < array.length; counterIndex++) {
                    arrayNew[counterIndex] = array[counterIndex];
                }
                this.array = arrayNew;
            }
            array[counterIndex] = element;
            counterIndex++;
        }

        public Optional<String> get(int index) {
            for (int i = 0; (i <= counterIndex) && (i >= counterIndex); i++) {
                if (array[i].equals(array[index])) {
                    return Optional.of(array[i]);
                }
            }
            return Optional.empty();
        }

        public boolean contains(String element) {
            for (String e : array) {
                if (element.equals(e)) {
                    return true;
                }
            }
            return false;
        }

        public void remove(int index) {
            String[] arrayNewRemove = new String[array.length - 1];
            for (int i = index + 1; i <= array.length - 1; i++) {
                array[i - 1] = array[i];
            }
            for (int j = 0; j < array.length - 1; j++) {
                arrayNewRemove[j] = array[j];
            }
            this.array = arrayNewRemove;
        }

        public int indexOf(String element) {
            for (int i = 0; i <= counterIndex; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
            return -1;
        }

        public int size() {
            return array.length;
        }
    }
}
//for (int i = 0; i <= counterIndex; i++) {
//if (array[index].equals(array[i])) {
// String[] arrayNewRemove = new String[array.length];
// for (int is = index + 1; is < counterIndex - 1; is++) {
// array[is - 1] = array[is];
// }
//  }
// }
// for (String e: array){
//  System.out.println(e);
//  }
//int counterIndexRemove = 0;
//  String[] arrayNewRemove = new String[array.length];
//        for (int i = index + 1; i < array.length - 1; i++) {
//  array[i - 1] = arrayNewRemove[counterIndexRemove];
//counterIndexRemove++;
//}