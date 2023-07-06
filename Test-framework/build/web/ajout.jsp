<%-- 
    Document   : ajout.jsp
    Created on : 28 avr. 2023, 09:59:39
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <h1>Ajouter</h1>
       <form action="save-emp" method="post">
             <label for="num">Id:</label>
            <input type="number" name="id" id="id"><br><br>
            <label for="num">Nom :</label>
            <input type="text" name="nom" id="nom"><br><br>
             <label for="num">Daty:</label>
            <input type="date" name="date" id="date"><br><br>
            <input type="submit" value="enregistrer">
           
       </form>
    </body>
</html>
