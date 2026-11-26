package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

// JUnit에서 제공하는 검증 메서드
import static org.junit.jupiter.api.Assertions.*;

// NotificationConfig를 기반으로 Spring Container를 생성
// JUnit 5와 Spring Test를 연결하는 어노테이션
@SpringJUnitConfig(NotificationConfig.class)
public class NotificationConfigTest {

    // Spring Container에 등록된 NotificationManager Bean 주입
    @Autowired
    private NotificationManager notificationManager;

    // 1. NotificationManager 생성 여부 검증
    @Test
    public void testNotificationManager() {

        // 객체가 null이 아닌지 확인
        assertNotNull(notificationManager);
    }

    // 2. 이메일 서비스 검증
    @Test
    public void testEmailService() {

        // 이메일 서비스가 정상적으로 주입되었는지 확인
        assertNotNull(notificationManager.getEmailService());

        // 인터페이스 타입을 실제 구현 클래스 타입으로 변환
        // Downcasting (다운캐스팅)
        EmailNotificationService emailService =
            (EmailNotificationService) notificationManager.getEmailService();

        // SMTP 서버 주소가 예상한 값과 일치하는지 확인
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());

        // 포트 번호가 587인지 확인
        assertEquals(587, emailService.getPort());
    }

    // 3. SMS 서비스 검증
    @Test
    public void testSmsService() {

        // SMS 서비스가 정상적으로 주입되었는지 확인
        assertNotNull(notificationManager.getSmsService());

        // 인터페이스 타입을 실제 구현 클래스 타입으로 변환
        SmsNotificationService smsService =
            (SmsNotificationService) notificationManager.getSmsService();

        // SMS 제공업체가 SKT인지 확인
        assertEquals("SKT", smsService.getProvider());
    }

    // 4. NotificationManager 메서드 실행 테스트
    @Test
    public void testSendNotification() {

        // 이메일 알림 전송 메서드 실행
        notificationManager.sendNotificationByEmail("테스트 이메일");

        // SMS 알림 전송 메서드 실행
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}