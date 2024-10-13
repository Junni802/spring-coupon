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
    
    // 등록된 key모두 제거(테스트코드용)
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }
}
