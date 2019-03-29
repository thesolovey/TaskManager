package com.gmail.sdima.config;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.entity.UserRole;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        final User user = userService.getUserByLogin(login);

        Set<SimpleGrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRole.USER.name()));

        UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(login);
            builder.password(user.getPassword());
//            builder.disabled(!user.isEnabled());
//            String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);
//            builder.authorities(authorities);
            builder.authorities(roles);
        } else {
            throw new UsernameNotFoundException("User not found!!!");
        }
        return builder.build();
    }
}
