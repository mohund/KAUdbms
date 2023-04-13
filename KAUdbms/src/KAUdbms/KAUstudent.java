/*
 /*
 * 
 * 
 *  
 */

 
package KAUdbms;

import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class KAUstudent {

    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int phone;
    private int level;
    private KAUcourses courses;
    private double gpa;
    private KAUstudent left;
    private KAUstudent right;

    public KAUstudent(int ID, String firstName, String lastName, String email, int age, int phone) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.left = null;
        this.right = null;
    }

    public KAUstudent(int ID, String firstName, String lastName, String email, int age, int phone, int level, KAUcourses courses, double gpa, KAUstudent left, KAUstudent right) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.level = level;
        this.courses = courses;
        this.gpa = gpa;
        this.left = left;
        this.right = right;
    }

    public KAUstudent(int ID, String firstName, String lastName, String email, int age, int phone, int level, KAUstudent left, KAUstudent right) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.level = level;
        this.left = left;
        this.right = right;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getLevel() {
//        int zzlevel = level;
        if (level < 2) {
            return 1;
        } else {
            return level ;
        }
    }

    public void setLevel(KAUcourses getCourses) {
        int levelnumber = courses.numberOfKAUcourse();

        if (levelnumber >= 30) {
            this.level = 4;
        } else if (levelnumber >= 20) {
            this.level = 3;
        } else if (levelnumber >= 10) {
            this.level = 2;
        } else if (levelnumber < 10) {
            this.level = 1;
        }

    }

    public void setLevel(int Level) {

        this.level = Level;
    }

    public KAUcourses getCourses() {
        return courses;
    }

    public void setCourses(int IDnumber, String ID, int num, int grade , PrintWriter OutPutFileWrite) {
        if (courses == null) {
            courses = new KAUcourses();
        }
        this.courses.insert(IDnumber, ID, num, grade , OutPutFileWrite);

    }
    public void setCourses(KAUcourses getCourses) {
       
        this.courses =getCourses ;

    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa() {

        this.gpa = getCourses().gpa();
    }

    public void setGpa(double gpa) {

        this.gpa = gpa;
    }

    public KAUstudent getLeft() {
        return left;
    }

    public void setLeft(KAUstudent left) {
        this.left = left;
    }

    public KAUstudent getRight() {
        return right;
    }

    public void setRight(KAUstudent right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "KAUstudent{" + "ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age + ", phone=" + phone + ", level=" + level + ", courses=" + courses + ", gpa=" + gpa + ", left=" + left + ", right=" + right + '}';
    }

}
