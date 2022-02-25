package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TESTE 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TESTE 2: seller findDepartement ===");
		Department departement = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(departement);
		for( Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();		
		System.out.println("=== TESTE 3: seller findAll ===");
		list = sellerDao.findAll();
		for( Seller obj : list) {
			System.out.println(obj);
		}
	
		System.out.println();		
		System.out.println("=== TESTE 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departement);
		sellerDao.insert(newSeller);
		System.out.println("Insterted! new id = "+ newSeller.getId());
		
		System.out.println();		
		System.out.println("=== TESTE 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Uptated completed");
		
		System.out.println();		
		System.out.println("=== TESTE 6: seller Delete ===");
		System.out.println("Enter id for delete test");		
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
		sc.close();
	}
}
