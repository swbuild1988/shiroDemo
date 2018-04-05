package pers.swbuild.service.impl;

import pers.swbuild.dao.UserDao;
import org.springframework.stereotype.Service;
import pers.swbuild.pojo.User;
import pers.swbuild.service.UserService;

import javax.annotation.Resource;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    public Set<String> getRoles(String userName) {
        return userDao.getRoles(userName);
    }

    public Set<String> getPermissions(String userName) {
        return userDao.getPermissions(userName);
    }
}
