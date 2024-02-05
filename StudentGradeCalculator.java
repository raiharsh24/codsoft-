import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of Subjects:");
        int n = sc.nextInt();
        int marks[] = new int[n];

        for(int i=0;i<n;i++){
           System.out.print("Enter marks for Subject " + (i + 1) + " out of 100: ");
           marks[i] =  sc.nextInt();

           if (marks[i] < 0 || marks[i] > 100) {
            System.out.println("Marks should be in the range 0 to 100. Exiting program.");
            return;
            }
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        
       double avgPercent = (double)totalMarks/n;

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercent + "%");


        char grade;
        if(avgPercent>=80){
            grade = 'A';
        }
        else if(avgPercent>=60&&avgPercent<80){
            grade = 'B';
        }
        else if(avgPercent>=40&&avgPercent<60){
            grade = 'C';
        }
        else{
            grade = 'D';
        }
    
        System.out.println("Grade: " + grade);

        sc.close();

   

    }
}
