package com.whalex.whaleauth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class WhaleAuthApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("app")+"   "+"-------------");
        System.out.println(passwordEncoder.matches("app","$2a$10$oNHRKmhfN0VG4ndFOSmZOOUFY8oKrdxkdz4i0AGh8Tx/hcGCBHz8K"));
    }

}
