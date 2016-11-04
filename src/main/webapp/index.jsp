<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/4
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="js/vue.js"></script>
</head>
<body>
<div id="app">
    {{n_name}}
</div>
</body>
</html>
<script>
    new Vue({
        el: '#app',
        data: {
            n_name: 'Hello Vue.js!'
        }
    })
</script>
