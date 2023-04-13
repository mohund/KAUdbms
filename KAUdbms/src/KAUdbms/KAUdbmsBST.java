
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
public class KAUdbmsBST {

    private KAUstudent root;

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    ;
    public void insert(int ID, String firstName, String lastName, String email, int age, int phone) {

        KAUstudent NewNod = new KAUstudent(ID, firstName, lastName, email, age, phone);
        root = insert(root, NewNod);

    }

    private KAUstudent insert(KAUstudent root, KAUstudent NewNod) {
        if (root == null) {
            return NewNod;
        } else {
            if (NewNod.getID() > root.getID()) {
                // Recursively insert into the right subtree
                // The result of insertion is an updated root of the right subtree
                KAUstudent temp = insert(root.getRight(), NewNod);
                // Save this newly updated root of right subtree into p.right
                root.setRight(temp); //i.e. p.Right = temp;
            } // Insert to the LEFT of root
            else {
                // Recursively insert into the left subtree
                // The result of insertion is an updated root of the left subtree
                KAUstudent temp = insert(root.getLeft(), NewNod);
                // Save this newly updated root of left subtree into p.left
                root.setLeft(temp); //i.e. p.Left = temp;
            }

        }
        return root;

    }

    ;
public boolean search(int a) {//parameters here
        return search(a, root);
    }

    private boolean search(int a, KAUstudent root) {
        if (root == null) {
            return false;
        } else {
            if (a == root.getID()) {
                return true;
            } else if (a != root.getID()) {
                return search(a, root.getLeft());
            } else {
                return search(a, root.getRight());
            }
        }
    }

    ;
public KAUstudent findNode(int Id) {
        return findNode(Id, root);
    }

    private KAUstudent findNode(int Id, KAUstudent root) {
        if (root == null) {
            return null;
        } else {
            if (Id == root.getID()) {
                return root;
            } else if (Id > root.getID()) {
                return findNode(Id, root.getRight());
            } else {
                return findNode(Id, root.getLeft());
            }

        }

    }

    public KAUstudent findNodeName(String FirstName, String LastName) {//parameters here
        return findNodeName(FirstName, LastName, root);
    }

    ;
private KAUstudent findNodeName(String FirstName, String LastName, KAUstudent root) {

        if (root == null) {

            return root;
        }
        if (root.getFirstName().equalsIgnoreCase(FirstName) && root.getLastName().equalsIgnoreCase(LastName)) {
            return root;
        }
        if (root.getLastName().charAt(0) > LastName.charAt(0)) {
            return findNodeName(FirstName, LastName, root.getLeft());
        }
        if (root.getLastName().charAt(0) <= LastName.charAt(0)) {
            return findNodeName(FirstName, LastName, root.getRight());
        } else {
            return root;
        }

    }

    public void PRINTALLRECORDS(PrintWriter OutPutFileWrite) {
        PrintWriter OutPutFile = OutPutFileWrite;
        if (root != null) {
            OutPutFile.println("PRINTALLRECORDS Command\n"
                    + "	All records saved in KAUdbms:");
            OutPutFile.println("	STUDENT ID     NAME                     AGE     YEAR/LEVEL     GPA");
            PRINTALLRECORDS(OutPutFileWrite, root);
        } else {
            OutPutFileWrite.println("PRINTALLRECORDS Command\n"
                    + "	Cannot Perform PRINTALLRECORDS Command:\n"
                    + "		There are currently no student records saved in KAUdbms.");
        }
        OutPutFileWrite.flush();

    }

