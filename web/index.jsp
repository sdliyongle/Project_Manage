<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理系统</title>
    <link rel="apple-touch-icon" sizes="180x180" href="favicon.ico">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon.ico">
    <!-- layui样式 -->
    <link rel="stylesheet" href="layui/css/layui.css">
    <!-- Y-Admin核心样式 -->
    <link rel="stylesheet" href="css/yadmin.css">
    <!-- 公共样式 -->
    <link rel="stylesheet" href="css/common.css">
    <!-- 图标 -->
    <link rel="stylesheet" href="./static/remixicon/fonts/remixicon.css">
    <!-- 首页样式（只为此页面使用） -->
    <link rel="stylesheet" href="./css/index.css">
</head>

<body class="layui-layout-body">

    <div class="layui-layout layui-layout-admin">

        <div class="layui-header">
            <!-- logo 区域 -->
            <div class="layui-logo">
                <img src="images/security.png" alt="logo" style="margin-left: -5px;" />
                <cite>
                    项目管理系统&emsp;
                </cite>
            </div>

            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item" lay-unselect>
                    <a lay-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right"></i>
                    </a>
                </li>
                <!-- 面包屑 -->
                <span class="layui-breadcrumb layui-anim layui-anim-up">
                    <a><cite>首页</cite></a>
                </span>
            </ul>

            <!-- 头像区域 -->
            <ul class="layui-nav layui-layout-right">

                <li class="layui-nav-item feature-items">
                    <a lay-event="clear" title="清理标签缓存"><i class="ri-brush-3-line"></i></a>
                </li>

                <li class="layui-nav-item feature-items">
                    <a lay-event="tag" title="便签"><i class="ri-git-repository-line"></i></a>
                </li>

                <li class="layui-nav-item feature-items">
                    <a lay-event="todo" title="待处理任务"><i class="ri-calendar-todo-line"></i></a>
                </li>

                <li class="layui-nav-item feature-items">
                    <a id="screenFull" lay-event="screenFull" title="全屏">
                        <i class="ri-fullscreen-line"></i>
                    </a>
                    <a id="screenRestore" lay-event="screenRestore" title="退出全屏" style="display: none;">
                        <i class="ri-fullscreen-exit-line"></i>
                    </a>
                </li>

                <li class="layui-nav-item user-selection">
                    <a>
                        <img src="images/avatar.png" class="layui-nav-img" alt="头像">
                        <cite><%String userName = (String) session.getAttribute("userName"); out.print(userName);%></cite>
                        <span class="layui-nav-more"></span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd lay-unselect>
                            <a lay-event="userInfo">基本资料</a>
                        </dd>
                        <dd lay-unselect>
                            <a lay-event="editPwd">修改密码</a>
                        </dd>
                        <hr>
                        <dd lay-unselect>
                            <a href="./login.html">退出</a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>

        <!-- 左侧导航区域 -->
        <div class="layui-side ">
            <div class="layui-side-scroll">
                <ul class="layui-nav layui-nav-tree" lay-filter="lay-nav" lay-accordion="true">
                    <li class="layui-nav-item">
                        <a lay-url="/view/home/index.html" lay-id="home">
                            <i class="ri-home-8-line"></i>&emsp;<cite>首页</cite>
                        </a>
                    </li>

                    <li class="layui-nav-item">
                        <a lay-id="#" lay-url="#">
                            <i class="ri-shield-keyhole-line"></i>&emsp;<cite>统计报表</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-id="view/user/user-statistics.html" lay-url="view/user/user-statistics.html">
                                    <cite>用户统计</cite>
                                </a>
                            </dd>
                            <dd>
                                <a lay-id="view/project/project-statistics.html" lay-url="view/project/project-statistics.html">
                                    <cite>项目统计</cite>
                                </a>
                            </dd>
                            <dd>
                                <a lay-id="view/document/document-statistics.html" lay-url="view/document/document-statistics.html">
                                    <cite>文档统计</cite>
                                </a>
                            </dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="#" lay-url="#">
                            <i class="ri-shield-keyhole-line"></i>&emsp;<cite>权限管理</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-id="view/user/user-list.html" lay-url="view/user/user-list.html">
                                    <cite>用户管理</cite>
                                </a>
                            </dd>
                            <dd>
                                <a lay-id="view/role/role-list.html" lay-url="view/role/role-list.html">
                                    <cite>角色管理</cite>
                                </a>
                            </dd>
                            <dd>
                                <a lay-id="view/menu/menu-list.html" lay-url="view/menu/menu-list.html">
                                    <cite>菜单权限</cite>
                                </a>
                            </dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/project/project-list.html" lay-url="view/project/project-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>项目管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/document/document-list.html" lay-url="view/document/document-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>文档管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/fund/fund-list.html" lay-url="view/fund/fund-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>资金管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/contract/contract-list.html" lay-url="view/contract/contract-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>合同管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/notice/notice-list.html" lay-url="view/notice/notice-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>通知管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/meeting/meeting-list.html" lay-url="view/meeting/meeting-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>会议管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="view/progress/progress-list.html" lay-url="view/progress/progress-list.html">
                            <i class="ri-menu-line"></i>&emsp;<cite>进度管理</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="#" lay-url="#">
                            <i class="ri-alert-line"></i>&emsp;<cite>异常页</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a lay-id="view/abnormalPage/403.html" lay-url="view/abnormalPage/403.html">
                                    <cite>403</cite>
                                </a>
                            </dd>
                            <dd>
                                <a lay-id="view/abnormalPage/404.html" lay-url="view/abnormalPage/404.html">
                                    <cite>404</cite>
                                </a>
                            </dd>
                            <dd>
                                <a lay-id="view/abnormalPage/500.html" lay-url="view/abnormalPage/500.html">
                                    <cite>500</cite>
                                </a>
                            </dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="https://www.yijianku.com/" lay-url="https://www.yijianku.com/">
                            <i class="ri-menu-line"></i>&emsp;<cite>一级菜单</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a lay-id="https://remixicon.com/" lay-url="https://remixicon.com/">
                            <i class="ri-remixicon-line"></i>&emsp;<cite>图标</cite>
                        </a>
                    </li>
                </ul>

