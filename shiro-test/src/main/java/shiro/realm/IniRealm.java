package shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.config.Ini;
import org.apache.shiro.realm.Realm;

public class IniRealm implements Realm {

    // 返回一个唯一的Realm名字
    @Override
    public String getName() {
        System.out.println("iniRealm.getName()");
        return "iniRealm";
    }

    // 判断此Realm是否支持此Token
    @Override
    public boolean supports(AuthenticationToken token) {
        System.out.println("iniRealm.supports()");
        // 仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    // 根据Token获取认证信息
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名和密码
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 验证用户名密码
        Ini ini = Ini.fromResourcePath("classpath:shiro.ini");
        if (!ini.getSection("users").containsKey(username)) {
            // 错误的帐号
            throw new UnknownAccountException();
        }
        String pwd = ini.getSectionProperty("users", username);
        if (!pwd.equals(password)) {
            // 错误的凭证
            throw new IncorrectCredentialsException();
        }

        // 身份认证成功，返回AuthenticationInfo
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
