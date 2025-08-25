package co.com.pragma.model.user;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Here you can define the fields of the User model
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private String name;
    private String lastname;
    private Integer age;
    private Integer idType;
    private Long idNumber;
}
