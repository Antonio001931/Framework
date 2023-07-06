<%-- 
    Document   : ListEmp
    Created on : 5 avr. 2023, 08:55:26
    Author     : antonio
--%>
<%@page import="model.Dept"%>
<%@page import="java.util.Vector"%>
<% Vector<Dept> vect = (Vector<Dept>) (request.getAttribute("list"));%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1> Liste Dept</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                 <th>Nom</th>

                
            </tr>
        <% for (int i = 0; i < vect.size(); i++) { %>
        <tr>
                
            <td><% out.print(vect.elementAt(i).getId());%></td>
            <td><% out.print(vect.elementAt(i).getNom());%></td>
          
        </tr>
                 
            
            <% }%>
        </table>
    </body>
</html>
