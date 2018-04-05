package pers.swbuild.dao;

import pers.swbuild.pojo.User;

import java.util.Set;

public interface UserDao {

    /**
     * @param userName
     * @return
     */
    public User getByUserName(String userName);

    /**
     * @param userName
     * @return
     */
    public Set<String> getRoles(String userName);

    /**
     * @param userName
     * @return
     */
    public Set<String> getPermissions(String userName);
}
