import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryTree bin = new BinaryTree();
        String key = new String();
        String info = new String();
        String separator = File.separator;
        String filePath = "C:" + separator + "Users" + separator + "nikit" + separator + "OneDrive" + separator + "Desktop" + separator + "Slovar.txt";
        boolean check = false;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            switch (menu(scanner)) {
                case 1:
                    System.out.println("Enter the english word: ");
                    key = scanner.next();
                    System.out.println("Enter translation of english word: ");
                    info = scanner.next();
                    bin.add(key, info);
                    break;
                case 2:
                    System.out.println("Enter the english word, you want to rewrite: ");
                    key = scanner.next();
                    System.out.println("Enter new translation of english word: ");
                    info = scanner.next();
                    bin.rewrite(key, info);
                    break;
                case 3:
                    System.out.println("Enter the english word, you want to delete: ");
                    key = scanner.next();
                    bin.delete(key);
                    break;
                case 4:
                    bin.print();
                    break;
                case 5:
                    System.out.println("Enter the english word, you want to translate: ");
                    key = scanner.next();
                    System.out.println(bin.search(key));
                    break;
                case 6:
                    System.out.println(bin.size());
                    break;
                case 7:
                    bin.read(filePath);
                    System.out.println("You read document by path C:" + separator + "Users" + separator + "Даник" + separator + "Desktop" + separator + "Словарь.txt");
                    break;
                case 8:
                    check = true;
                    break;
                default:
                    break;
            }
            if (check) break;
            System.out.println();
        }
        scanner.close();
    }

    public static int menu(Scanner scanner) {
        System.out.println("1. Добавить новую пару слов.");
        System.out.println("2. Заменить перевод английского слова.");
        System.out.println("3. Удалить пару слов.");
        System.out.println("4. Распечатать словарь.");
        System.out.println("5. Найти перевод английского слова.");
        System.out.println("6. Узнать количество слов.");
        System.out.println("7. Загрузка из документа.");
        System.out.println("8. Завершить выполнение программы.");

        return scanner.nextInt();
    }
}