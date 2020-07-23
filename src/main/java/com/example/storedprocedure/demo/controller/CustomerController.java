package com.example.storedprocedure.demo.controller;

import com.example.storedprocedure.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @GetMapping("/customers")
    public String procedureExample() throws Exception {
        //datasource connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/db1", "postgres", "Tru$T@ml!@34");

        //callable statement to call required procedure
        CallableStatement callableStatement = con.prepareCall("{call customer_sf()}");
        String customerJsonData="";
        ResultSet rs1=callableStatement.executeQuery();
        while (rs1.next()) {
            System.out.println(rs1.getString(1));
            customerJsonData=rs1.getString(1);
        }
        return customerJsonData;
    }

}
