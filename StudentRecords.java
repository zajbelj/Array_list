import java.util.*;

public class StudentRecords {
	
	
	private static Scanner k;
	
	public static void main(String[] args){
		
		//create an ArrayList to only hold Student objects
		ArrayList<Student> students = new ArrayList<Student>();
		
		//create Scanner object to take input
		k = new Scanner(System.in);
			
		//start 
		while(true){
			System.out.println("1 - Enter new student");
			System.out.println("2 - Remove a student");
			System.out.println("3 - Promote all students");
			System.out.println("4 - Display all students");
			System.out.println("5 - Search for students");
			System.out.println("6 - Exit");
			
			int input = k.nextInt();
			k.nextLine();
			
			if(input == 1){
				students.add(createNewStudent());
			}else if(input == 2){
				removeStudent(students);
			}else if(input == 3){
				promoteAllStudents(students);
			}else if(input == 4){
				showAllStudents(students);
			}else if(input == 5){
				searchForStudents(students);
			}else{
				break;
			}
		}
	}
	public static void searchForStudents(ArrayList<Student> list){
		System.out.print("Enter name or id of student: " );
		String input = k.nextLine();
		
		for(int i = 0; i < list.size(); i++){
			Student s = list.get(i);
			if(input.equals(s.getName()) || input.equals(s.getID())){
				System.out.println("Found Student!");
				System.out.println(s.toString());
				System.out.println("Index: " + i);
				System.out.println("----------------------");
			}
		}
	}
	
	public static void showAllStudents(ArrayList<Student> list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).toString());
			System.out.println("------------------------------");
		}
	}
	
	public static void promoteAllStudents(ArrayList<Student> list){
		for(int i = list.size() - 1; i >= 0; i--){
			if(!list.get(i).promote()){
				list.remove(i);
			}
		}
	}
	
	public static void removeStudent(ArrayList<Student> list){
		System.out.print("Enter index of student to remove: ");
		list.remove(k.nextInt());
	}
	
	public static Student createNewStudent(){
		System.out.print("Enter Student's Name: ");
		String name = k.nextLine();
		System.out.print("Enter Student's ID: ");
		String id = k.nextLine();
		System.out.print("Enter Student's Grade: ");
		int grade = k.nextInt();
		
		return new Student(name, id, grade);
	}	
}