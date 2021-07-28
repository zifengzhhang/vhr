package com.javaboy.vhr.controller.system;

import com.javaboy.vhr.pojo.Employee;
import com.javaboy.vhr.pojo.Hr;
import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.pojo.Role;
import com.javaboy.vhr.service.HrService;
import com.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHr(String keywords) {
        return hrService.getAllHr(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.success("更新成功");
        }

        return RespBean.fail("更新失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.success("更新成功");
        }

        return RespBean.fail("更新失败");
    }

}
