package com.wzx.it.employeeservice.mapper;

import com.wzx.it.employeeservice.entity.Team;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TeamMapper extends Mapper<Team> {
    List<Team> queryAllTeam();
}
