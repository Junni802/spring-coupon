package covy.springcoupon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // coupon id

    @Getter
    private Long userId; // 쿠폰을 발급받은 사용자의 id

    public Coupon(Long userId) {
        this.userId = userId;
    }
}
