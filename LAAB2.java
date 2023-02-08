import java.util.Scanner;


public class LAAB2 {
        static final int Names = 1024;
        static String[] names = new String[Names];
        static int numNames = 0;
        
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Enter a name");
                System.out.println("2. Search for a name");
                System.out.println("3. Remove a name");
                System.out.println("4. Show all names");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
    
                switch (choice) {
                    case 1:
                        enterName(sc);
                        break;
                    case 2:
                        searchName(sc);
                        break;
                    case 3:
                        removeName(sc);
                        break;
                    
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } while (choice != 0);
            sc.close();
        }
    
        static void enterName(Scanner sc) {
            System.out.print("Enter a name: ");
            String name = sc.next();
            if (numNames == Names) {
                System.out.println("Array is full. Cannot enter more names.");
            } else if (isNameExists(name)) {
                System.out.println("Name already exists. Enter a unique name.");
            } else {
                names[numNames++] = name;
                System.out.println("Name entered successfully.");
            }
        }
    
        
        static void searchName(Scanner sc) {
            System.out.print("Enter a name to search: ");
            String name = sc.next();
            int index = searchNameIndex(name);
            if (index == -1) {
                System.out.println("Name not found.");
            } else {
                System.out.println("Name found at index " + index + ".");
            }
        }
    
    
        static void removeName(Scanner sc) {
            System.out.print("Enter a name to remove: ");
            String name = sc.next();
            int index = searchNameIndex(name);
            if (index == -1) {
                System.out.println("Name not found.");
            } else {
                for (int i = index; i < numNames - 1; i++) {
                    names[i] = names[i + 1];
                }
                numNames--;
                System.out.println("Name removed successfully.");
            }
        }
    }
    
}
