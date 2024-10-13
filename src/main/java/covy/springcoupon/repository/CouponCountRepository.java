package covy.springcoupon.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponCountRepository {
    private final RedisTemplate<String, String> redisTemplate;

    // count 1 증가
    public Long increment() {
        return redisTemplate
                .opsForValue()
                // incr 명령어 호출
                .increment("coupon-count");
    }
}
