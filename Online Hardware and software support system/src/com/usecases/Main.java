package com.usecases;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to Online hardware and software support system ");
		System.out.println();
		System.out.println("Enter 1 if you are HOD");
		System.out.println("For Employee please enter 2");
		System.out.println("Engineers please enter 3");
		System.out.println();
		
		int N =sc.nextInt();
		
		if(N==1)
		{
			HodLogin login = new HodLogin();
			login.hodLogin();
			
			while(true)
			{
				System.out.println("Enter 1 to register a new engineer");
				System.out.println("Enter 2 to see list of engineers");
				System.out.println("Enter 3 to delete engineer");
				System.out.println("Enter 4 to see all the raised complaints");
				System.out.println("Enter 5 to assign problem to any engineer");
				System.out.println("Enter 6 to logout");
				System.out.println();
				
				int choice = sc.nextInt();
				
				if(choice == 1)
				{
					HodRegisterEngineer register = new HodRegisterEngineer();
					register.hodRegisterEngineer();
				}
				else if(choice == 2)
				{
					HodCheckEngineer check = new HodCheckEngineer();
					check.hodCheckEngineer();
				}
				else if(choice==3)
				{
					HodDeleteEngineer delete = new HodDeleteEngineer();
					delete.hodDeleteEngineer();
				}
				else if(choice == 4)
				{
					HodCheckComplaints complaints = new HodCheckComplaints();
					complaints.hodCheckComplaints();
				}
				else if(choice == 5) 
				{
					HodAssignComplaintToEngineer assign = new HodAssignComplaintToEngineer();
					assign.hodAssignComplaintToEngineer();
				}
				else if(choice == 6)
				{
					Main.main(args);
				}
				else
				{
					System.out.println("Invalid input ...");
				}
			}
			
		}
		else if(N==2)
		{
			while(true)
			{
				
				System.out.println("Enter 1 to register ");
				System.out.println("Enter 2 to login ");
				System.out.println("Enter 3 to register complain ");
				System.out.println("Enter 4 to see status of complaint ");
				System.out.println("Enter 5 to see all complaints raised");
				System.out.println("Enter 6 to change password");
				
				System.out.println();
				
				int choice = sc.nextInt();
				
				if(choice == 1)
				{
					EmployeeRegistration reg = new EmployeeRegistration();
					reg.employeeRegistration();
				}
				else if(choice == 2)
				{
					EmployeeLogin login = new EmployeeLogin();
					login.employeeLogin();
				}
				else if(choice == 3)
				{
					EmployeeRaiseComplain comp = new EmployeeRaiseComplain();
					comp.employeeRaiseComplain();
				}
				else if(choice == 4)
				{
					EmployeeCheckComplaintStatus status = new EmployeeCheckComplaintStatus();
					status.employeeCheckComplaintStatus();
				}
				else if(choice == 5)
				{
					EmployeeCheckComplaintHistory allComp = new EmployeeCheckComplaintHistory();
					allComp.employeeCheckComplaintHistory();
				}
				else if(choice == 6)
				{
					EmployeeChangePassword change = new EmployeeChangePassword();
					change.employeeChangePassword();
				}
				else
				{
					System.out.println("Invalid input ...");
				}
				
				
			}
			

			
		}
		else if(N==3)
		{
			while(true)
			{
				
				System.out.println("Enter 1 to login");
				System.out.println("Enter 2 to view problems assigned");
				System.out.println("Enter 3 to update status of problem addressed");
				System.out.println("Enter 4 to see list of problems attended");
				System.out.println("Enter 5 to change password");
				
				System.out.println();
				
				int choice = sc.nextInt();
				
				if(choice == 1)
				{
					EngineerLogin login = new EngineerLogin();
					login.engineerLogin();
				}
				else if(choice == 2)
				{
					EngineerCheckComplaintsAssigned comp = new EngineerCheckComplaintsAssigned();
					comp.engineerCheckComplaintsAssigned();
				}
				else if(choice == 3)
				{
					EngineerUpdateComplaintStatus status = new EngineerUpdateComplaintStatus();
					status.engineerUpdateComplaintStatus();
				}
				else if(choice == 4)
				{
					EngineerCheckAttendedComplaints attended = new EngineerCheckAttendedComplaints();
					attended.engineerCheckAttendedComplaints();
				}
				else if(choice == 5)
				{
					EngineerChangePassword change = new EngineerChangePassword();
					change.engineerChangePassword();
				}
				else
				{
					System.out.println("Invalid input ...");
				}
				
			}
			

			
		}
		else
		{
			System.out.println("Invalid input ");
			System.exit(0);
		}
	}

}
