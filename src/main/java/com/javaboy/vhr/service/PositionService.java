package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.PositionMapper;
import com.javaboy.vhr.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public int addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public int updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public int deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer batchDelPositions(Integer[] ids) {
        return positionMapper.batchDeletePositions(ids);
    }
}
