package co.com.pragma.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

// This is a sample JPA entity class
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String name;
    private String lastname;
    private Integer age;
    private Integer idType;

    @Column(unique = true)
    private Long idNumber;
}
