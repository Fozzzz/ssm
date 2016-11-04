<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/4
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="../../js/jquery.min.js"></script>
    <script type="application/javascript" src="../../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-2">

            </div>
            <div class="col-xs-10">
                <table class="table table-bordered table-striped table-hover">
                    <caption>
                        <div class="row">
                            <div class="col-xs-6">
                                新闻管理
                                &nbsp;<button class="btn btn-default">添加</button>
                            </div>
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="关键字">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">类型
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="#">全部</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li>
                                                <a href="#">编号</a>
                                            </li>
                                            <li>
                                                <a href="#">标题</a>
                                            </li>
                                            <li>
                                                <a href="#">内容</a>
                                            </li>
                                            <li>
                                                <a href="#">类型</a>
                                            </li>
                                        </ul>
                                         <button class="btn btn-default" type="button">查询</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </caption>
                    <thead>
                        <tr>
                            <th>编号</th>
                            <th>标题</th>
                            <th>内容</th>
                            <th>类型</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="temp" items="${page.list}">
                            <tr style="font-size: small">
                                <th>${temp.n_id}</th>
                                <th>${temp.n_name}</th>
                                <th>${temp.n_content}</th>
                                <th>${temp.n_type}</th>
                                <th><a class="btn btn-info" href="">修改</a>&nbsp;<a class="btn btn-danger" href="deleteById?n_id=1">删除</a></th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
