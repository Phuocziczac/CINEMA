package com.poly.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.poly.model.Account;
import com.poly.model.Room;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcelExportService {
	public void exportAccountsToExcel(HttpServletResponse response, List<Account> accounts, List<Integer> roleIds) throws IOException {
	    // Lọc các tài khoản theo danh sách roleIds
	    List<Account> filteredAccounts = accounts.stream()
	                                             .filter(account -> roleIds.contains(account.getRole().getId()))
	                                             .collect(Collectors.toList());

	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Accounts");

	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("Username");
	    headerRow.createCell(1).setCellValue("Full Name");
	    headerRow.createCell(2).setCellValue("Role");

	    int rowIdx = 1;
	    for (Account account : filteredAccounts) {
	        Row row = sheet.createRow(rowIdx++);
	        row.createCell(0).setCellValue(account.getUsername());
	        row.createCell(1).setCellValue(account.getFullname());
	        row.createCell(2).setCellValue(account.getRole().getName());
	    }

	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition", "attachment; filename=accounts.xlsx");

	    ServletOutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    workbook.close();
	    outputStream.close();
	}


  //Account
    public void exportAccountsToExcelRoom(HttpServletResponse response, List<Room> rooms) throws IOException {
        // Tạo workbook và sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rooms");

        // Tạo dòng tiêu đề
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Decription");
        headerRow.createCell(2).setCellValue("Name");

        // Ghi dữ liệu vào các dòng
        int rowIdx = 1;
        for (Room room  : rooms) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(room.getId());
            row.createCell(1).setCellValue(room.getDescription());
            row.createCell(2).setCellValue(room.getName());
        }

        // Thiết lập header và kiểu file Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=accounts.xlsx");

        // Ghi workbook ra response output stream
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
