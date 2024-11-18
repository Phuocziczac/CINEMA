package com.poly.controller;

import java.io.File;
import java.util.Optional;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.DTO.Account;
import com.poly.model.Role;
import com.poly.service.AccountService;
import com.poly.service.RoleService;
import com.poly.service.SessionService;
import com.poly.service.UploadService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/homeuser")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UploadService service;
    @Autowired
    RoleService roleService;
    @Autowired
    private SessionService sessionService;

    // GET request cho trang đăng ký
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("account", new Account());  // Tạo đối tượng Account mới
        return "user/html/signup";  // Chuyển đến trang signup.html
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
      // Thêm đối tượng Account vào model
        return "user/html/login"; // Trả về trang login
    }


    @Autowired
    private UploadService uploadService;

    @PostMapping("/add")
    public String register(
            @ModelAttribute("account") @Valid Account accountDto,
            BindingResult result,
            @RequestParam("images") MultipartFile imagesFile,
            Model model) {

        // Kiểm tra nếu có lỗi trong form
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng kiểm tra lại thông tin");
            return "user/html/signup";
        }

        // Xử lý ảnh đại diện nếu có
        String imagesPath = null;
        if (!imagesFile.isEmpty()) {
            try {
                // Lưu file ảnh và lấy URL hoặc tên file
                File savedFile = uploadService.save(imagesFile, "imagess");
                imagesPath = "/uploads/images/" + savedFile.getName();  // URL ảnh lưu trữ
            } catch (Exception e) {
                model.addAttribute("message", "Không thể lưu file ảnh: " + e.getMessage());
                return "user/html/signup";
            }
        }

        // Tạo đối tượng Account từ DTO và ánh xạ dữ liệu
        com.poly.model.Account account = new com.poly.model.Account();
        account.setUsername(accountDto.getUsername());
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        account.setEmail(accountDto.getEmail());
        account.setFullname(accountDto.getFullname());
        account.setBirthDay(accountDto.getBirthDay());
        account.setPhone(accountDto.getPhone());
        account.setImages(imagesPath);  // Lưu URL ảnh vào account
        Optional<Role> role = roleService.findById(3) ; // Lấy role từ ID
        account.setRole(role.get());

        // Lưu đối tượng Account vào cơ sở dữ liệu
        accountService.save(account);

        model.addAttribute("message", "Đăng ký thành công");
        return "redirect:/login";
    }



    @PostMapping("/html/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        System.out.println("Login method called with username: " + username);

        Optional<com.poly.model.Account> accountOpt = accountService.findByUsername(username);

        if (accountOpt.isEmpty()) {
            System.out.println("User not found");
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
            return "user/html/login";
        }

        com.poly.model.Account account = accountOpt.get();
        if (!passwordEncoder.matches(password, account.getPassword())) {
            System.out.println("Password does not match");
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
            return "user/html/login";
        }

        System.out.println("Login successful for username: " + username);
        sessionService.set("account", account.getUsername());
        return "redirect:/homeuser";
    }




}
