<%@ page import="org.example.demo.Entity.Person" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Thiba
  Date: 10/01/2025
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste de person</title>
</head>
<body>

<h1>Liste des personnes</h1>
<table>
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Âge</th>
    </tr>
    <%
        List<Person> persons = (List<Person>) request.getAttribute("persons");
        if (persons != null) {
            for (Person person : persons) {
    %>
    <tr>
        <td><%= person.getPrenom() %></td>
        <td><%= person.getNom() %></td>
        <td><%= person.getAge() %></td>
    </tr>
    <%
            }
        }
    %>
</table>


</body>
</html>
