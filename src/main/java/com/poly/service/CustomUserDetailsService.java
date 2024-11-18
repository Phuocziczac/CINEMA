package com.poly.service;

import com.poly.model.Account;
import com.poly.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm Account trong cơ sở dữ liệu
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Chuyển đổi Account thành UserDetails
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword()) // Mật khẩu cần mã hóa trong quá trình lưu
                .roles(account.getRole().getName()) // Giả sử Role có thuộc tính `name`
                .build();
    }
}
