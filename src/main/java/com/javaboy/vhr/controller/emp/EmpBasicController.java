package com.javaboy.vhr.controller.emp;

import com.javaboy.vhr.pojo.*;
import com.javaboy.vhr.service.*;
import com.javaboy.vhr.util.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    NationService nationService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {

        return employeeService.getEmployeeByPage(page, size, employee, beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee emp) {
        if (employeeService.addEmp(emp) == 1) {
            return RespBean.success("添加成功");
        }

        return RespBean.fail("添加失败");
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkId")
    public RespBean getMaxWorkId() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObject(employeeService.getMaxWorkId());

        return respBean;
    }

    @GetMapping("/depts")
    public List<Department> getAllDepts() {
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id) {
        if (employeeService.deleteEmpById(id) == 1) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.success("更新成功");
        }

        return RespBean.fail("更新失败");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> emps =  (List<Employee>) employeeService.getEmployeeByPage(null, null, new Employee(), null).getData();
        return POIUtils.employee2Excel(emps);
    }

    @PostMapping("/import")
    public RespBean importData(@RequestBody MultipartFile file) {
        List<Employee> emps = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatus(),
                departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());


        if (employeeService.addEmps(emps) == emps.size()) {
            return RespBean.success("上传成功");
        }

        return RespBean.fail("上传失败");
    }
}
