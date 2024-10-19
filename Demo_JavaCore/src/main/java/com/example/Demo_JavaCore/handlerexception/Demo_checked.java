package com.example.Demo_JavaCore.handlerexception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo_checked {
    // Phương thức ném ra checked exception: throws
    public static Date displayDate1(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Ngày hợp lệ: "+formatter.parse(dateString));
        return formatter.parse(dateString);
    }

    // Phương thức xử lý checked exception: try-catch
    public static void displayDate2(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateString);
            System.out.println("Ngày hợp lệ: " + date);
        } catch (ParseException e) {
            System.out.println("Lỗi: Định dạng ngày không hợp lệ - " + e.getMessage());
        }
    }

    public static void main(String[] args) throws ParseException {
        try {
            displayDate1("2024-10-19");  // Hợp lệ
            displayDate2("19/10/2024");   // Không hợp lệ
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
