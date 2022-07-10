package com.cd.moyu.paper.manager;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonTest {
    @Test
    void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String[] passwords = new String[]{"333","444","555","666","777","888","999","101010","111111","121212"};
        for (String password : passwords) {
            System.out.println(encoder.encode(password));
        }
    }
}
