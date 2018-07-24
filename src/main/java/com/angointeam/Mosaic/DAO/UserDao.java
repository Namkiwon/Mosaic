package com.angointeam.Mosaic.DAO;

import com.angointeam.Mosaic.SignIn.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(UserVO user) {
        String query = "INSERT INTO User(email,uuid,nickname) VALUES(?,?,?)";
        return jdbcTemplate.update(query, user.getEmail(), user.getUuid(), user.getNickname());
    }

    public List<UserVO> getUsers() {
        String query = "SELECT * FROM User";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<UserVO>(UserVO.class));
    }

//    public UserVO findUserByEmail(String email){
//        String query = "SELECT email,uuid,nickname FROM Users WHERE email = " + email;
//        return jdbcTemplate.query(query,new B);
//        return  jdbcTemplate.update(query,new ));
//}

}
