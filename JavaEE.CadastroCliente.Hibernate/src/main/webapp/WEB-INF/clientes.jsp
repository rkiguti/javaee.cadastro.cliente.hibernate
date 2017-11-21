<%-- 
    Document   : clientes
    Created on : 04/11/2017, 10:20:58
    Author     : kiguti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body class="container">
        <h1>Clientes</h1>
        <div style="margin-bottom: 10px">
            <a href="${pageContext.request.contextPath}/novo" class="btn btn-primary">Novo</a>
        </div>
        <table class="table">
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.telefone}</td>
                    <td style="width: 100px">
                        <a href="${pageContext.request.contextPath}/alterar?id=${cliente.id}" class="btn btn-primary">Alterar</a>
                    </td>
                    <td style="width: 100px">
                        <form action="${pageContext.request.contextPath}/excluir" method="POST">
                            <input type="hidden" name="id" value="${cliente.id}">
                            <input type="submit" value="Excluir" class="btn btn-danger">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
