package mylab.notification.di.annot;

// NotificationService 인터페이스를 구현하는 SMS 서비스
public class SmsNotificationService implements NotificationService {

    // 인스턴스 변수 (Instance Variable)
    private String provider; // SMS 서비스 제공업체

    // 생성자 (Constructor)
    // 외부에서 SMS 제공업체 정보를 전달받음
    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    // Getter: SMS 제공업체 정보 반환
    public String getProvider() {
        return provider;
    }

    // 인터페이스에서 정의한 메서드를 재정의
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS 알림 전송: " + message
                + " (제공업체: " + provider + ")");
    }
}