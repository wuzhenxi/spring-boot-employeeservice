package com.wzx.it.employeeservice.service;

import com.wzx.it.employeeservice.entity.Team;

import java.util.List;

public interface TeamService {

    public List<Team> getAllTeamPage(Integer pageNum,Integer pageSize);

}
