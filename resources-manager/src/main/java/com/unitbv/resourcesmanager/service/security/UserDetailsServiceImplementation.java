package com.unitbv.resourcesmanager.service.security;

import com.unitbv.resourcesmanager.model.User;
import com.unitbv.resourcesmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return AuthorityUtils.createAuthorityList(user.getType().toString());
    }
}
