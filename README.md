# Redis_project  

```bash
tree
.
├── MODULE_STATE
│   └── README.md
├── README.md
├── build
│   └── reports
│       └── problems
│           └── problems-report.html
├── build.gradle
├── db_table.png
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── image
│   └── erd.png
├── module_application
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       └── classes
│   │           └── project
│   │               └── redis
│   │                   └── movie
│   │                       ├── dto
│   │                       │   ├── NowPlayMovieDto$NowPlayMovieDtoBuilder.class
│   │                       │   └── NowPlayMovieDto.class
│   │                       └── service
│   │                           └── MovieService.class
│   └── src
│       └── main
│           ├── generated
│           └── java
│               └── project
│                   └── redis
│                       └── movie
│                           ├── dto
│                           │   └── CurrentPlayingMovieDto.java
│                           └── service
│                               └── MovieService.java
├── module_common
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── project
│                   └── redis
│                       └── Main.java
├── module_domain
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       └── classes
│   │           └── project
│   │               └── redis
│   │                   ├── cinema
│   │                   │   ├── Cinema.class
│   │                   │   └── CinemaSeats.class
│   │                   ├── movie
│   │                   │   ├── Movie.class
│   │                   │   ├── MovieGenre.class
│   │                   │   └── MovieRate.class
│   │                   ├── screening
│   │                   │   └── Screening.class
│   │                   └── seat
│   │                       └── Seat.class
│   └── src
│       └── main
│           ├── generated
│           └── java
│               └── project
│                   └── redis
│                       ├── cinema
│                       │   ├── Cinema.java
│                       │   └── CinemaSeats.java
│                       ├── movie
│                       │   ├── Movie.java
│                       │   ├── MovieGenre.java
│                       │   └── MovieRate.java
│                       ├── schedule
│                       │   └── Schedule.java
│                       ├── screen
│                       │   └── Screen.java
│                       └── seat
│                           ├── Seat.java
│                           └── SeatStatus.java
├── module_infrastructure
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       └── classes
│   │           └── project
│   │               └── redis
│   │                   ├── cinema
│   │                   │   ├── entity
│   │                   │   │   ├── CinemaEntity$CinemaEntityBuilder.class
│   │                   │   │   └── CinemaEntity.class
│   │                   │   └── mapper
│   │                   │       ├── CinemaMapper.class
│   │                   │       └── CinemaMapperImpl.class
│   │                   ├── common
│   │                   │   ├── config
│   │                   │   │   └── JpaConfig.class
│   │                   │   └── entity
│   │                   │       └── BaseEntity.class
│   │                   ├── movie
│   │                   │   ├── adapter
│   │                   │   │   └── MovieAdapter.class
│   │                   │   ├── entity
│   │                   │   │   ├── MovieEntity$MovieEntityBuilder.class
│   │                   │   │   └── MovieEntity.class
│   │                   │   ├── mapper
│   │                   │   │   ├── MovieMapper.class
│   │                   │   │   └── MovieMapperImpl.class
│   │                   │   └── repository
│   │                   │       └── MovieRepository.class
│   │                   ├── screening
│   │                   │   ├── adapter
│   │                   │   │   └── ScreeningAdapter.class
│   │                   │   ├── entity
│   │                   │   │   ├── ScreeningEntity$ScreeningEntityBuilder.class
│   │                   │   │   └── ScreeningEntity.class
│   │                   │   ├── mapper
│   │                   │   │   ├── ScreeningMapper.class
│   │                   │   │   └── ScreeningMapperImpl.class
│   │                   │   └── repository
│   │                   │       └── ScreeningRepository.class
│   │                   └── seat
│   │                       ├── entity
│   │                       │   ├── SeatEntity$SeatEntityBuilder.class
│   │                       │   └── SeatEntity.class
│   │                       └── mapper
│   │                           ├── SeatMapper.class
│   │                           └── SeatMapperImpl.class
│   └── src
│       └── main
│           ├── generated
│           └── java
│               └── project
│                   └── redis
│                       ├── common
│                       │   ├── config
│                       │   │   └── JpaConfig.java
│                       │   └── entity
│                       │       └── BaseEntity.java
│                       ├── movie
│                       │   ├── adapter
│                       │   │   └── MovieAdapter.java
│                       │   ├── entity
│                       │   │   └── MovieEntity.java
│                       │   ├── mapper
│                       │   │   ├── MovieMapper.java
│                       │   │   └── MovieMapperImpl.java
│                       │   └── repository
│                       │       └── MovieRepository.java
│                       ├── schedule
│                       │   ├── adapter
│                       │   │   └── ScheduleAdapter.java
│                       │   ├── entity
│                       │   │   └── ScheduleEntity.java
│                       │   ├── mapper
│                       │   │   ├── ScheduleMapper.java
│                       │   │   └── ScreeningMapperImpl.java
│                       │   └── repository
│                       │       └── ScheduleRepository.java
│                       ├── screen
│                       │   ├── entity
│                       │   │   └── ScreenEntity.java
│                       │   └── mapper
│                       │       ├── ScreenMapper.java
│                       │       └── ScreenMapperImpl.java
│                       └── seat
│                           ├── entity
│                           │   └── SeatEntity.java
│                           └── mapper
│                               ├── SeatMapper.java
│                               └── SeatMapperImpl.java
├── module_presentation
│   ├── build.gradle
│   ├── out
│   │   └── production
│   │       ├── classes
│   │       │   └── project
│   │       │       └── redis
│   │       │           ├── CinemaApplication.class
│   │       │           ├── movie
│   │       │           │   ├── controller
│   │       │           │   │   └── MovieController.class
│   │       │           │   └── dto
│   │       │           │       └── NowPlayingMovieResponseDto.class
│   │       │           └── screening
│   │       │               └── dto
│   │       │                   └── ScreeningDto.class
│   │       └── resources
│   │           └── application.yml
│   └── src
│       └── main
│           ├── generated
│           ├── java
│           │   └── project
│           │       └── redis
│           │           ├── CinemaApplication.java
│           │           ├── movie
│           │           │   ├── controller
│           │           │   │   └── MovieController.java
│           │           │   └── dto
│           │           │       └── NowPlayingMovieResponseDto.java
│           │           └── schedule
│           │               └── dto
│           │                   └── ScreeningDto.java
│           └── resources
│               └── application.yml
├── settings.gradle
└── setup_project.sh

127 directories, 89 files
```

