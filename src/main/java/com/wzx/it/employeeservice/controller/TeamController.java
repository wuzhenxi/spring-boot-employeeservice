package com.wzx.it.employeeservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wzx.it.employeeservice.entity.Team;
import com.wzx.it.employeeservice.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@ResponseBody
@Slf4j
public class TeamController {

    @Autowired private TeamService teamService;

    @GetMapping("/getAllTeam/{pageNum}/{pageSize}")
    public String getTeams(@PathVariable("pageNum")Integer pageNum,@PathVariable("pageSize")Integer pageSize){
        List<Team> teamList = teamService.getAllTeamPage(pageNum,pageSize);
        return JSON.toJSONString(teamList, SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue);
    }
}
