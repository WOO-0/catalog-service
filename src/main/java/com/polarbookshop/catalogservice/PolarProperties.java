package com.polarbookshop.catalogservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar") // 이 클래스는 'polar' 접두사를 가진 설정 속성을 매핑한다.
public class PolarProperties {
    private String greeting; // 사용자 정의 속성인 polar.greeting(프리픽스 + 필드명) 속성이 문자열로 인식되는 필드

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
