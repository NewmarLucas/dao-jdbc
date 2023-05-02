package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(5);
		System.out.println(department);

		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: seller insert ===");
		Department departmentInsert = new Department(null, "Delete");
		departmentDao.insert(departmentInsert);
		System.out.println("Inserted! New Id = " + departmentInsert.getId());

		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(5);
		department.setName("Controls");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: department delete ===");
		departmentDao.deleteById(6);
		System.out.println("Delete completed!");
	}
}