    ;
private void PRINTALLRECORDS(PrintWriter OutPuteWrite, KAUstudent Student) {
        PrintWriter OutPutFileWrite = OutPuteWrite;
        KAUstudent aa = Student;

        if (aa != null) {
            PRINTALLRECORDS(OutPuteWrite, aa.getLeft());
//           
            if (aa.getLevel() == 1) {
                OutPutFileWrite.printf("\t%-15d%-25s%-8s%-14s%5.2f\n", aa.getID(), aa.getFirstName() + " " + aa.getLastName(),
                        aa.getAge(), aa.getLevel() + "st Year", aa.getGpa());
            } else {
                OutPutFileWrite.printf("\t%-15d%-25s%-8s%-14s%5.2f\n", aa.getID(), aa.getFirstName() + " " + aa.getLastName(),
                        aa.getAge(), aa.getLevel() + "nd Year", aa.getGpa());
            }

            PRINTALLRECORDS(OutPuteWrite, aa.getRight());
        }

        OutPutFileWrite.flush();
    }

    ;
public void printRecords(String Firstname, String Lastname, PrintWriter OutPuteWrite) {
        printRecords(Firstname, Lastname, root, OutPuteWrite);
    }

    private void printRecords(String Firstname, String Lastname, KAUstudent root, PrintWriter OutPuteWrite) { //parameters here
        KAUstudent nameNode = findNodeName(Firstname, Lastname);
        PrintWriter OutPutFileWrite = OutPuteWrite;
        if (nameNode != null) {
            OutPutFileWrite.println("PRINTRECORD Command\n"
                    + "	Student Record for ID " + nameNode.getID());
            OutPutFileWrite.println("	First Name:  " + nameNode.getFirstName());
            OutPutFileWrite.println("	Last Name:   " + nameNode.getLastName());
            OutPutFileWrite.println("	Email:       " + nameNode.getEmail() + "        Phone:  " + nameNode.getPhone());
            OutPutFileWrite.print("	Age:         " + nameNode.getAge() + "                                 Level:  ");
            if (nameNode.getLevel() == 1) {
                OutPutFileWrite.print(nameNode.getLevel() + "st Year\n");
            } else {
                OutPutFileWrite.print(nameNode.getLevel() + "nd Year\n");
            }
            if (nameNode.getGpa() == 0) {
                OutPutFileWrite.println("	GPA:         N/A");
            } else {
                double number = nameNode.getGpa();

                OutPutFileWrite.print("	GPA:         ");
                OutPutFileWrite.printf("%.2f", number);
                OutPutFileWrite.println("");
            }

            OutPutFileWrite.println("Course Record:");

            if (nameNode.getCourses() != null) {
                KAUcourse helpptrr = nameNode.getCourses().getHead();
                while (helpptrr.getNext() != null) {
                    OutPutFileWrite.println("		Course ID:  " + helpptrr.getID() + "Grade:   " + helpptrr.getGrade());
                    helpptrr = helpptrr.getNext();
                }
                if (helpptrr != null) {
                    OutPutFileWrite.println("		Course ID:  " + helpptrr.getID() + "Grade:   " + helpptrr.getGrade());
                }
            } else {
                OutPutFileWrite.println("Student has not taken any courses");
            }

        } else {
            OutPutFileWrite.println("PRINTRECORD Command\n"
                    + "	Cannot Perform PRINTRECORD Command:\n"
                    + "		Student (" + Firstname + " " + Lastname + ") was not found in KAUdbms.");
        }

        OutPutFileWrite.flush();

    }

    public void delete(String firstname, String lastname, PrintWriter OutPutFileWrite) {
        PrintWriter OutPutFile = OutPutFileWrite;
        KAUstudent IDNAME = findNodeName(firstname, lastname, root);
        if (IDNAME != null) {
            root = delete(root, firstname, lastname);
            OutPutFile.println("DELETE Command\n"
                    + "	Student (" + firstname + " " + lastname + ") has been removed from KAUdbms.");
        } else {
            OutPutFile.println("DELETE Command\n"
                    + "	Cannot Perform DELETE Command:\n"
                    + "		Student (" + firstname + " " + lastname + ")  was not found in KAUdbms.");
        }

    }

