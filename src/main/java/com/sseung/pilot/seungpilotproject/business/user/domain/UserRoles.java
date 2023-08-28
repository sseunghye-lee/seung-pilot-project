package com.sseung.pilot.seungpilotproject.business.user.domain;

import com.sseung.pilot.seungpilotproject.commons.BaseEntity;
import com.sseung.pilot.seungpilotproject.commons.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(indexes = {@Index(columnList = "userId, userRole", unique = true)})
public class UserRoles extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5964759107958368227L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(columnDefinition = "varchar(36) COMMENT 'UserRole Id'")
    private String userRoleId;

    @Column(columnDefinition = "bigint COMMENT '회원 ID'", insertable = false, updatable = false)
    private Long userId;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users users;

    @Column(columnDefinition = "varchar(20) COMMENT '권한'")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public static UserRoles makeUserRole(UserRole role){
        return UserRoles.builder().userRole(role).build();
    }

}
