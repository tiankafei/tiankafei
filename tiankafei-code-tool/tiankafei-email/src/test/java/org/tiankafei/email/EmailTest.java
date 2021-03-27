package org.tiankafei.email;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.tiankafei.email.util.EmailSenderUtil;

/**
 * @author tiankafei
 * @since 1.0
 */
public class EmailTest {

    @Test
    public void test01() {
        String emailValidationCode = RandomStringUtils.random(8);

        String subject = "Email验证";
        StringBuffer content = new StringBuffer();
        content.append("验证码：" + emailValidationCode).append("\n").append("请与10分钟内进行验证！");
        //发送邮件
        EmailSenderUtil.senderEmail(subject, content.toString(), "businesssystem@163.com");
    }

}
