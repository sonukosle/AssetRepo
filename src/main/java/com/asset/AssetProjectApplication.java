package com.asset;

import com.asset.helper.UserFoundException;
import com.asset.modal.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AssetProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssetProjectApplication.class, args);
		System.out.println("Asset project running..");
	}

	@Override
	public void run(String... args) throws Exception, UserFoundException {

		Employee e = new Employee();
		e.setEmp_name("Sunnykosle");
		e.setEmp_password("12345");
		e.setEmp_age(26);
		e.setEmp_dept("IT");
		e.setEmp_email("sonukosle@gmail.com");
		e.setEmp_mobile("8120164993");
		e.setEmp_fixed_annual_salary(200000f);
		e.setEmp_designation("Developer");
		e.setEmp_joining_date("07/08/2021");
		e.setEmp_year_package(200000);
		e.setEmp_role("developer");

		Role role = new Role();
		role.setRole_name("Admin");

		List<Employee> e1 = new ArrayList<>();
		e1.add(e);
		role.setEmployees(e1);
		e.setRole(role);

		Employee_address employee_address = new Employee_address();
		employee_address.setEmployee(e);
		employee_address.setCountry("India");
		employee_address.setLandmark("Betul near Landmark hotel");
		employee_address.setHouse_number(36);
		employee_address.setState("Madhyapradesh");
		employee_address.setPin_code(460001);
		employee_address.setStreet_no(5);

		e.setEmployee_address(employee_address);

		Asset_raise_request asset_raise_request = new Asset_raise_request();

		Asset asset = new Asset();
		asset.setAsset_company("ProDol");
		asset.setAsset_name("Mouse");
		asset.setAsset_quantity(1);

		asset_raise_request.setAsset(asset);
		asset_raise_request.setAsset_req_name("mouse");
		asset_raise_request.setEmployee(e);
		asset_raise_request.setApprove_status(true);

		Asset_track asset_track = new Asset_track();
		asset_track.setAsset_track_status(true);
		asset_track.setAsset_raise_request(asset_raise_request);
		asset_track.setShipping_company("blueDot courier");
		asset_track.setShipping_expense(100);
		List<Asset_track> list_asset_Track = new ArrayList<>();
		list_asset_Track.add(asset_track);
		asset_raise_request.setAsset_track(list_asset_Track);

		ArrayList<Asset_raise_request> asset_raise_requests = new ArrayList<>();
		asset_raise_requests.add(asset_raise_request);

		e.setAsset_raise_requests(asset_raise_requests);

	}
}
