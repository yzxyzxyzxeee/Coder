<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>新增数据</title>
  <style>
    body {
      background-color: #F5F5F5;
      font-family: Arial, sans-serif;
      font-size: 14px;
      margin: 0;
      padding: 0;
    }

    h1 {
      margin-top: 20px;
      margin-bottom: 20px;
      font-size: 24px;
      text-align: center;
    }

    form {
      margin-top: 20px;
      margin-bottom: 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    label {
      display: flex;
      flex-direction: row;
      align-items: center;
      margin-bottom: 10px;
    }

    label span {
      min-width: 80px;
    }

    input[type="text"] {
      padding: 8px;
      border-radius: 4px;
      border: 1px solid #ddd;
      flex: 1;
    }

    input[type="submit"] {
      margin-top: 20px;
      padding: 8px 20px;
      border-radius: 4px;
      border: none;
      background-color: cornflowerblue;
      color: white;
      font-weight: bold;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #2455c3;
    }
  </style>
</head>
<body>
<h1>新增数据项</h1>
<hr>
<form action="add" method="post">
  <label>
    <span>id：</span>
    <input type="text" name="id" value="">
  </label>
  <label>
    <span>name：</span>
    <input type="text" name="name" value="">
  </label>
  <label>
    <span>age：</span>
    <input type="text" name="age" value="">
  </label>
  <label>
    <span>sex：</span>
    <input type="text" name="sex" value="">
  </label>

  <input type="submit" value="保存">
</form>
</body>
</html>
