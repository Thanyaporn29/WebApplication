<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Drink</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Update Drink</h1>
    <%
        Food food = (Food) session.getAttribute("food");
        if (food != null) {
    %>
    <form action="AddNewFoodServlet" method="post">
        <label for="DrinkName">Drink Name:</label>
        <input type="text" id="foodName" name="foodName" value="<%= food.getName() %>" required><br><br>

        <div class="level-group">
           <label>LevelSweet:</label><br>
            <input type="radio" id="NotSweet" name="level" value="Not Sweet" <%= "Not Sweet".equals(food.getLevelSweet()) ? "checked" : "" %>> Not Sweet<br>
            <input type="radio" id="Sweet50" name="level" value="Sweet50" <%= "Sweet50".equals(food.getLevelSweet()) ? "checked" : "" %>> Sweet50<br>
            <input type="radio" id="Sweet100" name="level" value="Sweet100" <%= "Sweet100".equals(food.getLevelSweet()) ? "checked" : "" %>> Sweet100<br>
        </div>
        
        <label for="size">Size:</label>
        <select id="size" name="size" required>
            <option value="Small(S)" <%= "Small(S)".equals(food.getSize()) ? "selected" : "" %>>Small(S)</option>
            <option value="Medium(M)" <%= "Medium(M)".equals(food.getSize()) ? "selected" : "" %>>Medium(M)</option>
            <option value="Large(L)" <%= "Large(L)".equals(food.getSize()) ? "selected" : "" %>>Large(L)</option>
        </select><br><br>

        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="<%= food.getPrice() %>" required><br><br>

        <button type="submit">Update Drink</button>
    </form>
    <%
        session.removeAttribute("food");
        } else {
    %>
    <p>No drink found in session.</p>
    <%
        }
    %>
</body>
</html>
