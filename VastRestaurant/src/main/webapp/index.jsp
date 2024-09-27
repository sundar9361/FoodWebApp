<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Food Order App</title>
    <link href="vast.css" rel="stylesheet"/>
</head>
<body>

    <header style="position: fixed; top: 0px;">
         <div class="topbar">
            <div class="container"></div>
         </div>
         <div class="bottombar">
             <div class="logo"><h1>Vast Hotel</h1></div>
             <div class="menu-sec">
               <nav>
                    <ul>  
                        <li>Menu</li>
                        <li>Log In</li>
                        <li>Sign Up</li>
                        <li><button>ORDER NOW</button></li>
                    </ul>
               </nav>
            </div>
         </div>
    </header>

    <section class="food-selection">
        <table>
            <tr>
                
                <td>
                    <div class="veg-section">
                        <img src="Images/veg.jpg" alt="Veg Food" class="food-image">
                        <button  class="button-veg" onclick="window.location.href='veg-food.html'">View Veg Food</button>
                    </div>
                </td>

                
                <td>
                    <div class="non-veg-section">
                        <img src="Images/nonveg.jpg" alt="Non-Veg Food" class="food-image">
                        <button class="button-nonveg" onclick="window.location.href='non-veg-food.html'">View Non-Veg Food</button>
                    </div>
                </td>
            </tr>
        </table>
    </section>
 
</body>
</html>