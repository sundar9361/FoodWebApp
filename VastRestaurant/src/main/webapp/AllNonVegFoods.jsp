<%@page import="com.vast.vo.Food"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Non-Veg Food Menu</title>
    <link href="vast.css" rel="stylesheet"/>
</head>
<body>
    <article class="article">
        <h2>Non-Veg Foods Menu</h2>
        <table class="table">
            <tr>
                <th>Food ID</th>
                <th>Food Name</th>
                <th>Price</th>
                <th>Rating</th>
            </tr>
            <%
            Set<Food> set = (Set<Food>)request.getAttribute("nonvegfood"); 
            if (null != set) {
                for (Food food : set) {
                    out.println("<tr>");
                    out.println("<td>" + food.getFoodId() + "</td>");
                    out.println("<td>" + food.getFoodName() + "</td>");
                    out.println("<td>" + food.getFoodPrice() + "</td>");
                    out.println("<td>" + food.getFoodRating() + "</td>");
                    out.println("</tr>");
                }
            }
            %>
        </table>
    </article>
</body>
</html>
