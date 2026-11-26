package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring에게 설정 클래스임을 알려주는 어노테이션
@Configuration
public class NotificationConfig {

    // 이메일 서비스 객체를 생성하고 Spring Bean으로 등록
    @Bean
    public EmailNotificationService emailService() {

        // 생성자를 통해 SMTP 서버 주소와 포트 번호 주입
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    // SMS 서비스 객체를 생성하고 Spring Bean으로 등록
    @Bean
    public SmsNotificationService smsService() {

        // 생성자를 통해 SMS 제공업체 정보 주입
        return new SmsNotificationService("SKT");
    }

    // NotificationManager 객체를 Spring Bean으로 등록
    @Bean
    public NotificationManager notificationManager() {

        // 앞서 등록한 이메일과 SMS Bean을 생성자에 주입
        // Constructor Injection (생성자 주입)
        return new NotificationManager(emailService(), smsService());
    }
}