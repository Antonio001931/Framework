<%-- 
    Document   : ListEmp
    Created on : 5 avr. 2023, 08:55:26
    Author     : antonio
--%>
<%@page import="model.Emp"%>
<%@page import="java.util.Vector"%>

<% Vector<Emp> vect = (Vector<Emp>) (request.getAttribute("empl"));%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1> Liste Emp</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                 <th>Nom</th>
                   <th>Date d'embauche</th>
                
            </tr>
        <% for (int i = 0; i < vect.size(); i++) { %>
        <tr>
                
            <td><% out.print(vect.elementAt(i).getId());%></td>
            <td><% out.print(vect.elementAt(i).getNom());%></td>                      
            <td><% out.print(vect.elementAt(i).getDate());%></td>
        </tr>
                 
            
            <% }%>
        </table>
    </body>
</html>
