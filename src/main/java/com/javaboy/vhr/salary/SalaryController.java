package com.javaboy.vhr.salary;

import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.pojo.Salary;
import com.javaboy.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalarys() {
        return salaryService.getAllSalarys();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return RespBean.success("添加成功");
        }

        return RespBean.fail("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id) {
        if (salaryService.deleteSalary(id) == 1) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateSalary(salary) == 1) {
            return RespBean.success("修改成功");
        }

        return RespBean.fail("修改失败");
    }
}
