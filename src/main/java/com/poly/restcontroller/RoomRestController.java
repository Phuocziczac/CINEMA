package com.poly.restcontroller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.poly.model.Account;
import com.poly.model.Role;
import com.poly.model.Room;
import com.poly.service.ExcelExportService;
import com.poly.service.RoomService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController()
@RequestMapping("/rest/room")
public class RoomRestController {

	@Autowired
	RoomService roomService;
	@Autowired
	ExcelExportService excelExportService;
	
	
	@GetMapping("")
	public  List<Room> getRoom() {
		// TODO Auto-generated method stub
		return roomService.findAll();

	}
	@GetMapping("/list")
	public ResponseEntity<Page<Room>> getAccountsByRoles(
	        @RequestParam int page,
	        @RequestParam int size) {
	    if (page < 0 || size <= 0) {
	        return ResponseEntity.badRequest().body(null);
	    }
	    
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Room> roomPage = roomService.findAll(pageable);
	    
	    return ResponseEntity.ok(roomPage);
	}


	 @GetMapping("{id}")
	 public Optional<Room>  getOne(@PathVariable("id") int id) {
		 
	     return roomService.findById(id);
	 }
	 @PutMapping("{id}")
	 public Room  Save(@PathVariable("id") int id,@RequestBody Room room) {
		 
	     return roomService.save(room);
	 }
	 @PostMapping()
	 public Room Create(@RequestBody Room room) {
		 
	     return roomService.save(room);
	 }
	
	 
	 @DeleteMapping("{id}")
	 public void Delete(@PathVariable("id") int id) {
		 
		  roomService.deleteById(id);
	 }
	 @GetMapping("search")
	 public List<Room> searchAccounts(@RequestParam String keyword) {
	     System.out.println("Keyword received: " + keyword); // kiểm tra giá trị keyword
	     return roomService.searchByKeyword(keyword.trim());
	 }
	  

	    @GetMapping("/excel")
	    public void exportAccountsToExcel(HttpServletResponse response) throws IOException  {
	        List<Room> rooms = roomService.findAll(); // Lấy danh sách Account từ database
	        excelExportService.exportAccountsToExcelRoom(response, rooms);
	    }
	
}
