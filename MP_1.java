package DSA_1_MINOR_PROJECT;
import java.util.*;

public class MP_1 {
	public static void main(String[] args) {
		String jp="manager";
		Date d1=new Date();
		Date d2=new Date();
		d1.y=2022;d2.y=2023;
		d1.m=4;d2.m=03;
		d1.d=01;d2.d=31;
		double s1=150000,s2=300000;
		Employee []employees=new Employee[5];
		for (int i = 0; i < employees.length; i++) {
			System.out.println("###################################################");
			System.out.println("##        *^____^*(ENTER DETAILS)*^____^*        ##");
			System.out.println("###################################################");
			employees[i]=new Employee();
			employees[i].getdata(employees, i);
			employees[i].getdata1();
			employees[i].getdata2(employees, i);
			}
		arrangeEmployeeBySalary(employees);
		getEmployeesByJobPosition(employees,jp);
		getEmployeesByHireDate(employees, d1, d2);
		System.out.println("The number of foreign employees: "+foreignEmployeeCount(employees));
		getEmployeesBySalary(employees,s1,s2);
	}
	public static void arrangeEmployeeBySalary(Employee e[]) {
	    Arrays.sort(e, (e1, e2) -> Double.compare(e2.salary, e1.salary));
		    for (int i = 0; i < e.length; i++) {
				System.out.println(e[i].salary);
			}
	}
	public static void getEmployeesByJobPosition(Employee e[], String jp) {
		for (int i = 0; i < e.length; i++) {
			if (e[i].jobPosition.equalsIgnoreCase(jp)) {
				e[i].display();
				System.out.println("Address: "+e[i].address()+"\nHire Date: "+e[i].date());
				
			}
		}
		
	}
	public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2){
		for (int i = 0; i < e.length; i++) {
			if (((e[i].y>=d1.y)&&(e[i].y<=d2.y))&&((e[i].m>=d1.m)&&(e[i].m<=d2.m))&&((e[i].d>=d1.d)&&(e[i].d<=d2.d))) {
				e[i].display();
				System.out.println("Address: "+e[i].address()+"\nHire Data: "+e[i].date());
			}
		}
				
	}
	public static int foreignEmployeeCount(Employee e[]) {
		int a=0;
		for (int i = 0; i < e.length; i++) {
			if((e[i].contactNumber.charAt(1)!='9')||(e[i].contactNumber.charAt(2)!='1')) {
				a++;
				}
		}
		return a;
	}
	public static void getEmployeesBySalary(Employee e[], double s1, double s2) {
		for (int i = 0; i < e.length; i++) {
			if ((e[i].salary>=s1)&&(e[i].salary<=s2)) {
				e[i].display();
				System.out.println("Address: "+e[i].address()+"\nHire Date: "+e[i].date());
			}
		}
	}
}
class Address {
	String city,locality,street,address;
	int houseno;
	static Scanner albatross=new Scanner(System.in);
	void getdata1(){
		System.out.println("                (Enter the Address)");
		System.out.print("Enter city: ");
		city=albatross.next();
		System.out.print("Enter locality: ");
		locality=albatross.next();
		System.out.print("Enter street: ");
		street=albatross.next();
		System.out.print("Enter house no:");
		houseno=albatross.nextInt();
	}
	public String address() {
		address=city+"-"+locality+"-"+street+"-"+houseno;
		return address;
	}
	
}
class Date extends Address{
	int y,m,d;
	String dateString;
	static Scanner albatross=new Scanner(System.in);
	void getdata2(Address e[],int i){
		System.out.println("                (Enter the hire Date)");
		System.out.print("Enter year: ");
		y=albatross.nextInt();
		System.out.print("Enter month: ");
		m=albatross.nextInt();
		System.out.print("Enter day: ");
		d=albatross.nextInt();
	}
	public String date() {
	dateString=(y+"-"+m+"-"+d);
	return dateString;
	}

}

class Employee extends Date{
	public String address,dateString;
	static Scanner albatross=new Scanner(System.in);
	    public String name,contactNumber,jobPosition;
		int empid;
		double salary;
		void getdata(Address employees[],int i){
			System.out.print("Enter name: ");
			name=albatross.next();
            albatross.next();
			System.out.print("Enter contactnumber: ");
			contactNumber=albatross.next();
			System.out.print("Enter jobposition: ");
			jobPosition=albatross.next();
			System.out.print("Enter empid: ");
			empid=albatross.nextInt();
			System.out.print("Enter salary: ");
			salary=albatross.nextDouble();
		}
		void display(){
			System.out.println("Name: "+name+"\nContact number: "+contactNumber+"\nJobposition: "+jobPosition+"\nempID: "+empid+"\nSalary: "+salary);
		}
}

