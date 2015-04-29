package Pack;

import java.util.Random;

/**
 * Created by tonyf_000 on 2015-04-24.
 */
public class Student extends Human{
    int startYear;
    static Random rand = new Random();
    public Student(int inAge, String inName, int year){
        super(inAge,inName);
        if (year-(2015-inAge)>15 && isBetween(year)){
            startYear = year;}
        else{
            throw new IllegalArgumentException("  "+String.valueOf(year)+"-2015+"+String.valueOf(getAge())+"<=15");



    }}

    public Student(){
        this(makeAge(), makeName(), makeYear());
    }

    private static int makeYear(){
        return rand.nextInt((2015-1934)+1) + 1934;
    }

    public static boolean isBetween(int year){
        return((year > 1934) && (year < 2015));
    }

    public int getYear(){
        return startYear;
    }

    public String toString(){
        return super.toString()+" Började CSAMH år: "+getYear();
    }


}
