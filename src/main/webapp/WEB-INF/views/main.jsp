<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
    <title>Project</title>
</head>
<body>
<h1 style="text-align: center">Good Project </h1>
<div style="margin: 20px">
    <form action="${pageContext.request.contextPath}/" method="post">
        <input type="hidden" name="command" value="create">
        <label>
            <input type="text" placeholder="Name" name="name" required/>
        </label>
        <label>
            <input type="text" placeholder="Surname" name="surname" required/>
        </label>
        <button>Create</button>
    </form>
</div>
<hr>
<div style="margin: 20px">
    <c:forEach items="${requestScope.users}" var="user">
        <form action="${pageContext.request.contextPath}/" method="post">
            <input type="hidden" name="command" value="delete">
            <input type="hidden" name="id" value="${user.id}">
            <h4>${user.name} ${user.surname}
                <button>Delete</button>
            </h4>
        </form>
    </c:forEach>
</div>
</body>
</html>
