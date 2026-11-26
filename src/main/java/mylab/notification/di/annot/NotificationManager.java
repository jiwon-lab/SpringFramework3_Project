package mylab.notification.di.annot;

// 이메일과 SMS 알림 서비스를 중앙에서 관리하는 클래스
public class NotificationManager {

    // 인스턴스 변수 (Instance Variables)
    // 구체적인 구현 클래스가 아닌 인터페이스 타입으로 선언
    private NotificationService emailService;
    private NotificationService smsService;

    // 생성자 주입 (Constructor Injection)
    // 외부에서 생성된 이메일과 SMS 서비스 객체를 전달받음
    public NotificationManager(
            NotificationService emailService,
            NotificationService smsService) {

        this.emailService = emailService;
        this.smsService = smsService;
    }

    // Getter: 주입받은 이메일 서비스 객체 반환
    public NotificationService getEmailService() {
        return emailService;
    }

    // Getter: 주입받은 SMS 서비스 객체 반환
    public NotificationService getSmsService() {
        return smsService;
    }

    // 이메일 서비스를 이용하여 메시지 전송
    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    // SMS 서비스를 이용하여 메시지 전송
    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}