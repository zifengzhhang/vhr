package com.javaboy.vhr.controller.system.basic;

import com.javaboy.vhr.pojo.Department;
import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        departmentService.addDep(dep);
        if (dep.getResult() == 1) {
            return RespBean.success("添加成功", dep);
        }

        return RespBean.fail("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDep(dep);

        if (dep.getResult() == -2) {
            return RespBean.fail("该部门下有子部门，删除失败");
        } else if (dep.getResult() == -1) {
            return RespBean.fail("该部门下存在员工，删除失败");
        } else if (dep.getResult() == 1) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }
}
