package com.wzx.it.employeeservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo,Integer> {
    @Transactional
    public void deleteEmployeeInfoByIdIn(List<Integer> ids);

    public EmployeeInfo findEmployeeInfoById(Integer id);

}
