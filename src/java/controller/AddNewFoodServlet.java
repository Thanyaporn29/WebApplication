package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.Food;

@WebServlet(name = "AddNewFoodServlet", urlPatterns = {"/AddNewFoodServlet"})
public class AddNewFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // รับค่าจากผู้ใช้งาน
        String foodName = request.getParameter("foodName");
        String levelSweet = request.getParameter("levelSweet"); // ตรวจสอบการรับค่าจากฟอร์ม
        String size = request.getParameter("size");
        int price = Integer.parseInt(request.getParameter("price"));

        // ตรวจสอบค่าที่ได้รับ
        System.out.println("Food Name: " + foodName);
        System.out.println("Level Sweet: " + levelSweet);
        System.out.println("Size: " + size);
        System.out.println("Price: " + price);

        // สร้าง instance of Food
        Food food = new Food();
        food.setName(foodName);
        food.setLevelSweet(levelSweet); // ตั้งค่าถูกต้อง
        food.setSize(size);
        food.setPrice(price);

        // insert into MySQL: table food
        DBConnection dbConnection = new DBConnection();
        if (!dbConnection.insertNewFood(food)) {
            System.out.println(">>> AddNewFoodMySQL ERROR");
        }

        // เก็บ food ไว้ที่ session
        HttpSession session = request.getSession();
        session.setAttribute("food", food);

        // forward ไป addNewFoodSuccess.jsp
        request.getRequestDispatcher("/addNewFoodSuccess.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
