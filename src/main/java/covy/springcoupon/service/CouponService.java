package covy.springcoupon.service;

import covy.springcoupon.entity.Coupon;
import covy.springcoupon.repository.CouponCountRepository;
import covy.springcoupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public void apply(Long userId) {
        // 쿠폰 개수 조회
        Long increment = couponCountRepository.increment();

        // 쿠폰의 개수가 발급 가능한 개수보다 많은 경우 -> 발급 불가
        if(increment > 100) {
            return;
        }

        // 발급이 가능한 경우 ->  쿠폰 새로 생성(발급)
        couponRepository.save(new Coupon(userId));
    }
}
