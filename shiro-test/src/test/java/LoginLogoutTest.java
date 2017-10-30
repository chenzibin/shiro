import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by chenzb on 2017/8/2.
 */
public class LoginLogoutTest {

//    @Test
    public void testLogin(String source) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(source);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        PrincipalCollection principalCollection = subject.getPrincipals();
        Iterator it = principalCollection.asSet().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println();
        }

        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testIni(){
        Ini ini = Ini.fromResourcePath("classpath:shiro-realm.ini");
        System.out.println();
    }

    @Test
    public void testLogin2() {
        String allSuccess = "classpath:shiro-authenticator-all-success.ini";
        testLogin(allSuccess);


    }
}