## Multi Module

이 프로젝트는 **멀티 모듈(Multi Module)** 구조를 활용하여 **관심사의 분리(Separation of Concerns, SoC)**와 **유지보수성 향상**을 목표로 합니다. 각 모듈은 특정 기능을 담당하며 독립적으로 개발, 테스트 및 배포할 수 있습니다.

### 📌 **멀티 모듈 구성**
- **application**: 비즈니스 로직 및 유스케이스 정의
- **domain**: 핵심 도메인 모델 및 도메인 로직 포함
- **infrastructure**: 데이터베이스, Redis, API 연동 등 외부 시스템과의 연결
- **presentation**: API 엔드포인트 및 사용자 요청 처리
- **config**: 프로젝트 공통 설정 및 보안 관련 설정 관리

각 모듈은 독립적으로 테스트 가능하며, 변경이 필요할 경우 특정 모듈만 수정하여 **애플리케이션 전체에 영향을 최소화**할 수 있습니다.

### 📌 **Gradle 멀티 모듈 설정**
`settings.gradle`
```gradle
rootProject.name = 'redis-project'
include ':movie'
include ':schedule'
include ':screen'
include 'reservation'
```

---

## Architecture

이 프로젝트는 **DDD(Domain-Driven Design)** 원칙을 따르면서, **Hexagonal Architecture (Ports and Adapters)**를 기반으로 설계되었습니다.

