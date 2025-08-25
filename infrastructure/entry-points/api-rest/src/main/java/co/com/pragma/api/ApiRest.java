package co.com.pragma.api;
import co.com.pragma.api.dto.CreateUserDTO;
import co.com.pragma.api.dto.EditUserDTO;
import co.com.pragma.api.dto.UserDTO;
import co.com.pragma.api.mapper.UserDTOMapper;
import co.com.pragma.usecase.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is a sample REST controller
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final UserUseCase userUseCase;
    private final UserDTOMapper userMapper;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO createUserDTO) {
        userUseCase.saveUser(userMapper.toModel(createUserDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userMapper.toResponseList(userUseCase.getAllUsers()));
    }

    @GetMapping("/{idNumber}")
    public ResponseEntity<UserDTO> getByIdNumber(@PathVariable(name = "idNumber") Long idNumber) {
        return ResponseEntity.ok(userMapper.toResponse(userUseCase.getUserByIdNumber(idNumber)));
    }

    @PutMapping
    public ResponseEntity<UserDTO> editUser(@RequestBody EditUserDTO editUserDTO) {
        return ResponseEntity.ok(userMapper.toResponse(userUseCase.editUser(userMapper.toModel(editUserDTO))));
    }

    @DeleteMapping("/{idNumber}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "idNumber") Long idNumber) {
        userUseCase.deleteUser(idNumber);
        return ResponseEntity.noContent().build();
    }
}
