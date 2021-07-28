package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.JobLevelMapper;
import com.javaboy.vhr.pojo.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public int addJoblevel(JobLevel joblevel) {
        joblevel.setEnabled(true);
        joblevel.setCreateDate(new Date());
        return jobLevelMapper.insertSelective(joblevel);
    }

    public int updateJob(JobLevel joblevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(joblevel);
    }

    public int deleteJob(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer batchDeleteJls(Integer[] ids) {
        return jobLevelMapper.batchDeleteJls(ids);
    }
}
