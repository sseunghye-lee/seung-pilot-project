package com.sseung.pilot.seungpilotproject.commons;

import com.sseung.pilot.seungpilotproject.commons.mapper.GenericMapper;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedBy
    @Column(updatable = false)
    protected Long createdBy;

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @Column
    protected Long modifiedBy;

    @LastModifiedDate
    @Column
    protected LocalDateTime modifiedDate;

    public <D, E> D toDto(GenericMapper<D, E> mapper) {
        return mapper.toDto((E) this);
    }

    public <D, E> void updateFromDto(GenericMapper<D, E> mapper, D dto) {
        mapper.updateEntity(dto, (E) this);
    }
}
