package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.NationMapper;
import com.javaboy.vhr.pojo.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
