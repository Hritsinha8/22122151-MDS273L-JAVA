import java.util.*;
class Lab1 {
    public static void main(String[] args){
        String Name;
        int Age;
        String Class;
        char Gender;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Name,Age,Class");
        Name = scan.nextLine();
        Age = Integer.parseInt(scan.nextLine());
        Class = scan.nextLine();
        System.out.println("Name :"+Name+"\nAge :"+Age+"\nClass :"+Class);
        System.out.println("Enter M/F:");
        Gender = scan.nextLine().charAt(0);
        if(Gender=='M'){
            System.out.println("Gender: Male");
        }else if (Gender=='F'){
            System.out.println("Gender : Female ");
        }else{
            System.out.println("Enter a valid choice!!");
        }
        String State;
        System.out.println("Enter  State SOUTH/NORTH/EAST/WEST :");
        State =scan.nextLine();
        switch(State){
            case "SOUTH":
                System.out.println("The Student is from Southern states of India");
                break;
            case "NORTH":
                System.out.println("The Student is from Northern states of India");
                break;
            case "EAST":
                System.out.println("The Student is from Eastern states of India");
                break;
            case "WEST":
                System.out.println("The Student is from Western states of India");
                break;
            default:
                System.out.println("Enter a valid choice");
        }

        
    }
}
