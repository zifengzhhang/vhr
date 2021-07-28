package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.HrMapper;
import com.javaboy.vhr.mapper.HrRoleMapper;
import com.javaboy.vhr.pojo.Hr;
import com.javaboy.vhr.pojo.Role;
import com.javaboy.vhr.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<Role> roles = hrMapper.getHrRoleById(hr.getId());
        hr.setRoles(roles);
        return hr;
    }

    public List<Hr> getAllHr(String keywords) {
        return hrMapper.getAllHr(HrUtils.getCurrentHr().getId(), keywords);
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        // 先将用户角色全部删除
        hrRoleMapper.deleteHrRole(hrid);
        // 在将用户需要的角色添加
        return hrRoleMapper.addHrRoles(hrid, rids) == rids.length;
    }
}
