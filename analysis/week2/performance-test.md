# Redis_project
## 2주차
### Projection 적용 전 API 성능 테스트 결과 (캐싱 미적용 상태)

---
### k6 script
<details>
<summary>script</summary>

```shell
import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomItem, randomIntBetween } from 'https://jslib.k6.io/k6-utils/1.4.0/index.js';

export const options = {
    scenarios: {
        rps_limit_test: {
            executor: 'ramping-arrival-rate',
            startRate: 50,
            timeUnit: '1s',
            preAllocatedVUs: 100,
            maxVUs: 500,
            stages: [
                { target: 100, duration: '20s' },
                { target: 200, duration: '20s' },
                { target: 300, duration: '20s' },
                { target: 400, duration: '20s' },
                { target: 0, duration: '10s' },
            ],
        },
    },
};

// 🎬 Movie title 리스트: Movie1 ~ Movie30
const titles = Array.from({ length: 30 }, (_, i) => `Movie${i + 1}`);

// 🎭 MovieGenre Enum 값 (백엔드에서 사용하는 실제 enum 키)
const genres = [
    'ACTION',
    'COMEDY',
    'DRAMA',
    'FANTASY',
    'HORROR',
    'MYSTERY',
    'ROMANCE',
    'SCI_FI',
    'THRILLER',
    'ANIMATION'
];

export default function () {
    // 랜덤하게 title, genre를 사용할지 말지 결정
    const useTitle = Math.random() > 0.3; // 70% 확률 사용
    const useGenre = Math.random() > 0.5; // 50% 확률 사용

    const queryParams = [];

    if (useTitle) {
        const title = randomItem(titles);
        queryParams.push(`title=${encodeURIComponent(title)}`);
    }

    if (useGenre) {
        const genre = randomItem(genres);
        queryParams.push(`genre=${encodeURIComponent(genre)}`);
    }

    const url = `http://localhost:8080/rest/api/v1/movie/now-playing${
        queryParams.length ? '?' + queryParams.join('&') : ''
    }`;

    const res = http.get(url);

    check(res, {
        'status is 200': (r) => r.status === 200,
        'response time < 500ms': (r) => r.timings.duration < 500,
    });

    sleep(randomIntBetween(1, 3)); // 유저 간 요청 간격
}

```

</details>

## ✅ 테스트 개요

| 항목 | 값 |
|------|----|
| 테스트 대상 API | `GET /rest/api/v1/movie/now-playing` |
| 테스트 도구 | k6 (ramping-arrival-rate) |
| 최대 RPS(Target) | 400 |
| 최대 VU | 500 |
| 총 요청 수 | 15,596 |
| 테스트 총 시간 | 약 1분 30초 + gracefulStop 30초 |
| 쿼리 조건 | title / genre 랜덤 조합 |

---

## 인덱스 적용 전 응답 성능 결과

### k6 result
<details>
<summary>result</summary>

```shell
k6 run movie-test.js

         /\      Grafana   /‾‾/
    /\  /  \     |\  __   /  /
   /  \/    \    | |/ /  /   ‾‾\
  /          \   |   (  |  (‾)  |
 / __________ \  |_|\_\  \_____/

     execution: local
        script: movie-test.js
        output: -

     scenarios: (100.00%) 1 scenario, 500 max VUs, 2m0s max duration (incl. graceful stop):
              * rps_limit_test: Up to 400.00 iterations/s for 1m30s over 5 stages (maxVUs: 100-500, gracefulStop: 30s)

WARN[0053] Insufficient VUs, reached 500 active VUs and cannot initialize more  executor=ramping-arrival-rate scenario=rps_limit_test

     ✓ status is 200
     ✓ response time < 500ms

     checks.........................: 100.00% 31192 out of 31192
     data_received..................: 20 MB   217 kB/s
     data_sent......................: 2.0 MB  21 kB/s
     dropped_iterations.............: 2904    31.223389/s
     http_req_blocked...............: avg=25.34µs min=1µs   med=7µs    max=11.25ms  p(90)=13µs   p(95)=23µs
     http_req_connecting............: avg=13.4µs  min=0s    med=0s     max=2.73ms   p(90)=0s     p(95)=0s
     http_req_duration..............: avg=2.69ms  min=780µs med=2.1ms  max=348.21ms p(90)=3.72ms p(95)=4.57ms
       { expected_response:true }...: avg=2.69ms  min=780µs med=2.1ms  max=348.21ms p(90)=3.72ms p(95)=4.57ms
     http_req_failed................: 0.00%   0 out of 15596
     http_req_receiving.............: avg=66.87µs min=9µs   med=57µs   max=2.96ms   p(90)=102µs  p(95)=124µs
     http_req_sending...............: avg=27.85µs min=4µs   med=24µs   max=3.9ms    p(90)=41µs   p(95)=50µs
     http_req_tls_handshaking.......: avg=0s      min=0s    med=0s     max=0s       p(90)=0s     p(95)=0s
     http_req_waiting...............: avg=2.59ms  min=740µs med=2.01ms max=347.18ms p(90)=3.59ms p(95)=4.41ms
     http_reqs......................: 15596   167.685944/s
     iteration_duration.............: avg=1.99s   min=1s    med=2s     max=3.35s    p(90)=3s     p(95)=3s
     iterations.....................: 15596   167.685944/s
     vus............................: 1       min=1              max=500
     vus_max........................: 500     min=100            max=500


running (1m33.0s), 000/500 VUs, 15596 complete and 0 interrupted iterations
rps_limit_test ✓ [======================================] 000/500 VUs  1m30s  004.47 iters/s
```

