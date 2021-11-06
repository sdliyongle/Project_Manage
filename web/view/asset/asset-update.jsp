<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑资产</title>

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
        <div class="layui-form-item">
            <label for="asset_id" class="layui-form-label">
                编号
            </label>
            <div class="layui-input-block">
                <input type="text" id="asset_id" name="asset_id" value="${asset.assetId}"
                       lay-verify="required" lay-vertype="tips"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="asset_name" class="layui-form-label">
                资产名称
            </label>
            <div class="layui-input-block">
                <input type="text" id="asset_name" name="asset_name" value="${asset.assetName}"
                       lay-verify="required" lay-vertype="tips"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="asset_type" class="layui-form-label">
                资产类型
            </label>
            <div class="layui-input-block">
                <input type="text" id="asset_type" name="asset_type" value="${asset.assetType}"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="asset_status" class="layui-form-label">
                资产状态
            </label>
            <div class="layui-input-block">
                <input type="text" id="asset_status" name="asset_status" value="${asset.assetStatus}"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="asset_value" class="layui-form-label">
                资产价值
            </label>
            <div class="layui-input-block">
                <input type="text" id="asset_value" name="asset_value" value="${asset.assetValue}"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="asset_rental_status" class="layui-form-label">
                是否外借
            </label>
            <div class="layui-input-block">
                <input type="text" id="asset_rental_status" name="asset_rental_status" value="${asset.assetRentalStatus}"
                       autocomplete="off" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block" style="margin-left:0;text-align:center;">
                <input type="hidden" id="deptId" name="deptId" value="">
                <input type="hidden" id="assetId" name="assetId" value="">
                <button class="layui-btn layui-btn-normal btn-w100" lay-submit="" lay-filter="update">确认</button>
            </div>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>

<script src="${pageContext.request.contextPath}/js/asset/update.js"></script>

</body>
</html>