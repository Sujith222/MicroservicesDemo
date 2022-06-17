package com.microservicedemo.user.service;

import com.microservicedemo.user.VO.Department;
import com.microservicedemo.user.VO.ResponseTemplateVo;
import com.microservicedemo.user.entity.User;
import com.microservicedemo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        return userRepository.save(user);
    }


    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user= userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return  responseTemplateVo;
    }
}
