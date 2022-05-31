import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

class WrongStudentName extends Exception { }
class WrongStudentAge extends Exception { }
class WrongMenu extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = menu();
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                }
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Błąd w imieniu");
            }
          catch(WrongStudentAge e) {
                System.out.println("Błąd w wieku");}
          catch(WrongMenu e) {
                System.out.println("Błąd w menu");return;}
        }
    }

    public static int menu()throws WrongMenu {
        System.out.println("Wciśnij:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wypisz wszystkich studentow");
        System.out.println("3. Wyszukaj studenta po imieniu");
        System.out.println("4. Wyjdz");
      try{  
      return scan.nextInt();}
      catch(InputMismatchException e){
        throw new WrongMenu();}
    }

    public static String ReadName() throws WrongStudentName {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }


  public static int ReadAge() throws WrongStudentAge {
        System.out.println("Podaj wiek: ");
        var age = scan.nextInt();
        scan.nextLine();
        if(age<0 || age>100)throw new WrongStudentAge();
    return age;
    }

    public static void exercise1() throws IOException, WrongStudentName, WrongStudentAge {
        String name = ReadName();
        int age = ReadAge();
        System.out.println("Podaj datę urodzenia DD-MM-YYY");
        var date = scan.nextLine();
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}