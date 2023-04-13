//*
 /*
 * 
 * 
 *  
 */
package KAUdbms;

/**
 *
 * @author Admin
 */
public class KAUcourse {

    private String ID;
    private int grade;
    private int num;
    private int sum;
    private KAUcourse next;

    public KAUcourse(String ID, int grade, int num) {
        this.ID = ID;
        this.grade = grade;
        this.sum = sum;
        this.num = num;
    }

    public KAUcourse(String ID, int num, int grade, KAUcourse next) {
        this.ID = ID;
        this.grade = grade;
        this.num = num;
        this.next = next;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        
        this.num = num;
    }

    public KAUcourse getNext() {
        return next;
    }

    public void setNext(KAUcourse next) {
        this.next = next;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        if (getNum() ==0) {
            this.sum = sum;
        }else{
            this.sum += sum;
        }
        
    }

}
