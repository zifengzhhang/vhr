package com.javaboy.vhr.controller.system.basic;

import com.javaboy.vhr.pojo.JobLevel;
import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel joblevel) {
        if (jobLevelService.addJoblevel(joblevel) == 1) {
            return RespBean.success("添加成功");
        }

        return RespBean.fail("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJob(@RequestBody JobLevel joblevel) {
        if (jobLevelService.updateJob(joblevel) == 1) {
            return RespBean.success("更新成功");
        }

        return RespBean.fail("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJob(@PathVariable Integer id) {
        if (jobLevelService.deleteJob(id) == 1) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }

    @DeleteMapping("/")
    public RespBean batchDeleteJls(Integer ids[]) {
        if (jobLevelService.batchDeleteJls(ids) == ids.length) {
            return RespBean.success("删除成功");
        }

        return RespBean.fail("删除失败");
    }
}
