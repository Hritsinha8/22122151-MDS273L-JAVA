import java.util.ArrayList;
import java.util.Scanner;

public class Lab2{
  private static final int MAX_LENGTH = 1024;
  private static ArrayList<String> names = new ArrayList<>(MAX_LENGTH);
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int choice;
    do {
      System.out.println("\n\nMenu Options:");
      System.out.println("1. Enter a name");
      System.out.println("2. Search for a name");
      System.out.println("3. Remove a name");
      System.out.println("4. Show all names");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          enterName();
          break;
        case 2:
          searchName();
          break;
        case 3:
          removeName();
          break;
        case 4:
          showAllNames();
          break;
        case 5:
          System.out.println("Exiting the program.");
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    } while (choice != 5);
  }

  private static void enterName() {
    System.out.print("Enter your choice of name: ");
    String name = sc.next();
    if (names.contains(name)) {
      System.out.println("Name already exists. Try again.");
      return;
    }
    if (names.size() == MAX_LENGTH) {
      System.out.println("Array is full. Cannot add more names.");
      return;
    }
    names.add(name);
    System.out.println("Name added successfully.");
  }

  private static void searchName() {
    System.out.print("Enter a name to search: ");
    String name = sc.next();
    int index = names.indexOf(name);
    if (index == -1) {
      System.out.println("Name not found.");
    } else {
      System.out.println("Name found at index " + index);
    }
  }

  private static void removeName() {
    System.out.print("Enter a name to remove: ");
    String name = sc.next();
    int index = names.indexOf(name);
    if (index == -1) {
      System.out.println("Name not found.");
    } else {
      names.remove(index);
      System.out.println("Name removed successfully.");
    }
  }

  private static void showAllNames() {
    System.out.println("\nAll names:");
    for (int i = 0; i < names.size(); i++) {
      System.out.println(i + ". " + names.get(i));
    }
  }
}
