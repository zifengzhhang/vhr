package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.SalaryMapper;
import com.javaboy.vhr.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalarys() {
        return salaryMapper.getAllSalarys();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalary(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalary(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
