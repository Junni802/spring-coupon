import http from 'k6/http';
import { check, sleep } from 'k6';

// 초당 5000명의 user가 10초간 요청을 보내는 상황을 가정
export const options = {
    // A number specifying the number of VUs to run concurrently.
    vus: 5000,
    // A string specifying the total duration of the test run.
    duration: '10s',
};

export default function() {
    // 요청 본문 데이터
    const userId = __VU; // __VU : 현재 가상 사용자 ID
    const payload = JSON.stringify({
        userId: userId.toString(),
    });

    // POST 요청 헤더
    const headers = {
        'Content-Type': 'application/json',
    };

    // POST 요청
    const response = http.post('http://localhost:8081/coupon/apply', payload, {headers});

    // 응답 검증
    check(response, {
        "is OK": (response) => response.status === 200,
    });
}
