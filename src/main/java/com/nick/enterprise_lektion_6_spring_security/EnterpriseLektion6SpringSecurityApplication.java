package com.nick.enterprise_lektion_6_spring_security;

import com.nick.enterprise_lektion_6_spring_security.authorities.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseLektion6SpringSecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(EnterpriseLektion6SpringSecurityApplication.class, args);

        System.out.println("--- ADMIN ---");
        System.out.println(UserRole.ADMIN.getPermissions());
        System.out.println("--- USER ---");
        System.out.println(UserRole.USER.getPermissions());
        System.out.println("--- GUEST ---");
        System.out.println(UserRole.GUEST.getPermissions());

        System.out.println("--- GET AUTHORITIES ---");
        System.out.println(UserRole.ADMIN.getAuthorities());

    }

}
