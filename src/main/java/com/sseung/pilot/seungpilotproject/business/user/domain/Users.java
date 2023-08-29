package com.sseung.pilot.seungpilotproject.business.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sseung.pilot.seungpilotproject.commons.BaseEntity;
import com.sseung.pilot.seungpilotproject.commons.dto.request.user.SignUpRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.user.SignUpResponse;
import com.sseung.pilot.seungpilotproject.commons.enums.Gender;
import com.sseung.pilot.seungpilotproject.commons.enums.UserRole;
import com.sseung.pilot.seungpilotproject.commons.utils.ModelMapperUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7736430912768305885L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint COMMENT '사용자 아이디'")
    private Long userId;

    @Column(unique = true, columnDefinition = "varchar(255) COMMENT '이메일'")
    private String userEmail;

    @Column(columnDefinition = "varchar(255) COMMENT '패스워드'")
    private String loginPw;

    @Column(columnDefinition = "varchar(50) COMMENT '이름'")
    private String userName;

    @Column(columnDefinition = "varchar(50) COMMENT '휴대폰 번호'")
    private String userPhoneNumber;

    @Column(unique = true, columnDefinition = "varchar(20) COMMENT '닉네임'")
    private String nickName;

    @Column(columnDefinition = "varchar(10) COMMENT '생년월일'")
    private String birth;

    @Column(columnDefinition = "varchar(10) COMMENT '성별'")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRoles> userRoles = new ArrayList<>();

    public static Users init(SignUpRequest request) {
        Users user = ModelMapperUtil.get().map(request, Users.class);
        user.addUserRoles(UserRole.ROLE_USER);
        return user;
    }

    public void addUserRoles(UserRole userRole) {
        UserRoles role = UserRoles.makeUserRole(userRole);
        userRoles.add(role);
        role.setUsers(this);
    }

    public SignUpResponse convertSignUpResponse() {
        return new SignUpResponse(userEmail, userName);
    }

}
