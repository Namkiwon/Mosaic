package com.angointeam.Mosaic.Controller;

import com.angointeam.Mosaic.DAO.UserDao;
import com.angointeam.Mosaic.Mapper.UserMapper;
import com.angointeam.Mosaic.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
public class UserController {

    @Resource(name="com.angointeam.Mosaic.Mapper.UserMapper")
    UserMapper userMapper;

    @Autowired
    UserDao userDao;


    @RequestMapping(value = "/getUsers", method =  RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    private List<UserVO> getUsers() throws Exception{
        return userMapper.getUsers();
    }



    @RequestMapping(value = "/signin" ,method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public UserVO SignIn(@Valid @RequestBody String email) throws Exception{
        UserVO user = new UserVO();
        user.setEmail(email);
        user.setUuid(UUID.randomUUID().toString());
        user.setNickname("asdf1111");
        userMapper.insert(user);
        return user;

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserVO> getUsers(Model model){

        return userDao.getUsers();
    }



}
