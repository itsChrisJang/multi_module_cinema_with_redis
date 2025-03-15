# Redis_project  

```bash
redis-project/
│── application/      # Use Case (비즈니스 로직)
│   ├── src/main/java/com/example/application/
│   │   ├── usecase/  # 유스케이스 정의
│   │   ├── service/  # 서비스 계층
│   │   ├── dto/      # DTO 클래스
│   │   ├── event/    # 이벤트 핸들러 (Kafka, Redis Pub/Sub 등)
│── domain/           # Core Business Logic (순수한 도메인)
│   ├── src/main/java/com/example/domain/
│   │   ├── model/    # 도메인 엔티티
│   │   ├── repository/  # 도메인 레포지토리 인터페이스
│── infrastructure/   # 외부 인프라 (DB, Redis, API)
│   ├── src/main/java/com/example/infrastructure/
│   │   ├── repository/  # JPA, MyBatis, Redis 구현체
│   │   ├── config/   # Spring 설정 관련
│── presentation/     # Controller, Web 관련 처리
│   ├── src/main/java/com/example/presentation/
│   │   ├── controller/  # API 엔드포인트
│   │   ├── handler/     # 예외 핸들러
│── config/            # 공통 설정 (yml, security 설정)
│── build.gradle
│── settings.gradle
```

## Multi Module

## Architecture
- 클린 아키텍처
- 
## Table Design
![img](./image/erd.png)
 
