package com.springBootProject.springBoot.tutorial.controler;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.springBootProject.springBoot.tutorial.entity.Department;
import com.springBootProject.springBoot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        Department department =
                new Department(71L, "TSC", "BAYELSA", "1392");
    }

    @Test
    void saveDepartment () throws Exception {
        Department departmentInput =
                new Department(71L, "TSC", "BAYELSA", "1392");
        Mockito.when(departmentService.saveDepartment(departmentInput)).thenReturn(department);
        String jsonRequestBody = "{ \"departmentId\": \"71L\", \"departmentName\": \"TSC\", \"departmentAddress\": \"BAYELSA\", \"departmentCode\": \"1392\"}";

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody)
        ).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() {
    }
}