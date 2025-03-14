# 각 모듈별 STATE 값 정의

## 1. SCHEDULE (상영 스케줄) - 상영 상태
| STATE 값      | 설명 |
|--------------|------------------------|
| `SCHEDULED`  | 예정된 상영 (예약 가능) |
| `ONGOING`    | 현재 상영 중 |
| `COMPLETED`  | 상영 종료 |
| `CANCELED`   | 상영 취소 |

### 비즈니스 로직
- `SCHEDULED` → `ONGOING` (시작 시간이 되면 자동 변경)
- `ONGOING` → `COMPLETED` (종료 시간이 지나면 자동 변경)
- `SCHEDULED` → `CANCELED` (관리자 취소 가능)

---

## 2. RESERVATION (예약) - 예약 상태
| STATE 값      | 설명 |
|-------------|----------------------|
| `PENDING`   | 예약 대기 (결제 전) |
| `CONFIRMED` | 예약 확정 (결제 완료) |
| `CANCELED`  | 예약 취소 |
| `USED`      | 사용 완료 (입장 완료) |
| `EXPIRED`   | 사용 기한 초과 (미사용) |

### 비즈니스 로직
- `PENDING` → `CONFIRMED` (결제 성공 시)
- `PENDING` → `CANCELED` (사용자 취소 시)
- `CONFIRMED` → `USED` (입장 완료 시)
- `CONFIRMED` → `EXPIRED` (상영 시작 후 미사용 시)

---

## 3. SEAT (좌석) - 좌석 상태
| STATE 값    | 설명 |
|-----------|----------------|
| `AVAILABLE` | 사용 가능 |
| `RESERVED`  | 예약됨 |
| `OCCUPIED`  | 사용 중 (상영 시작됨) |
| `BROKEN`    | 고장난 좌석 |
| `BLOCKED`   | 사용 불가 (VIP석 등) |

### 비즈니스 로직
- `AVAILABLE` → `RESERVED` (예약 시)
- `RESERVED` → `OCCUPIED` (영화 시작 후)
- `RESERVED` → `AVAILABLE` (예약 취소 시)
- `AVAILABLE` → `BROKEN` (고장 처리 시)
- `AVAILABLE` → `BLOCKED` (특별 좌석 지정 시)

---

## 4. SCREEN (상영관) - 상영관 운영 상태
| STATE 값       | 설명 |
|-------------|----------------|
| `OPEN`      | 정상 운영 중 |
| `CLOSED`    | 운영 종료 |
| `MAINTENANCE` | 점검 중 |

### 비즈니스 로직
- `OPEN` ↔ `MAINTENANCE` (점검 모드 전환)
- `OPEN` ↔ `CLOSED` (영구 폐쇄된 경우)

---

## 5. CINEMA (영화관) - 영화관 운영 상태
| STATE 값      | 설명 |
|-------------|----------------|
| `OPEN`      | 정상 운영 중 |
| `CLOSED`    | 폐점 |
| `RENOVATION` | 리모델링 중 |

### 비즈니스 로직
- `OPEN` ↔ `RENOVATION` (리모델링 시작/완료)
- `OPEN` ↔ `CLOSED` (지점 폐쇄)

---

## 최종 정리
✅ `SCHEDULE`: `SCHEDULED`, `ONGOING`, `COMPLETED`, `CANCELED`<br/>
✅ `RESERVATION`: `PENDING`, `CONFIRMED`, `CANCELED`, `USED`, `EXPIRED`<br/>
✅ `SEAT`: `AVAILABLE`, `RESERVED`, `OCCUPIED`, `BROKEN`, `BLOCKED`<br/>
✅ `SCREEN`: `OPEN`, `CLOSED`, `MAINTENANCE`<br/>
✅ `CINEMA`: `OPEN`, `CLOSED`, `RENOVATION`
