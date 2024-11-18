package com.poly.restcontroller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poly.model.Account;
import com.poly.model.Role;
import com.poly.service.AccountService;
import com.poly.service.ExcelExportService;
import com.poly.service.RoleService;

import jakarta.servlet.http.HttpServletResponse;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/account")
public class AccountRestController {
	@Autowired
	AccountService service;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
    private ExcelExportService excelExportService;
	

	@GetMapping()
	public List<Account> getAccount() {
       return    service.findAll();
	}
	@GetMapping("/list")
	public ResponseEntity<Page<Account>> getAccountsByRoles(
	        @RequestParam List<Integer> roleIds,
	        @RequestParam int page,
	        @RequestParam int size) {
	    if (page < 0 || size <= 0) {
	        return ResponseEntity.badRequest().body(null);
	    }
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Account> accountPage = service.findByRoleIdIn(roleIds, pageable);
	    
	    return ResponseEntity.ok(accountPage);
	}

	 @GetMapping("{id}")
	 public Optional<Account>  getOne(@PathVariable("id") int id) {
		 
	     return service.findById(id);
	 }
	 @PutMapping("{id}")
	 public Account  Save(@PathVariable("id") int id,@RequestBody Account account) {
		 
	     return service.save(account);
	 }
	 @PostMapping()
	 public Account Create(@RequestBody Account account) {
		 
	     return service.save(account);
	 }
	 @GetMapping("/role")
		public List<Role> getRole() {
	       return    roleService.findAll();
		}
	 
	 @DeleteMapping("{id}")
	 public void Delete(@PathVariable("id") int id) {
		 
		  service.deleteById(id);
	 }
	 @GetMapping("search")
	 public List<Account> searchAccounts(@RequestParam String keyword) {
	     System.out.println("Keyword received: " + keyword); // kiểm tra giá trị keyword
	     return service.searchByKeyword(keyword.trim());
	 }
	  

	 @GetMapping("/excel")
	 public void exportAccountsToExcel(HttpServletResponse response) throws IOException {
	     List<Account> accounts = service.findAll(); // Lấy danh sách Account từ database
	     List<Integer> roleIds = Arrays.asList(1, 2); // Danh sách roleId cần xuất
	     excelExportService.exportAccountsToExcel(response, accounts, roleIds);
	 }
	 @GetMapping("/searchCustomer")
	 public List<Account> searchCustomer(@RequestParam String keyword) {
	     System.out.println("Keyword received: " + keyword); // kiểm tra giá trị keyword
	     return service.searchByKeywordCustomer(keyword.trim());
	 }
	 @GetMapping("/excelCustomer")
	 public void exportAccountsToExcelCustomer(HttpServletResponse response) throws IOException {
	     List<Account> accounts = service.findAll(); // Lấy danh sách Account từ database
	     List<Integer> roleIds = Arrays.asList(3); // Danh sách roleId cần xuất
	     excelExportService.exportAccountsToExcel(response, accounts, roleIds);
	 }

	
}
