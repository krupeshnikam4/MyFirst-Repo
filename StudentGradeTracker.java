import java.util.Scanner;
class StudentGradeTracker{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("---Student Marks Details---");
         System.out.println();
         System.out.print("Number of Student: ");
         int Student=sc.nextInt();
         int subject = 5;
         String[] name= new String[Student];
         int[] marks = new int[Student];
         for(int i=0;i<Student;i++){
            System.out.print("Enter a name: ");
name[i]=sc.next();
         System.out.print("Math1 Marks: ");
         int M1 = sc.nextInt();
         System.out.print("sci Marks: ");
         int sci = sc.nextInt();
         System.out.print("chem Mark: ");
         int chem = sc.nextInt();
         System.out.print("java Marks: ");
         int java=sc.nextInt();
         System.out.print("C Marks: ");
         int C = sc.nextInt();
         int TotalMarks = M1+sci+chem+java+C;
         System.out.println("Total Marks of Student: "+TotalMarks+"/500 Marks");
         float average= (float)TotalMarks / subject;
         System.out.println("Average of Marks: "+average+" %");
         System.out.println();
      
         if(average>35){
    System.out.print("Student is Pass");
}else{
    System.out.print("Students is Fail");
}
System.out.println();
         if(average>=90){
            System.out.println("Grade: O");
         }else if(average>=80){
System.out.print("Grade: A+");
         }else if(average>=70){
System.out.print("Grade: A");
         }else if(average>=60){
            System.out.print("Grade: B+");
         }else if(average>=50){
            System.out.print("Grade: B");
         }else{
            System.out.print("Grade: Bad Performance");
         }
         System.out.println();System.out.println();
    }
    }
}