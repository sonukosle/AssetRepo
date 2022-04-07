package com.asset;

import com.asset.dto.EmployeeDto;
import com.asset.helper.UserFoundException;
import com.asset.model.*;
import com.asset.services.impl.Employee_Service_Impl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AssetProjectApplication implements CommandLineRunner {

    @Autowired
    private Employee_Service_Impl employee_service_Impl;

    @Autowired
    public ModelMapper modelMapper;


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(AssetProjectApplication.class, args);
        System.out.println("Asset project running..");
    }

    @Override
    @JsonIgnore
    public void run(String... args) throws Exception, UserFoundException {


        try {

            Employee e = new Employee();
            e.setEmpName("Sunny");
            e.setEmpPassword("12345");
            e.setEmpAge(26);
            e.setEmpDept("IT");
            e.setEmail("sonukosle@gmail.com");
            e.setEmpMobile("8120164993");
            e.setEmpFixedAnnualSalary(200000f);
            e.setEmpDesignation("Developer");
            e.setEmpJoiningDate("07/08/2021");
            e.setEmpYearPackage(200000);
            e.setEmpRole("developer");

            Role role = new Role();
            role.setRoleName("Admin");

            List<Employee> e1 = new ArrayList<>();
            e1.add(e);
            role.setEmployees(e1);
//            e.setEmpRole(role);

            Employee_address employee_address = new Employee_address();
            employee_address.setEmployee(e);
            employee_address.setCountry("India");
            employee_address.setLandmark("Betul near Landmark hotel");
            employee_address.setHouseNumber(36);
            employee_address.setState("Madhyapradesh");
            employee_address.setPinCode(460001);
            employee_address.setStreetNo(5);

            e.setEmployee_address(employee_address);

            Asset_raise_request asset_raise_request = new Asset_raise_request();

            Asset asset = new Asset();
            asset.setAssetCompany("ProDol");
            asset.setAssetName("Mouse");
            asset.setAssetQuantity(1);

            asset_raise_request.setAsset(asset);
            asset_raise_request.setAssetReqName("mouse");
            asset_raise_request.setEmployee(e);
            asset_raise_request.setApproveStatus(true);

            Asset_track asset_track = new Asset_track();
            asset_track.setAssetTrackStatus(true);
            asset_track.setAssetRaiseRequest(asset_raise_request);
            asset_track.setShippingCompany("blueDot courier");
            asset_track.setShippingExpense(100);
            List<Asset_track> list_asset_Track = new ArrayList<>();
            list_asset_Track.add(asset_track);
            asset_raise_request.setAssetTrack(list_asset_Track);

            ArrayList<Asset_raise_request> asset_raise_requests = new ArrayList<>();
            asset_raise_requests.add(asset_raise_request);

            e.setAsset_raise_requests(asset_raise_requests);

            Employee employee = this.employee_service_Impl.createEmployee(e);

            System.out.println(employee.getEmpName());


            EmployeeDto map = modelMapper.map(employee, EmployeeDto.class);
            // creating object mapper class and making json data here
            ObjectMapper objectMapper = new ObjectMapper();
            //objectMapper.convertValue(employee, Employee.class);
            objectMapper.writeValue(new File("target/emp.json"), map);
            // need to work here

        } catch (final Exception e) {
            e.printStackTrace();
        }


    }
}
