package com.hms.security.service;
import com.hms.entity.AdminEntity;
import com.hms.entity.CommandeEntity;
import com.hms.entity.UserEntity;
import com.hms.repositories.AdminRepository;
import com.hms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminDetailsServiceImpl   implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AdminEntity admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("admin Not Found with email: " + email));

        return UserDetailsImpl.build(admin);
    }
}
