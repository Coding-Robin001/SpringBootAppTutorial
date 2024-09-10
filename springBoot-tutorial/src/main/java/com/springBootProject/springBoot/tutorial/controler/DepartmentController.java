package com.springBootProject.springBoot.tutorial.controler;

import com.springBootProject.springBoot.tutorial.entity.Department;
import com.springBootProject.springBoot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of Department controller!");
        return departmentService.saveDepartment(department);
    }
    
   @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
       LOGGER.info("Inside getDepartment of Department controller!");
        return departmentService.fetchDepartmentList();
   }

   @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId)throws Exception{
        return departmentService.fetchDepartmentById(departmentId);
   }

   @DeleteMapping("/department/{id}")
   public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!!!";
   }

   @PutMapping("/department/{id}")
   public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
   }

   @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
   }
}