</details>

| 지표 | 결과 |
|------|------|
| 평균 응답시간 | 2.69 ms |
| P95 응답시간 | 4.57 ms |
| P90 응답시간 | 3.72 ms |
| 최대 응답시간 | 348 ms |
| 실패율 | 0.00% (모든 요청 200 OK) |

## ⚠️ 병목 및 경고

| 항목 | 내용 |
|------|------|
| 드롭된 요청 수 (`dropped_iterations`) | **2,904건** |
| 원인 | 최대 VU 도달 (`500`) 이후 RPS를 감당하지 못해 요청 누락 발생 |
| 경고 로그 | `WARN[0053] Insufficient VUs, reached 500 active VUs and cannot initialize more` |

## 📊 분석

- ✅ **응답 속도 매우 우수**: P95 4.57ms, 평균 2.69ms로 빠름
- ✅ **정상 처리율 100%**, 에러 없음
- ⚠️ **최대 처리 RPS는 약 300대 초반**으로 추정
- ⚠️ **400 RPS 도달 시점에서 처리 한계 발생 (VU 부족 → 드롭 요청)**

---

## 인덱스 적용 후 성능 결과

<details>
<summary>result</summary>

```shell
k6 run movie-test.js

         /\      Grafana   /‾‾/
    /\  /  \     |\  __   /  /
   /  \/    \    | |/ /  /   ‾‾\
  /          \   |   (  |  (‾)  |
 / __________ \  |_|\_\  \_____/

     execution: local
        script: movie-test.js
        output: -

     scenarios: (100.00%) 1 scenario, 500 max VUs, 2m0s max duration (incl. graceful stop):
              * rps_limit_test: Up to 400.00 iterations/s for 1m30s over 5 stages (maxVUs: 100-500, gracefulStop: 30s)

WARN[0052] Insufficient VUs, reached 500 active VUs and cannot initialize more  executor=ramping-arrival-rate scenario=rps_limit_test

     ✓ status is 200
     ✓ response time < 500ms

     checks.........................: 100.00% 31206 out of 31206
     data_received..................: 20 MB   218 kB/s
     data_sent......................: 2.0 MB  21 kB/s
     dropped_iterations.............: 2897    31.126984/s
     http_req_blocked...............: avg=25.79µs min=1µs   med=7µs    max=7.32ms   p(90)=13µs   p(95)=22µs
     http_req_connecting............: avg=14.46µs min=0s    med=0s     max=7.25ms   p(90)=0s     p(95)=0s
     http_req_duration..............: avg=2.85ms  min=876µs med=2.22ms max=135.53ms p(90)=4.17ms p(95)=5.35ms
       { expected_response:true }...: avg=2.85ms  min=876µs med=2.22ms max=135.53ms p(90)=4.17ms p(95)=5.35ms
     http_req_failed................: 0.00%   0 out of 15603
     http_req_receiving.............: avg=66.48µs min=7µs   med=55µs   max=3.65ms   p(90)=104µs  p(95)=137µs
     http_req_sending...............: avg=27.88µs min=3µs   med=24µs   max=3.18ms   p(90)=41µs   p(95)=51µs
     http_req_tls_handshaking.......: avg=0s      min=0s    med=0s     max=0s       p(90)=0s     p(95)=0s
     http_req_waiting...............: avg=2.75ms  min=830µs med=2.14ms max=135.48ms p(90)=4.03ms p(95)=5.18ms
     http_reqs......................: 15603   167.647337/s
     iteration_duration.............: avg=1.99s   min=1s    med=2s     max=3.13s    p(90)=3s     p(95)=3s
     iterations.....................: 15603   167.647337/s
     vus............................: 1       min=1              max=500
     vus_max........................: 500     min=100            max=500


running (1m33.1s), 000/500 VUs, 15603 complete and 0 interrupted iterations
rps_limit_test ✓ [======================================] 000/500 VUs  1m30s  004.47 iters/s
```
</details>

### 



