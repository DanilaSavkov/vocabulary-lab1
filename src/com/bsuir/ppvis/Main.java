package com.bsuir.ppvis;

import com.bsuir.ppvis.task.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryTree bin = new BinaryTree();
        String key = new String();
        String info = new String();
        String separator = File.separator;
        String filePath = "C:" + separator + "Users" + separator + "Даник" + separator + "Desktop" + separator + "Slovar.txt";
        Scanner scanner = new Scanner(System.in);

        exit:
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
                    System.out.println("You read document by path " + filePath);
                    bin.read(filePath);
                    break;
                case 8:
                    break exit;
                default:
                    break;
            }
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