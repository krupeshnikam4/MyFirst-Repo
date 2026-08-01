// import java.util.Scanner;

// class HospitalManagement{
  
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in); 

// System.out.println();
// System.out.println("Chattrapati Hospital Management System");
// System.out.println();



//        int Patient =sc.nextInt();
// System.out.println("Patient Regitration form...");

// String[] name = new String[Patient];
// int[] age= new int[Patient]; 
// String[] sex= new String[Patient];
// String[] Fee =new String[Patient];

// for (int i=0;i<Patient;i++) {
//     System.out.print("Enter Patient Name: ");
//     name[i]=sc.next();
//     System.out.print("Age: ");
// age[i]=sc.nextInt();
// System.out.print("Enter Sex: ");
// sex[i]=sc.next();
// System.out.print("Pay Fee: ");
// Fee[i]=sc.next();
  
//         System.out.println();
//         System.out.println("Doctor Appointment....");
//         System.out.println();
//         System.out.println("     - Waiting for our Number");
//     System.out.println();
//     System.out.println("....Billing....");

//     System.out.println("   - Medicine Records - ");
//     System.out.println();
    
// String med1=sc.next();
// System.out.print("enter cost: ");
// int cost1=sc.nextInt();int n=sc.nextInt();
// int tt =cost1*n;

// String med2=sc.next();
// System.out.print("enter cost: ");
// int cost2 = sc.nextInt();
// int m = sc.nextInt();
// int tt2 =cost2*m;

// String med3=sc.next();
// System.out.print("enter cost: ");
// int cost3= sc.nextInt();int o = sc.nextInt();
// int tt3 =cost2*o;

// String med4=sc.next();
// System.out.print("enter cost: ");
// int cost4= sc.nextInt();int p = sc.nextInt();
// int tt4 =cost2*p;

// String med5=sc.next();
// System.out.print("enter cost: ");
// int cost5= sc.nextInt();int q = sc.nextInt();
// int tt5 =cost2*q;

// int Totalcost= tt+tt2+tt3+tt4+tt5;
// System.out.println(" total cost: "+Totalcost);
// System.out.println();
// }
//     }
// }



import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int age;
    String sex;
    String fee;
    ArrayList<Medicine> medicines;
    
    public Patient(String name, int age, String sex, String fee) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.fee = fee;
        this.medicines = new ArrayList<>();
    }
    
    public void addMedicine(Medicine med) {   //addMedicine is method name
        this.medicines.add(med);           //to add a medicine
    }
    
    public int calculateTotalCost() {      // this term is use anywhere in project
        //int is a data type 
        int total = 0;
        
        for (Medicine med : medicines) {   // use for loop for the check the condition
            total =total + med.getTotalCost();
        }
        return total;
    }
}

class Medicine {
    String name;
    int cost;
    int quantity;
    
    public Medicine(String name, int cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }
    
    public int getTotalCost() {
        return cost * quantity;
    }
}

public class HospitalManagement{

               //main class is hospital Management
    
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("========================================");
        System.out.println(" Chattrapati Hospital Management System");
        System.out.println("========================================");
        System.out.println();
        
        System.out.print("Enter Number of Patients: ");
        int numPatients = sc.nextInt();
        System.out.println();
        
        // Register all patients
        for (int i = 0; i < numPatients; i++) {
            registerPatient(i + 1);
        }
        
        // Display all patient records
        displayAllRecords();
    }
    
    public static void registerPatient(int patientNumber) {
        System.out.println("========================================");
        System.out.println("Patient " + patientNumber + " Registration Form");
        System.out.println("========================================");
        System.out.print("Enter Patient Name: ");
        String name = sc.next();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        
        System.out.print("Enter Sex: ");
        String sex = sc.next();
        
        System.out.print("Enter Fee: ");
        String fee = sc.next();

         // Create patient object
        Patient patient = new Patient(name, age, sex, fee);
         

        // Add patient to list
        System.out.println();
        patients.add(patient);
        System.out.println("  Patient registered successfully!");
        System.out.println();
        
       
        // Doctor Appointment
        System.out.println("Doctor Appointment....");
        System.out.println("- Waiting for our Number");
        System.out.println();
        
        // Add medicines
        System.out.println("========================================");
        System.out.println("            Medicine Records");
        System.out.println("========================================");

        System.out.print("How many medicines - ");
        int numMedicines = sc.nextInt();
        System.out.println();
        
        //for loop is use here
        for (int j = 0; j < numMedicines; j++) {
            System.out.println("--- " + (j + 1) + ". Medicine ---");
            System.out.print("Enter Medicine Name: ");
            String medName = sc.next();
            
            System.out.print("Enter Medicine: ");
            int cost = sc.nextInt();
            
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            
            Medicine med = new Medicine(medName, cost, quantity);
            patient.addMedicine(med);
            System.out.println();
        }
        
    }
    
    //this is one type of function
    //this function is use for the display all the records..
    public static void displayAllRecords() {
        System.out.println("\n========================================");
        System.out.println("        BILLING & PATIENT RECORDS");
        System.out.println("========================================\n");
        
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            
            System.out.println("--- Patient " + (i + 1) + " ---");
            System.out.println("Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Sex: " + patient.sex);
            System.out.println("Fee: " + patient.fee);
            System.out.println();
            
            System.out.println("Medicines:");
            if (patient.medicines.isEmpty()) {
                System.out.println("  No medicines prescribed");
            } else {
                int totalCost = 0;
                for (Medicine med : patient.medicines) {
                    int medTotal = med.getTotalCost();
                    System.out.println("  - " + med.name + 
                                     " | Cost: " + med.cost + 
                                     " | Qty: " + med.quantity + 
                                     " | Total: " + medTotal);
                    totalCost += medTotal;
                }
                System.out.println();
                System.out.println("Total Medicine Cost: " + totalCost);
            }
            
            System.out.println("========================================\n");
        }
    }
}
