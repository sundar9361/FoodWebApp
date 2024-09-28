<%@page import="com.vast.vo.Food"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Veg Food Menu</title>
    <link href="vast.css" rel="stylesheet"/>
</head>
<body>
     <article>
    <h2 style="text-align: center; margin-top: 100px;">Veg Foods Menu</h2>
    <table border="1" width="80%" align="center" cellpadding="10">
        
            <tr>
                <th>Food ID</th>
                <th>Food Name</th>
                <th>Price</th>
                <th>Rating</th>
            </tr>
            <%
            Set<Food> set =(Set<Food>)request.getAttribute("vegfood");
			
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
