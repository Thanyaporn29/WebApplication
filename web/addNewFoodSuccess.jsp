<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>แสดงข้อมูลเครื่องดื่ม</title>
</head>
<body>
    <% 
        Food food = (Food) session.getAttribute("food");
        if (food != null) {
    %>
    <p>เครื่องดื่มที่เพิ่มได้แล้ว</p>
    <p>ชื่อ: <%= food.getName() %><br/>
    ระดับความหวาน: <%= food.getLevelSweet() %><br/> <!-- ตรวจสอบชื่อเมธอด -->
    ขนาด: <%= food.getSize() %><br/>
    ราคา: <%= food.getPrice() %></p>
    <a href="updateFood.jsp">แก้ไขข้อมูลเครื่องดื่ม</a>
    <% 
        } else { 
    %>
    <p>No food found in session.</p>
    <% 
        } 
    %>
</body>
</html>