    private KAUstudent delete(KAUstudent p, String firstname, String lastname) {
        KAUstudent Ptrhelp = p;
        KAUstudent deleteNode = findNodeName(firstname, lastname);
        if (deleteNode == null) {
            return p;
        }
        KAUstudent ParentOfThenOde = parent(deleteNode);
        if (isLeaf(deleteNode)) {
            if (ParentOfThenOde == null) {
                return null;
            }
            if (lastname.charAt(0) < ParentOfThenOde.getLastName().charAt(0)) {
                ParentOfThenOde.setLeft(null);
            } else {
                ParentOfThenOde.setRight(null);
            }
            return Ptrhelp;
        }
        if (hasOnlyLeftChild(deleteNode)) {
            if (ParentOfThenOde == null) {
                return deleteNode.getLeft();
            }
            if (lastname.charAt(0) < ParentOfThenOde.getLastName().charAt(0)) {
                ParentOfThenOde.setLeft(ParentOfThenOde.getLeft().getLeft());
            } else {
                ParentOfThenOde.setRight(ParentOfThenOde.getRight().getLeft());
            }
            return Ptrhelp;

        }
        if (hasOnlyRightChild(deleteNode)) {
            if (ParentOfThenOde == null) {
                return deleteNode.getRight();
            }
            if (lastname.charAt(0) < ParentOfThenOde.getLastName().charAt(0)) {
                ParentOfThenOde.setLeft(ParentOfThenOde.getLeft().getRight());
            } else {
                ParentOfThenOde.setRight(ParentOfThenOde.getRight().getRight());
            }
            return Ptrhelp;

        }

        KAUstudent deleteNodeTwoChild = minNode(deleteNode.getRight());
        String Firstname = deleteNodeTwoChild.getFirstName();
        String Lastname = deleteNodeTwoChild.getLastName();
        String Email = deleteNodeTwoChild.getEmail();
        double gpa = deleteNodeTwoChild.getGpa();
        Ptrhelp = delete(p, Firstname, Lastname);
        deleteNode.setFirstName(Firstname);
        deleteNode.setLastName(Lastname);
        deleteNode.setAge(deleteNodeTwoChild.getAge());
        deleteNode.setEmail(Email);
        deleteNode.setGpa(gpa);
        deleteNode.setID(deleteNodeTwoChild.getID());
        deleteNode.setPhone(deleteNodeTwoChild.getPhone());
        deleteNode.setLevel(deleteNodeTwoChild.getLevel());
        deleteNode.setCourses(deleteNodeTwoChild.getCourses());

        return Ptrhelp;
    }

    public KAUstudent minNode(KAUstudent root) {
        if (root == null) {
            return null;//if BST or left subtree is empty
        } else {
            if (root.getLeft() == null) {
                return root;
                
            } else {
                return minNode(root.getLeft());//Keep moving to left subtree
            }
        }
    }


    public KAUstudent parent(KAUstudent p) {
        return parent(root, p);
    }
   


    private KAUstudent parent(KAUstudent root, KAUstudent p) {

        if (root == null || root == p) {
            return null; // because there is no parent
        }
        // If root is the actual parent of node p
        if (root.getLeft() == p || root.getRight() == p) {
            return root; // because root is the parent of p
        }
        if (root.getLastName().charAt(0) > p.getLastName().charAt(0)) {
            return parent(root.getLeft(), p);
        }
        if (root.getLastName().charAt(0) > p.getLastName().charAt(0)) {
            return parent(root.getRight(), p);
        } else {
            return null;
        }
    }

    private boolean isLeaf(KAUstudent root) {//parameters here
        return (root.getLeft() == null && root.getRight() == null);
    }

    ;
public Boolean hasOnlyLeftChild(KAUstudent root) {
        return (root.getLeft() != null && root.getRight() == null);
    }

    public Boolean hasOnlyRightChild(KAUstudent root) {
        return (root.getLeft() == null && root.getRight() != null);
    }
;

}
