<%-- 
<<<<<<< Updated upstream
    Document   : ListDept
    Created on : 30 mars 2023, 17:36:39
    Author     : antonio
--%>
=======
    Document   : ListEmp
    Created on : 5 avr. 2023, 08:55:26
    Author     : antonio
--%>
<%@page import="model.Dept"%>
<%@page import="java.util.Vector"%>
<% Vector<Dept> vect = (Vector<Dept>) (request.getAttribute("list"));%>
>>>>>>> Stashed changes

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<<<<<<< Updated upstream
        <h1>Hello World!</h1>
=======
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
>>>>>>> Stashed changes
    </body>
</html>
