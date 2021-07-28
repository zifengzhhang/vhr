package com.javaboy.vhr.controller.system.basic;

import com.javaboy.vhr.pojo.Position;
import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.success("添加成功");
        }

        return RespBean.fail("添加失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updatePosition(position) == 1) {
            return RespBean.success("更新成功");
        }

        return RespBean.fail("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (positionService.deletePosition(id) == 1) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }

    @DeleteMapping("/")
    public RespBean batchDelPositions(Integer ids[]) {
        if (positionService.batchDelPositions(ids) == ids.length) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }
}
