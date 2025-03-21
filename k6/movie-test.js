import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 100,            // 가상 유저 수 (동시 접속 사용자 수)
    duration: '10s',    // 테스트 지속 시간
};

export default function () {
    const res = http.get('http://localhost:8080/rest/api/v1/movie/now-playing');

    check(res, {
        'status is 200': (r) => r.status === 200,
        'body is not empty': (r) => r.body && r.body.length > 0,
    });

    sleep(1); // 사용자 think time
}