<!--                <div id="message">-->
<!--                    <div class="notification-box" lay-event="notification">-->
<!--                        <span class="notification-count">-->
<!--                            &lt;!&ndash; 此处可写数字 &ndash;&gt;-->
<!--                        </span>-->
<!--                        <div class="notification-bell">-->
<!--                            <span class="bell-top"></span>-->
<!--                            <span class="bell-middle"></span>-->
<!--                            <span class="bell-bottom"></span>-->
<!--                            <span class="bell-rad"></span>-->
<!--                        </div>-->
<!--                    </div>-->
<!--                    <h3>消息通知</h3>-->
<!--                    <p>春已至,花已开,一切美好都将到来!</p>-->
<!--                </div>-->

            </div>
        </div>

        <div class="layui-body">
            <div class="layui-pagetabs">
                <div class="layui-icon admin-tabs-control layui-icon-refresh-3" lay-event="refresh"></div>
                <div class="layui-tab" lay-unauto lay-allowclose="true" lay-filter="lay-tab">
                    <ul class="layui-tab-title">
                        <li lay-id="home" lay-url="/view/home/index.html" class="layui-this">
                            <!-- <i class="ri-home-heart-line ri-xl"></i> -->
                            <i class="ri-home-8-line ri-xl"></i>
                        </li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <iframe src="${pageContext.request.contextPath}/view/home/index2.html" class="layui-iframe"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 底部固定区域 -->
        <div class="layui-footer">
            copyright © 2020 Y-Admin all rights reserved.
            <ul class="tabbar">
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
                        <path fill="none" d="M0 0h24v24H0z" />
                        <path
                            d="M12.414 5H21a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h7.414l2 2zM15 13v-1a3 3 0 0 0-6 0v1H8v4h8v-4h-1zm-2 0h-2v-1a1 1 0 0 1 2 0v1z" />
                    </svg>
                </li>
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
                        <path fill="none" d="M0 0h24v24H0z" />
                        <path
                            d="M21 5a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h7.414l2 2H16v2h2V5h3zm-3 8h-2v2h-2v3h4v-5zm-2-2h-2v2h2v-2zm2-2h-2v2h2V9zm-2-2h-2v2h2V7z" />
                    </svg>
                </li>
                <li>
                    <div class="fileAdd">
                        <ul>
                            <li class="word"></li>
                            <li class="powerpoint"></li>
                            <li class="excel"></li>
                        </ul>
                        <div>
                            <span></span>
                        </div>
                    </div>
                </li>
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
                        <path fill="none" d="M0 0h24v24H0z" />
                        <path
                            d="M12.414 5H21a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h7.414l2 2zM11 13.05a2.5 2.5 0 1 0 2 2.45V11h3V9h-5v4.05z" />
                    </svg>
                </li>
                <li>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
                        <path fill="none" d="M0 0h24v24H0z" />
                        <path
                            d="M12.414 5H21a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h7.414l2 2zM12 13a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5zm-4 5h8a4 4 0 1 0-8 0z" />
                    </svg>
                </li>
            </ul>

        </div>

        <!-- 移动端遮罩 -->
        <div class="site-mobile-shade"></div>
    </div>
    <!-- layui JS -->
    <script src="layui/layui.js"></script>
    <!-- jQuery JS -->
    <script src="js/jquery.js"></script>
    <!-- 公共JS -->
    <script src="js/common.js"></script>

</body>

</html>