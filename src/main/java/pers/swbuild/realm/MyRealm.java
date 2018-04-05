package pers.swbuild.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import pers.swbuild.pojo.User;
import pers.swbuild.service.UserService;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 为当前登录的用户授予角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用户名
        String userName=(String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        // 进行授权角色
        authorizationInfo.setRoles(userService.getRoles(userName));
        // 进行授权权限
        authorizationInfo.setStringPermissions(userService.getPermissions(userName));

        return authorizationInfo;
    }

    /**
     * 验证当前登录的用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=(String)token.getPrincipal();
        // 根据用户名查找用户信息
        User user= userService.getByUserName(userName);

        // 没有，直接抛出异常
        if (user == null) throw new UnknownAccountException();

        AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
        SecurityUtils.getSubject().getSession().setAttribute("userInfo", user);
        return authcInfo;
    }
}

