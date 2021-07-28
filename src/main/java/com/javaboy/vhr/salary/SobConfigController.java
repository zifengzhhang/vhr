package com.javaboy.vhr.salary;

import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.pojo.RespPageBean;
import com.javaboy.vhr.pojo.Salary;
import com.javaboy.vhr.service.EmployeeService;
import com.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size) {

        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("/salary")
    public List<Salary> getAllSalaryies() {
        return salaryService.getAllSalarys();
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result == 1 || result == 2) {
            return RespBean.success("更新成功");
        }

        return RespBean.fail("更新失败");
    }
}