### 📌 **아키텍처 개요**
```
│── application/      # Use Case (비즈니스 로직)
│── domain/          # Core Business Logic (순수한 도메인)
│── infrastructure/   # 외부 인프라 (DB, Redis, API)
│── presentation/     # Controller, Web 관련 처리
```

### 📌 **각 계층 역할**
- **Domain (도메인 계층)**  
  - 프로젝트의 핵심 비즈니스 로직을 포함하는 순수한 도메인 모델
  - **의존성 없음 (Zero Dependency)** → JPA, Spring 등 기술 스택과 분리
  - `model/` 폴더에 엔티티 및 VO(Value Object) 정의
  - `repository/` 인터페이스를 통해 영속성 계층과의 의존성 분리
  
- **Application (애플리케이션 계층)**  
  - 도메인 로직을 애플리케이션 요구사항에 맞게 조합
  - `usecase/` 폴더에서 유스케이스를 정의하고, 서비스 로직을 담당
  - DTO 및 이벤트 핸들러 (Kafka, Redis Pub/Sub 등) 포함
  
- **Infrastructure (인프라 계층)**  
  - 데이터베이스, Redis, 외부 API와의 통신 담당
  - `repository/` 패키지에서 JPA, MyBatis 등의 구현체 관리
  - `config/` 폴더에서 Spring 설정 관련 파일 포함
  
- **Presentation (프레젠테이션 계층)**  
  - API 엔드포인트 제공 및 요청을 처리하는 컨트롤러 포함
  - `controller/` 폴더에서 REST API 구현
  - `handler/`에서 예외 처리 및 공통 응답 처리 담당
  
### 📌 **ERD 기반 모듈 분리**
이 프로젝트의 모듈은 **ERD 테이블을 기준으로 분리**되어 있으며, 각 테이블은 아래와 같이 대응됩니다.

#### **Domain 모듈** (도메인 모델 정의)
- `SEAT`
- `SCREEN`
- `SCHEDULE`
- `RESERVATION`
- `MOVIE`

#### **Application 모듈** (비즈니스 로직 및 유스케이스 정의)
- 좌석 예약 및 상태 관리 (`SEAT`, `RESERVATION`)
- 상영 스케줄 생성 및 관리 (`SCHEDULE`, `MOVIE`)
- 상영관 관리 (`SCREEN`)

#### **Infrastructure 모듈** (데이터베이스, Redis, API 연동)
- JPA 기반의 Repository 구현 (`SEAT`, `SCREEN`, `SCHEDULE`, `RESERVATION`, `MOVIE` 저장 및 조회)
- Redis 캐싱 적용 (예매 상태 캐싱)
- 외부 API 연동 (영화 정보 제공 API)

#### **Presentation 모듈** (API 엔드포인트 및 요청 처리)
- 좌석 예매 API (`/reservation`)
- 상영 스케줄 조회 API (`/schedule`)
- 영화 목록 및 상세 조회 API (`/movie`)
- 상영관 정보 조회 API (`/screen`)

### 📌 **아키텍처 장점**
✅ **관심사 분리** → 도메인, 애플리케이션, 인프라, 프레젠테이션을 명확히 구분해 유지보수 용이  
✅ **유연성 & 확장성** → 특정 모듈을 독립적으로 테스트하거나 변경 가능  
✅ **기술 독립성 유지** → `domain` 계층은 기술 스택에 의존하지 않음  
✅ **테스트 용이성** → 도메인 및 애플리케이션 로직을 Mocking하여 유닛 테스트 가능  

이와 같은 구조를 통해 **확장 가능하고 유지보수하기 쉬운 애플리케이션**을 구축할 수 있습니다.


## Table Design
![img](./image/erd.png)

#### 참고 
[우아한 기술블로그 - 멀티모듈 설계 이야기 with Spring, Gradle](https://techblog.woowahan.com/2637/)
