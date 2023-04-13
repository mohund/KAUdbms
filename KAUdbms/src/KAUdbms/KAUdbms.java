//*
 /*
 * 
 *
 *  
 */
package KAUdbms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class KAUdbms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File ReadFile = new File("KAUdbms.in.txt");
        Scanner input = new Scanner(ReadFile);// Scanner for the input file 
        File OutPutFile = new File("KAUdbms.out.txt");
        PrintWriter OutPutFileWrite = new PrintWriter(OutPutFile);
        int Range = input.nextInt();// in the input file the first  line contain one positive integer, which represents the number of commands (lines) following that line in the input file. 
        KAUdbmsBST STUDENT = new KAUdbmsBST();
        KAUcourses allcourse = new KAUcourses();
        int num = 1;
        
        for (int i = 0; i < Range; i++) {
            String Command = input.next();// read the Command's
          
            if (Command.equalsIgnoreCase("NEWSTUDENT")) {
                int ID = input.nextInt();
                String Firstname= input.next();
                String Lastname= input.next();
                STUDENT.insert(ID, Firstname,Lastname, input.next(), input.nextInt(), input.nextInt());
                OutPutFileWrite.println("NEWSTUDENT Command\n" +
"	"+Firstname+" "+ Lastname+" (ID "+ID +") has been inserted as a new student in KAUdbms.");
            }
            if (Command.equalsIgnoreCase("ADDCOURSE")) {
                OutPutFileWrite.println();
                int IDnumber = input.nextInt();
                String Id = input.next();
                int grade = input.nextInt();
                KAUstudent STUDENTID = STUDENT.findNode(IDnumber);

                if (STUDENTID != null) {
                

                    STUDENTID.setCourses(IDnumber, Id, num, grade, OutPutFileWrite);
                    allcourse.InsertAllCourses(Id, num, grade, OutPutFileWrite);
                    STUDENTID.setLevel(STUDENTID.getCourses());
                    STUDENTID.setGpa();

                } else {
                    OutPutFileWrite.println("ADDCOURSE Command\n"
                            + "	ERROR: cannot add course. Student ID # " + IDnumber + " was not found in KAUdbms.");
                   
                }
                OutPutFileWrite.flush();
            }
            if (Command.equalsIgnoreCase("PRINTRECORD")) {
                String FirstName = input.next();
                String LastName = input.next();
             
                //Bilal Zahrani

                STUDENT.printRecords(FirstName, LastName, OutPutFileWrite);

                OutPutFileWrite.flush();

            }
            if (Command.equalsIgnoreCase("SEARCHNAME")) {
                String FirstName = input.next();
                String LastName = input.next();
                KAUstudent StudentNameSera = STUDENT.findNodeName(FirstName, LastName);
                if (StudentNameSera != null) {
                    OutPutFileWrite.println("SEARCHNAME Command\n"
                            + " 	" + FirstName + " " + LastName + " was  found in FCITbook.");
                } else {
                    OutPutFileWrite.println("SEARCHNAME Command\n"
                            + " 	" + FirstName + " " + LastName + " was not found in FCITbook.");

                }
                OutPutFileWrite.flush();
            }
            if (Command.equalsIgnoreCase("SEARCHID")) {
                int Searchid = input.nextInt();
                if (STUDENT.search(Searchid)) {
                    OutPutFileWrite.println("SEARCHID Command\n"
                            + "	ID " + Searchid + " was  found in FCITbook.");
                } else {
                    OutPutFileWrite.println("SEARCHID Command\n"
                            + "	ID " + Searchid + " was not found in FCITbook.");
                }
                OutPutFileWrite.flush();
            }
            if (Command.equalsIgnoreCase("DELETE")) {
                String FirstName = input.next();
                String LastName = input.next();

                STUDENT.delete(FirstName, LastName, OutPutFileWrite);
            }
            if (Command.equalsIgnoreCase("PRINTALLRECORDS")) {
                STUDENT.PRINTALLRECORDS(OutPutFileWrite);

            }
            if (Command.equalsIgnoreCase("PRINTALLCOURSES")) {
                OutPutFileWrite.println("PRINTALLCOURSES Command\n"
                        + "	All courses saved in KAUdbms: \n 	COURSE NAME         AVERAGE GRADE");
                allcourse.Print(OutPutFileWrite);
            }

        }
          OutPutFileWrite.flush();


    }

}
