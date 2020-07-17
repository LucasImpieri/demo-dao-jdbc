package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: department findById =====");
		System.out.println();
		
		System.out.print("Choose the id number: ");
		int idN = sc.nextInt();
		
		Department dep = departmentDao.findById(idN);
		System.out.println(dep);
		
		System.out.println("\n===== TEST 2: department findByAll =====");
		System.out.println();
		
		List<Department> list = departmentDao.findAll();
		
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n===== TEST 3: department insert =====");
		System.out.println();
		
		System.out.print("Insert a department name: ");
		String depName = sc.next();
		
		Department newDepartment = new Department(null, depName);
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n===== TEST 4: department update =====");
		System.out.println();
		
		System.out.print("Choose the id number: ");
		idN = sc.nextInt();
		dep = departmentDao.findById(idN);
		
		System.out.print("Choose a name to change: ");
		String name = sc.next();
		dep.setName(name);
		departmentDao.update(dep);
		System.out.println("Update completed!");

		System.out.println("\n===== TEST 5: department delete =====");
		System.out.println();
		
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}