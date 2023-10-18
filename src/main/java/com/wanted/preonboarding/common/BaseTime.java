package com.wanted.preonboarding.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseTime {

    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;
}
