package com.photon.consumers;

import com.photon.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "user-service")
public interface UserConsumer {

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable int id);
}
