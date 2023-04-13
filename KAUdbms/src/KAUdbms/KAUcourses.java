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
public class KAUcourses {

    private KAUcourse head;
    PrintWriter OutPutFile;

    public KAUcourse getHead() {
        return head;
    }
    int idstudent;
    int numberOfcourser;
    public int sum = 0;

    public void insert(int idstudent, String ID, int num, int grade, PrintWriter OutPutFileWrite) { //Takes only data to be inserted
        this.OutPutFile = OutPutFileWrite;
        this.idstudent = idstudent;
          numberOfcourser+=1;
        head = insert(head, ID, idstudent, grade, OutPutFileWrite);

    }

    private KAUcourse insert(KAUcourse head, String ID, int num, int grade, PrintWriter OutPutFileWrite) {
        int Check = Integer.parseInt(ID.substring(4));
        if (head == null || Integer.parseInt(head.getID().substring(4)) > Check) {
            numberOfcourser += 1;
            head = new KAUcourse(ID, num, grade, head);
           
            OutPutFileWrite.println("ADDCOURSE Command\n"
                    + "	" + ID + "(Grade: " + grade + ") has been added to the record of Student ID " + num + ".");
            return head;
        } else {
            boolean flag = true;

            KAUcourse helpPtr = head;

            while (helpPtr.getNext() != null) { //Traversing the entire link list
                if (helpPtr.getID().equalsIgnoreCase(ID)) {
                    update(helpPtr, grade);
                    flag = false;
                    break;
                }
                helpPtr = helpPtr.getNext();
            }
            if (flag) {
                if (helpPtr.getID().equalsIgnoreCase(ID)) {
                    helpPtr.setSum(grade);
                    updateAllCourses(helpPtr, grade);

                } else {
                    KAUcourse helpPtrrrr = head;
                    while (helpPtrrrr.getNext() != null) {
                        if (Integer.parseInt(helpPtrrrr.getNext().getID().substring(4)) > Check) { //if data of next (i.e. successor) node is 
                            //greater than the data we want to insert after the current node
                            break; // we found our spot and should break out of the while loop

                        }
                        helpPtrrrr = helpPtrrrr.getNext();

                    }
                    KAUcourse newNode = new KAUcourse(ID, num, grade, helpPtrrrr.getNext());
                    //numberOfcourser++;
                    newNode.setSum(grade);
                    helpPtrrrr.setNext(newNode);

                }
                OutPutFileWrite.println("ADDCOURSE Command\n"
                        + "	" + ID + "(Grade: " + grade + ") has been added to the record of Student ID " + num + ".");
            }
            //numberOfcourser++;

        }

        return head;
    }

    public KAUcourse InsertAllCourses(String ID, int num, int grade, PrintWriter OutPutFileWrite) {
        this.OutPutFile = OutPutFileWrite;
        int Check = Integer.parseInt(ID.substring(4));
        if (head == null || Integer.parseInt(head.getID().substring(4)) > Check) {
            num = 1;
            head = new KAUcourse(ID, num, grade, head);
            head.setSum(grade);
            return head;
        } else {
            boolean flag = true;

            KAUcourse helpPtr = head;

            while (helpPtr.getNext() != null) { //Traversing the entire link list
                if (helpPtr.getID().equalsIgnoreCase(ID)) {
                    helpPtr.setSum(grade);
                    updateAllCourses(helpPtr, grade);

                    flag = false;
                    break;
                }
                helpPtr = helpPtr.getNext();
            }
            if (flag) {
                if (helpPtr.getID().equalsIgnoreCase(ID)) {
                    helpPtr.setSum(grade);
                    updateAllCourses(helpPtr, grade);

                } else {
                    KAUcourse helpPtrrrr = head;
                    while (helpPtrrrr.getNext() != null) {
                        if (Integer.parseInt(helpPtrrrr.getNext().getID().substring(4)) > Check) { //if data of next (i.e. successor) node is 
                            //greater than the data we want to insert after the current node
                            break; // we found our spot and should break out of the while loop

                        }
                        helpPtrrrr = helpPtrrrr.getNext();

                    }
                    KAUcourse newNode = new KAUcourse(ID, num, grade, helpPtrrrr.getNext());

                    newNode.setSum(grade);
                    helpPtrrrr.setNext(newNode);
                }
            }

        }

        return head;
    }

    public void update(KAUcourse helpPtr, int grade) {
        helpPtr.setGrade(grade);
        OutPutFile.println("ADDCOURSE Command\n"
                + "	" + helpPtr.getID() + ": grade has been changed/updated, to a " + grade + ", for Student ID " + idstudent + ".");
        OutPutFile.flush();
    }

    public void updateAllCourses(KAUcourse helpPtr, int grade) {
        helpPtr.setGrade(grade + helpPtr.getGrade());
        helpPtr.setNum(helpPtr.getNum() + 1);
    }

    public void Print(PrintWriter OutPutFileWrite) {
//        PrintWriter OutPutFile = OutPutFileWrite;
        KAUcourse helpPtrr = head;
        while (helpPtrr != null) {
            OutPutFile.println("	" + helpPtrr.getID() + "                " + helpPtrr.getSum() / helpPtrr.getNum());
            helpPtrr = helpPtrr.getNext();
        }

    }

    public int numberOfKAUcourse() {

        return numberOfcourser;
    }

    public double gpa() {
        KAUcourse headPtr = head;

        double Grade;
        double Subtotal = 0;
        double number = 0;

        while (headPtr != null) {
            if (headPtr.getGrade() >= 90) {
                Grade = 5;
                Subtotal += 3 * Grade;
                ++number;
            }
            if (headPtr.getGrade() >= 80 && headPtr.getGrade() <= 89) {
                Grade = 4;
                Subtotal += 3 * Grade;
                ++number;
            }
            if (headPtr.getGrade() >= 70 && headPtr.getGrade() <= 79) {
                Grade = 3;
                Subtotal += 3 * Grade;
                ++number;
            }
            if (headPtr.getGrade() >= 60 && headPtr.getGrade() <= 69) {
                Grade = 2;
                Subtotal += 3 * Grade;
                ++number;
            }
            if (headPtr.getGrade() < 60) {
                Grade = 0;
                Subtotal += 3 * Grade;
                ++number;
            }

            headPtr = headPtr.getNext();

        }
        if (number != 0) {
            return Subtotal / (3 * number);
        } else {
            return 0;
        }
    }

}
