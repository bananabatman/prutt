package Pack;

import java.util.Random;

public class Human {
    String name;
    int age;
    static Random Dice = new Random();
    static String[] randNames = {"Adam", "Bertil", "Caesar", "David", "Erik", "Filip", "Gustav","Helge","Ivar"};

    public Human(){
        this(makeAge(), makeName());
    }

    public Human(int ageIn, String nameIn){
        age = ageIn;
        name = nameIn;
    }

    public static int makeAge(){
        return (int)Math.round(Math.random()*100);
    }

    public static String makeName(){
        return randNames[Dice.nextInt(randNames.length)];
    }

    public String toString(){
        return "namn:"+" "+this.getName()+", ålder: "+this.getAge();
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }
}
