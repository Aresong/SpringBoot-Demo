package com.s5.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot11TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //邮件设置
        mailMessage.setSubject("邮箱测试！！！");
        mailMessage.setText("邮件内容测试");
        mailMessage.setTo("37104553@163.com");
        mailMessage.setFrom("szhzzzzz@163.com");
        javaMailSender.send(mailMessage);
    }

    /**复杂的**/
    @Test
    public void test() throws Exception{
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);
        helper.setSubject("标题测试");
        helper.setText("<b style='color:red'>szhzzzzz@163.com</b>",true);
        helper.setTo("37104553@163.com");
        helper.setFrom("szhzzzzz@163.com");
        //上传文件
        helper.addAttachment("1.jpg",new File("上传文件地址"));
        helper.addAttachment("2.jpg",new File("上传文件地址"));
        javaMailSender.send(mailMessage);
    }

}
