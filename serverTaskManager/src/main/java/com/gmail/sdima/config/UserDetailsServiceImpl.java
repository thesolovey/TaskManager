package com.gmail.sdima.config;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        final User user = userService.getUserByName(login);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(login);
            builder.password(user.getPassword());
//            builder.disabled(!user.isEnabled());
//            String[] authorities = user.getAuthorities()
//                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);
//            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found!!!");
        }
        return builder.build();
    }
}
