package mylab.notification.di.annot;

// 이메일과 SMS 서비스가 공통으로 사용하는 인터페이스
public interface NotificationService {

    // 알림 전송 기능 정의
    // 실제 전송 기능은 각각의 구현 클래스에서 작성
    void sendNotification(String message);

}