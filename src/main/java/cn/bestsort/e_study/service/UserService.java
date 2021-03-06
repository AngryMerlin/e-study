package cn.bestsort.e_study.service;

import cn.bestsort.e_study.mapper.UserMapper;
import cn.bestsort.e_study.pojo.dto.User;
import cn.bestsort.e_study.pojo.dto.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaoqiang
 * @Date 2019/12/30 14:08
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean isUserExist(String tel){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTelEqualTo(String.valueOf(tel));
        List<User> userlist = userMapper.selectByExample(userExample);
        if (userlist == null){
            return false;
        }
        return true;
    }
    public Boolean addUser(User user){
        int addResult = userMapper.insertSelective(user);
        if (addResult == 1){
            return true;
        }
        return false;
    }
    public User login(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTelEqualTo(user.getTel()).andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList==null) {
            return null;
        }

        return userList.get(0);
    }
    public long getUserId(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTelEqualTo(user.getTel());
        List<User> userList = userMapper.selectByExample(userExample);
        return userList.get(0).getId();
    }
}
