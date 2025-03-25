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
