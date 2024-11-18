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

import com.poly.model.Service;

import com.poly.service.ExcelExportService;
import com.poly.service.ServiceService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/services")
public class ServicesRestController {

    @Autowired
    ServiceService serviceService;

    @GetMapping()
    public List<Service> getServices() {
        return serviceService.findAll();

    }

    @Autowired
    private ExcelExportService excelExportService;

    // @GetMapping("/{id}")
    // public ResponseEntity<Service> getServiceById(@PathVariable Integer id) {
    // Optional<Service> service = serviceService.findById(id);
    // return service.map(s -> ResponseEntity.ok(new Service(s)))
    // .orElse(ResponseEntity.notFound().build());
    // }

    @GetMapping("/list")
    public ResponseEntity<Page<Service>> getServicesByRoles(
            @RequestParam List<Integer> roleIds,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        if (page < 0 || size <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Service> servicePage = serviceService.findAll(pageable);

        return ResponseEntity.ok(servicePage);
    }

    @GetMapping("{id}")
    public Optional<Service> getOne(@PathVariable("id") int id) {
        return serviceService.findById(id);
    }

    @PutMapping("{id}")
    public Service save(@PathVariable("id") int id, @RequestBody Service service) {
        return serviceService.save(service);
    }

    @PostMapping()
    public Service Create(@RequestBody Service service) {
        return serviceService.save(service);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        serviceService.deleteById(id);
    }

//    @GetMapping("/excel")
//    public void exportServicesToExcel(HttpServletResponse response) throws IOException {
//        List<Service> services = serviceService.findAll(); // Lấy danh sách Account từ database
//
//        // List<Integer> roleIds = Arrays.asList(1, 2); // Danh sách roleId cần xuất
//
//        excelExportService.exportServicesToExcel(response, services);
//    }
//
    @GetMapping("/search")
    public List<Service> searchServices(@RequestParam String keyword) {
        System.out.println("Keyword received: " + keyword); // Check keyword value
        return serviceService.searchByKeyword(keyword.trim());
    }

    @GetMapping("/searchCustomer") // Assuming you want to search for customer-specific services
    public List<Service> searchCustomerServices(@RequestParam String keyword) {
        System.out.println("Keyword received: " + keyword); // Check keyword value
        return serviceService.searchByKeywordCustomer(keyword.trim()); // Call appropriate search method
    }
}