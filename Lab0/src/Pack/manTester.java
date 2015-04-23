package Pack;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

public class manTester {
    static ArrayList peopleList;
    static ArrayList studentList;
    static ArrayList mixedList;

    public static void main(String args[]) {
        System.out.println("--FÖRSTA UPPGIFTEN--");
        Human ulf = new Human(38, "Ulf");
        System.out.println(ulf.getAge() + " | " + ulf.getName());
        System.out.println(ulf.toString());
        System.out.println(ulf + "\nNot Worky ");
        System.out.println();

        peopleList = new ArrayList<Human>(15);
        studentList = new ArrayList<Student>(15);
        mixedList = new ArrayList<Human>(10);
        for (int i = 0; i < 15; i++) {
            Human newHuman = new Human();
            peopleList.add(newHuman);
            newHuman.toString();

        }
        System.out.println("\n" +
                "\n--ANDRA UPPGIFTEN--");
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println(peopleList.get(i));
        }

        for (int i = 0; i < 5; i++) {
            Human newHuman = new Human();
            mixedList.add(newHuman);
        }
        int studentCounter = 0;
        while (studentCounter <= 20) {
            try {
                Student technoLog = new Student();
                if(studentCounter<=15){
                    studentList.add(technoLog);
                }
                else{
                    mixedList.add(technoLog);
                }
                studentCounter++;


            } catch (IllegalArgumentException e) {
                System.out.println("Här slumpades det fel!" + e.getMessage());
            }
        }

        System.out.println("\n" +
                "\n--TREDJE UPPGIFTEN--");

        for(int i=0;i<studentList.size();i++){
            System.out.println(studentList.get(i));
        }

        System.out.println("\n\n--FJÄRDE UPPGIFTEN--");

        for(int i=0; i<mixedList.size();i++){
            System.out.println(mixedList.get(i));
        }


    }
}

