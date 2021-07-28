package com.javaboy.vhr.controller.system.basic;

import com.javaboy.vhr.pojo.Menu;
import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.pojo.Role;
import com.javaboy.vhr.service.MenuRoleService;
import com.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuRoleService menuRoleService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return roleService.getAllMenus();
    }

    @GetMapping("/menus/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid) {
        return menuRoleService.getMidByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer mids[]) {
        if (menuRoleService.updateMenuRole(rid, mids)) {
            return RespBean.success("修改成功");
        }

        return RespBean.fail("修改失败");
    }

    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.success("添加成功");
        }

        return RespBean.fail("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRoleById(@PathVariable Integer id) {
        if (roleService.deleteRoleById(id) == 1) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }
}
