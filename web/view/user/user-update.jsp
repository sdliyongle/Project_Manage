<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>编辑用户</title>

  <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/extend/dtree.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/extend/font/dtreefont.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/extend/formSelects-v4.css">


</head>


<body>
<div class="yadmin-body animated fadeIn">
  <form action="" method="post" class="layui-form layui-form-pane">
    <input name="id" type="hidden" value="${user.id}"/>
    <div class="layui-form-item">
      <label for="userName" class="layui-form-label">
        用户名
      </label>
      <div class="layui-input-block">
        <input type="text" id="userName" name="userName" value="${user.userName}"
               lay-verify="required" lay-vertype="tips"
               autocomplete="off" class="layui-input">
      </div>
    </div>
    <!-- 编辑时不显示密码框 -->
    <div class="layui-form-item">
      <label for="password" class="layui-form-label">
        用户密码
      </label>
      <div class="layui-input-block">
        <input type="text" id="password" name="password" value="${user.password}"
               lay-verify="required" lay-vertype="tips"
               autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label for="trueName" class="layui-form-label">
        真实姓名
      </label>
      <div class="layui-input-block">
        <input type="text" id="trueName" name="trueName" value="${user.trueName}"
               autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label for="bz" class="layui-form-label">
        备注名
      </label>
      <div class="layui-input-block">
        <input type="text" id="bz" name="bz" value="${user.bz}"
               autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label for="remarks" class="layui-form-label">
        备注
      </label>
      <div class="layui-input-block">
        <input type="text" id="remarks" name="remarks" value="${user.remarks}"
               autocomplete="off" class="layui-input">
      </div>
    </div>

    <div class="layui-form-item">
      <label class="layui-form-label">
        角色
      </label>
      <div class="layui-input-block">
        <select name="role" xm-select="role-select"
                lay-verify="required"
                lay-vertype="tips">
          <option value="">请选择角色</option>
          <option value="1">项目经理</option>
          <option value="2">项目成员</option>
        </select>
      </div>
    </div>

    <div class="layui-form-item">
      <div class="layui-input-block" style="margin-left:0;text-align:center;">
        <input type="hidden" id="deptId" name="deptId" value="">
        <input type="hidden" id="userId" name="userId" value="">
        <button class="layui-btn layui-btn-normal btn-w100" lay-submit="" lay-filter="update">确认</button>
      </div>
    </div>
  </form>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>

<script src="${pageContext.request.contextPath}/js/user/update.js"></script>

</body>
</html>