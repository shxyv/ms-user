package com.atl.msuser.dao.entity;

import com.atl.msuser.model.constant.FreeLicenceStatus;
import com.atl.msuser.model.constant.TopicType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "topic_type")
    @Enumerated
    private TopicType topicType;

    @Column(name = "free_subscription_status")
    private FreeLicenceStatus freeLicenceStatus;

    private Integer age;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
