package com.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.BranchDao;
import com.dao.HospitalDao;
import com.dao.PatientDao;
import com.entity.Branch;
import com.entity.Hospital;
import com.entity.Patient;

public class HospitalManagement {

	public static void main(String[] args) {

		Patient p = new Patient();
		p.setName("Sakshi");
		p.setDob("21-9-2003");
		p.setMedicalhistory("fever");

		List<Patient> li1 = new ArrayList<Patient>();
		li1.add(p);

		Branch b = new Branch();
		b.setB_location("pimpari");
		b.setPhoneno(8767546788l);
		b.setP(li1);

		List<Branch> li = new ArrayList<Branch>();
		li.add(b);

		Hospital hos = new Hospital();
		hos.setHos_name("Aditya Birla");
		hos.setHos_add("pune");
		hos.setB(li);

		System.out.println("*********Welcome To Hospital Management Application**************");

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Choice");
		System.out.println("Enter A for Adding new record  ");
		System.out.println("Enter B for  Managing Hospital Details");
		System.out.println("Enter C for  Managing Branch Details");
		System.out.println("Enter D for  Managing Patient Details");

		char choice = scan.next().charAt(0);
		switch (choice) {
		case 'A': {
			PatientDao.addPatient(p);
			BranchDao.addBranch(b);
			HospitalDao.addHospital(hos);
			break;
		}
		case 'B': {

			System.out.println("Enter your Choice");
			System.out.println("Enter 1 for Add Hospital Details");
			System.out.println("Enter 2 for FindAll Hospital Details");
			System.out.println("Enter 3 for Delete Hospital Details By Id");
			System.out.println("Enter 4 for Find All Patient Details of hospital ");

			int choice1 = scan.nextInt();
			switch (choice1) {
			case 1: {

				HospitalDao.addHospital(hos);
				break;
			}
			case 2: {

				HospitalDao.findAllHospital();
				break;
			}
			case 3: {
				System.out.println("Enter the hospital id which you want to delete");
				int id = scan.nextInt();
				HospitalDao.DeleteHospitalById(id);
				break;
			}
			case 4: {
				System.out.println("Enter the hospital id for all patient details");
				int id = scan.nextInt();
				HospitalDao.findAllPatientOfParticularHos(id);
				break;
			}

			default:
				System.out.println("Invalid Choice");
			}

			break;
		}
		case 'C': {

			System.out.println("Enter your Choice");
			System.out.println("Enter 1 for Add Branch Details");
			System.out.println("Enter 2 for FindAll Branch Details");
			System.out.println("Enter 3 for Delete Branch Details By Id");
			System.out.println("Enter 4 for finf all hospital details of branch");

			int choice3 = scan.nextInt();
			switch (choice3) {
			case 1: {
				BranchDao.addBranch(b);
				break;
			}
			case 2: {

				BranchDao.findAllBranch();
				break;
			}
			case 3: {
				System.out.println("Enter the branch id which you want to delete");
				int id = scan.nextInt();
				BranchDao.DeleteBranchById(id);
				break;
			}
			case 4: {
				System.out.println("Enter the branch id for hospital details");
				int id = scan.nextInt();
				BranchDao.DeleteBranchById(id);
				break;
			}

			default:
				System.out.println("Invalid Choice");
			}

			break;
		}
		case 'D': {

			System.out.println("Enter your Choice");
			System.out.println("Enter 1 for Add Patient Details");
			System.out.println("Enter 2 for FindAll Patient Details");
			System.out.println("Enter 3 for Delete Patient Details By Id");
			System.out.println("Enter 4 for Update patient histroy");

			int choice3 = scan.nextInt();
			switch (choice3) {
			case 1: {

				PatientDao.addPatient(p);
				break;
			}
			case 2: {

				PatientDao.findAllPatient();
				break;
			}
			case 3: {
				System.out.println("Enter the patient id which you want to delete");
				int id = scan.nextInt();
				PatientDao.DeletePatientById(id);
				break;
			}
			case 4: {
				System.out.println("Enter the patient id for update details");
				int id = scan.nextInt();
				System.out.println("Enter details for updating");
				String his = scan.nextLine();
				PatientDao.UpdatePatientHistory(id, his);
				break;
			}

			default:
				System.out.println("Invalid Choice");
			}

			break;
		}

		default:
			System.out.println("Invalid Choice");
		}

	}
}
