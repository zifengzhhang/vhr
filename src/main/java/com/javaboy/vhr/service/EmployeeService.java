package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.EmployeeMapper;
import com.javaboy.vhr.pojo.Employee;
import com.javaboy.vhr.pojo.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public int addEmp(Employee emp) {
        Date beginContract = emp.getBeginContract();
        Date endContract = emp.getEndContract();

        // 获取两个日期相差年数的总月份
        double month = (Double.parseDouble(yearFormat.format(endContract)) -
                Double.parseDouble(yearFormat.format(beginContract))) * 12;
        // 在加上两个日期月份的差, 即为总月份数
        month += (Double.parseDouble(monthFormat.format(endContract)) -
                Double.parseDouble(monthFormat.format(beginContract)));

        // 在将总月份 / 12 即为年数
        emp.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        return employeeMapper.insertSelective(emp);
    }

    public String getMaxWorkId() {
        return String.format("%08d", employeeMapper.getMaxWorkId() + 1);
    }

    public Integer deleteEmpById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> emps) {
        return employeeMapper.addEmps(emps);
    }

    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Employee> emps = employeeMapper.getEmployeeByPageWithSalary(page, size);
        RespPageBean bean = new RespPageBean();
        bean.setData(emps);
        bean.setTotal(employeeMapper.getTotal(null, null));
        return bean;
    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeSalaryById(eid, sid);
    }
}
