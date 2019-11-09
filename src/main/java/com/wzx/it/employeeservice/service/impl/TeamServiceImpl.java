package com.wzx.it.employeeservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzx.it.employeeservice.entity.Team;
import com.wzx.it.employeeservice.mapper.TeamMapper;
import com.wzx.it.employeeservice.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    @Autowired private TeamMapper teamMapper;

    @Override
    public List<Team> getAllTeamPage(Integer pageNum,Integer pageSize) {

//        Example example = new Example(Team.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id",1);
//        teamMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Team> teamList = teamMapper.queryAllTeam();
        PageInfo<Team> pageInfo = new PageInfo<>(teamList);
        log.info("总条数:{}",pageInfo.getTotal());
        log.info("pageSize:{}",pageInfo.getPageSize());
        log.info("总页数:{}",pageInfo.getPages());
        return pageInfo.getList();
    }
}
