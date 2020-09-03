package org.tiankafei.email.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.email.dto.EmailSenderDTO;
import org.tiankafei.email.dto.MyAuthenticatorDTO;

/**
 * 简单邮件（不带附件的邮件）发送器
 *
 * @author tiankafei
 */
public class EmailContentSenderUtil {

    /**
     * 构造简单邮件（不带附件的邮件）发送器对象
     */
    public EmailContentSenderUtil() {

    }

    /**
     * 以文本格式发送邮件
     *
     * @param emailSenderDTO 待发送的邮件的信息
     * @return 返回true or false
     * @throws BaseException 自定义异常
     */
    public boolean sendTextMail(EmailSenderDTO emailSenderDTO) throws BaseException {
        try {
            // 判断是否需要身份认证
            MyAuthenticatorDTO authenticator = null;
            Properties pro = emailSenderDTO.getProperties();
            if (emailSenderDTO.isValidate()) {
                // 如果需要身份认证，则创建一个密码验证器
                authenticator = new MyAuthenticatorDTO(emailSenderDTO.getUserName(), emailSenderDTO.getPassword());
            }
            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(emailSenderDTO.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(emailSenderDTO.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(emailSenderDTO.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            String mailContent = emailSenderDTO.getContent();
            mailMessage.setText(mailContent);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BaseException(ex.getMessage());
        }
    }

    /**
     * 以HTML格式发送邮件
     *
     * @param emailSenderDTO 待发送的邮件信息
     * @return 返回true or false
     * @throws BaseException 自定义异常
     */
    public static boolean sendHtmlMail(EmailSenderDTO emailSenderDTO) throws BaseException {
        try {
            // 判断是否需要身份认证
            MyAuthenticatorDTO authenticator = null;
            Properties pro = emailSenderDTO.getProperties();
            // 如果需要身份认证，则创建一个密码验证器
            if (emailSenderDTO.isValidate()) {
                authenticator = new MyAuthenticatorDTO(emailSenderDTO.getUserName(), emailSenderDTO.getPassword());
            }
            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(emailSenderDTO.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(emailSenderDTO.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(emailSenderDTO.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(emailSenderDTO.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BaseException(ex.getMessage());
        }
    }

}