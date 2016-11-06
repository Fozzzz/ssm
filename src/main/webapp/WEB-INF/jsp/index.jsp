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
    <script type="application/javascript" src="../../js/vue.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
</head>
<body>
<div id="app">
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
                                &nbsp;<a class="btn btn-default" href="#add" data-toggle="modal">添加</a>
                            </div>
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <form action="vague" method="post">
                                        <input type="text" class="form-control" name="vague" placeholder="关键字">
                                        <select name="type">
                                            <option value="标题">标题</option>
                                            <option value="内容">内容</option>
                                            <option value="类型">类型</option>
                                        </select>
                                         <button class="btn btn-default" type="submit">查询</button>
                                    </form>
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
                            <th>
                                <button href="#update" class="btn btn-info" data-toggle="modal"
                                        v-on:click="update('${temp.n_id}','${temp.n_name}','${temp.n_content}','${temp.n_type}')">
                                    修改
                                </button>
                                &nbsp;<a
                                    class="btn btn-danger"
                                    href="deleteById?n_id=${temp.n_id}&currentPage=${page.currentPage}">删除</a></th>
                        </tr>
                    </c:forEach>

                    </tbody>

                </table>
                <div>
                    <ul class="pagination">
                        <%--上一页--%>
                        <c:if test="${page.firstPage}">
                            <li class="disabled"><a href="getLimit?currentPage=${page.frontPage}">&laquo;</a></li>
                        </c:if>
                        <c:if test="${!page.firstPage}">
                            <li><a href="getLimit?currentPage=${page.frontPage}">&laquo;</a></li>
                        </c:if>

                        <c:forEach var="i" begin="1" end="${page.totalPage}">
                            <c:if test="${page.currentPage==i}">
                                <li class="active"><a href="#">${i}</a></li>
                            </c:if>
                            <c:if test="${page.currentPage!=i}">
                                <li><a href="getLimit?currentPage=${i}">${i}</a></li>
                            </c:if>
                        </c:forEach>

                        <%--下一页--%>
                        <c:if test="${page.lastPage}">
                            <li class="disabled"><a href="getLimit?currentPage=${page.nextPage}">&raquo;</a></li>
                        </c:if>
                        <c:if test="${!page.lastPage}">
                            <li><a href="getLimit?currentPage=${page.nextPage}">&raquo;</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <%--添加新闻面板--%>
    <div class="modal fade" id="add" role="dialog" aria-hidden="true"
         aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" aria-hidden="true" type="button"
                            data-dismiss="modal">×
                    </button>
                    <h4 class="modal-title">
                        添加新闻
                    </h4>
                </div>
                <form role="form" action="add" method="post">
                    <input type="hidden" name="currentPage" value="${page.totalPage}">
                    <div class="modal-body">
                        <div class="form-group">
                            <label>标题</label>
                            <input type="text" class="form-control" name="n_name"/>
                        </div>
                        <div class="form-group">
                            <label>内容</label>
                            <textarea class="form-control" rows="3" name="n_content"></textarea>
                        </div>
                        <div class="form-group">
                            <label>类型</label>
                            <select class="form-control" name="n_type">
                                <option value="景区活动">景区活动</option>
                                <option value="景区公告">景区公告</option>
                                <option value="景区新闻">景区新闻</option>
                                <option value="景区美食">景区美食</option>
                                <option value="景区酒店">景区酒店</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default" type="button" data-dismiss="modal">
                            关闭
                        </button>
                        <button class="btn btn-primary" type="submit">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%--修改新闻面板--%>
    <div class="modal fade" id="update" role="dialog" aria-hidden="true"
         aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" aria-hidden="true" type="button"
                            data-dismiss="modal">×
                    </button>
                    <h4 class="modal-title">
                        修改新闻
                    </h4>
                </div>
                <form role="form" action="update" method="post">
                    <div class="modal-body">
                        <input type="hidden" name="currentPage" value="${page.currentPage}">
                        <input type="hidden" name="n_id" v-model="n_id">
                        <div class="form-group">
                            <label>标题</label>
                            <input type="text" class="form-control" name="n_name" v-model="n_name"/>
                        </div>
                        <div class="form-group">
                            <label>内容</label>
                            <textarea class="form-control" rows="3" name="n_content" v-model="n_content"></textarea>
                        </div>
                        <div class="form-group">
                            <label>类型</label>
                            <select class="form-control" name="n_type" v-model="n_type">
                                <option value="景区活动">景区活动</option>
                                <option value="景区公告">景区公告</option>
                                <option value="景区新闻">景区新闻</option>
                                <option value="景区美食">景区美食</option>
                                <option value="景区酒店">景区酒店</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default" type="button" data-dismiss="modal">
                            关闭
                        </button>
                        <button class="btn btn-primary" type="submit">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    new Vue({
        el: '#app',
        data: {
            n_id: '',
            n_name: '',
            n_content: '',
            n_type: ''
        },
        methods: {
            update: function (id, name, content, type) {
                this.n_id = id;
                this.n_name = name;
                this.n_content = content;
                this.n_type = type;
            }
        }

    })
</script>