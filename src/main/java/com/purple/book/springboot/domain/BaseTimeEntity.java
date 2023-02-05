package com.purple.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 이 클래스를 상속할 경우 필드들도 컬럼으로 인식하도록 -> 모든 Entity의 상위 클래스가 됨
@EntityListeners(AuditingEntityListener.class) // Auditing 기능
public class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때
    private LocalDateTime createDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때
    private LocalDateTime modifiedDate;
}
