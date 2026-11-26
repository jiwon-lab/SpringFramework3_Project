package mylab.notification.di.annot;

// NotificationService 인터페이스를 구현하는 이메일 서비스
public class EmailNotificationService implements NotificationService {

    // 인스턴스 변수 (Instance Variables)
    private String smtpServer; // 이메일 서버 주소
    private int port;          // 서버 포트 번호

    // 생성자 (Constructor)
    // 외부에서 서버 주소와 포트 번호를 전달받음
    // Constructor Injection (생성자 주입)
    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    // Getter: SMTP 서버 주소 반환
    public String getSmtpServer() {
        return smtpServer;
    }

    // Getter: 포트 번호 반환
    public int getPort() {
        return port;
    }

    // 인터페이스에서 정의한 메서드를 재정의
    @Override
    public void sendNotification(String message) {
        System.out.println("이메일 알림 전송: " + message
                + " (서버: " + smtpServer + ":" + port + ")");
    }
}