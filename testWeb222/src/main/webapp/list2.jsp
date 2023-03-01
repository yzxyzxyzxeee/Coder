<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理系统</title>

</head>
<style>
    body {
        background-color: #F5F5F5;
        font-family: Arial, sans-serif;
        font-size: 14px;
    }

    table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 20px;
        margin-bottom: 20px;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: cornflowerblue;
        color: white;
    }

    button {
        font-size: 15px;
        margin-left: 10px;
        margin-right: 10px;
        background-color: cornflowerblue;
        border: 0;
    }
</style>

<script>
    function editUser(id) {
        window.location.href = "edit.jsp?id=" + id;
    }

    function deleteUser(id) {
        window.location.href = "delete.jsp?id=" + id;
    }
</script>
<body>
<div class="container">
    <h1>查询结果如下：</h1>
    <button onclick="location.href='add.jsp'">增加</button>
<%--    <button onclick="location.href='search.jsp'">查询</button>--%>
    <br>
    <br>
    <br>
    <form action="./selectById" method="post">
        <input type="text" name="id" placeholder="根据ID查询"
               autocomplete="off">
        <button>查询</button>
    </form>
    <br>
    <form action="./selectByName" method="post">
        <input type="text" name="name" placeholder="根据Name查询"
               autocomplete="off">
        <button>查询</button>
    </form>
    <br>
    <form action="./selectByAge" method="post">
        <input type="text" name="age" placeholder="根据age查询"
               autocomplete="off">
        <button>查询</button>
    </form>
    <br>
    <form action="./selectBySex" method="post">
        <input type="text" name="sex" placeholder="根据Sex查询"
               autocomplete="off">
        <button>查询</button>
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>操作</th>
        </tr>

        <%@ page import="com.dao.UserDao" %>
        <%@ page import="com.imp.UserImp" %>
        <%@ page import="com.model.User" %>
        <%@ page import="java.util.List" %>
        <%@ page import="java.util.Objects" %>
        <%@ page import="java.util.ArrayList" %>
        <% UserImp userImp = new UserImp();
            Object obj = request.getAttribute("factor");

            List<User> userList = new ArrayList<>();
            if (obj instanceof ArrayList<?>) {
                for (Object o : (List<?>) obj) {
                    userList.add(User.class.cast(o));
                }
            }
            //List<User> userList = userImp.selectUserById(Integer.valueOf(id1));
            for (User user : userList) { %>
        <tr>
            <td><%= user.getId() %>
            </td>
            <td><%= user.getName() %>
            </td>
            <td><%= user.getAge() %>
            </td>
            <td><%= user.getSex() %>
            </td>
            <td>
                <%--                <a title="编辑" href="Delete?id=${item.id }">delete</a>--%>
                <button onclick="editUser(<%= user.getId() %>)">编辑</button>
                <%--                <button onclick="deleteUser(<%= user.getId() %>)">删除</button>--%>
                <form method="post" action="delete">
                    <input type="hidden" name="id" value="<%= user.getId() %>"/>
                    <input type="submit" value="删除"/>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
