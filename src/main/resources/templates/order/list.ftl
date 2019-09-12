<html>
    <head>
        <meta charset="UTF-8">
        <title>卖家商品列表</title>
        <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<#--        <link rel="stylesheet" href="/sell/css/style.css">-->
        <style>
            body {
                position: relative;
                overflow-x: hidden;
            }
            body,
            html {
                height: 100%;
                /*background-color: #583e7e;*/
            }
            .nav .open > a {
                background-color: transparent;
            }
            .nav .open > a:hover {
                background-color: transparent;
            }
            .nav .open > a:focus {
                background-color: transparent;
            }
            /*-------------------------------*/
            /*           Wrappers            */
            /*-------------------------------*/
            #wrapper {
                -moz-transition: all 0.5s ease;
                -o-transition: all 0.5s ease;
                -webkit-transition: all 0.5s ease;
                padding-left: 0;
                transition: all 0.5s ease;
            }
            #wrapper.toggled {
                padding-left: 180px;
            }
            #wrapper.toggled #sidebar-wrapper {
                width: 180px;
            }
            #sidebar-wrapper {
                -moz-transition: all 0.5s ease;
                -o-transition: all 0.5s ease;
                -webkit-transition: all 0.5s ease;
                background: #1a1a1a;
                height: 100%;
                left: 220px;
                margin-left: -220px;
                overflow-x: hidden;
                overflow-y: auto;
                transition: all 0.5s ease;
                width: 0;
                z-index: 1000;
            }
            #sidebar-wrapper::-webkit-scrollbar {
                display: none;
            }
            #page-content-wrapper {
                padding-top: 70px;
                width: 100%;
            }
            /*-------------------------------*/
            /*     Sidebar nav styles        */
            /*-------------------------------*/
            .sidebar-nav {
                list-style: none;
                margin: 0;
                padding: 0;
                position: absolute;
                top: 0;
                width: 220px;
            }
            .sidebar-nav li {
                display: inline-block;
                line-height: 20px;
                position: relative;
                width: 100%;
            }
            .sidebar-nav li:before {
                background-color: #1c1c1c;
                content: '';
                height: 100%;
                left: 0;
                position: absolute;
                top: 0;
                -webkit-transition: width 0.2s ease-in;
                transition: width 0.2s ease-in;
                width: 3px;
                z-index: -1;
            }
            .sidebar-nav li:first-child a {
                background-color: #1a1a1a;
                color: #ffffff;
            }
            .sidebar-nav li:nth-child(2):before {
                background-color: #402d5c;
            }
            .sidebar-nav li:nth-child(3):before {
                background-color: #4c366d;
            }
            .sidebar-nav li:nth-child(4):before {
                background-color: #583e7e;
            }
            .sidebar-nav li:nth-child(5):before {
                background-color: #64468f;
            }
            .sidebar-nav li:nth-child(6):before {
                background-color: #704fa0;
            }
            .sidebar-nav li:nth-child(7):before {
                background-color: #7c5aae;
            }
            .sidebar-nav li:nth-child(8):before {
                background-color: #8a6cb6;
            }
            .sidebar-nav li:nth-child(9):before {
                background-color: #987dbf;
            }
            .sidebar-nav li:hover:before {
                -webkit-transition: width 0.2s ease-in;
                transition: width 0.2s ease-in;
                width: 100%;
            }
            .sidebar-nav li a {
                color: #dddddd;
                display: block;
                padding: 10px 15px 10px 30px;
                text-decoration: none;
            }
            .sidebar-nav li.open:hover before {
                -webkit-transition: width 0.2s ease-in;
                transition: width 0.2s ease-in;
                width: 100%;
            }
            .sidebar-nav .dropdown-menu {
                background-color: #222222;
                border-radius: 0;
                border: none;
                box-shadow: none;
                margin: 0;
                padding: 0;
                position: relative;
                width: 100%;
            }
            .sidebar-nav li a:hover,
            .sidebar-nav li a:active,
            .sidebar-nav li a:focus,
            .sidebar-nav li.open a:hover,
            .sidebar-nav li.open a:active,
            .sidebar-nav li.open a:focus {
                background-color: transparent;
                color: #ffffff;
                text-decoration: none;
            }
            .sidebar-nav > .sidebar-brand {
                font-size: 20px;
                height: 65px;
                line-height: 44px;
            }
            /*-------------------------------*/
            /*       Hamburger-Cross         */
            /*-------------------------------*/
            .hamburger {
                background: transparent;
                border: none;
                display: block;
                height: 32px;
                margin-left: 15px;
                position: fixed;
                top: 20px;
                width: 32px;
                z-index: 999;
            }
            .hamburger:hover {
                outline: none;
            }
            .hamburger:focus {
                outline: none;
            }
            .hamburger:active {
                outline: none;
            }
            .hamburger.is-closed:before {
                -webkit-transform: translate3d(0, 0, 0);
                -webkit-transition: all 0.35s ease-in-out;
                color: #ffffff;
                content: '';
                display: block;
                font-size: 14px;
                line-height: 32px;
                opacity: 0;
                text-align: center;
                width: 100px;
            }
            .hamburger.is-closed:hover before {
                -webkit-transform: translate3d(-100px, 0, 0);
                -webkit-transition: all 0.35s ease-in-out;
                display: block;
                opacity: 1;
            }
            .hamburger.is-closed:hover .hamb-top {
                -webkit-transition: all 0.35s ease-in-out;
                top: 0;
            }
            .hamburger.is-closed:hover .hamb-bottom {
                -webkit-transition: all 0.35s ease-in-out;
                bottom: 0;
            }
            .hamburger.is-closed .hamb-top {
                -webkit-transition: all 0.35s ease-in-out;
                background-color: rgba(255, 255, 255, 0.7);
                top: 5px;
            }
            .hamburger.is-closed .hamb-middle {
                background-color: rgba(255, 255, 255, 0.7);
                margin-top: -2px;
                top: 50%;
            }
            .hamburger.is-closed .hamb-bottom {
                -webkit-transition: all 0.35s ease-in-out;
                background-color: rgba(255, 255, 255, 0.7);
                bottom: 5px;
            }
            .hamburger.is-closed .hamb-top,
            .hamburger.is-closed .hamb-middle,
            .hamburger.is-closed .hamb-bottom,
            .hamburger.is-open .hamb-top,
            .hamburger.is-open .hamb-middle,
            .hamburger.is-open .hamb-bottom {
                height: 4px;
                left: 0;
                position: absolute;
                width: 100%;
            }
            .hamburger.is-open .hamb-top {
                -webkit-transform: rotate(45deg);
                -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);
                background-color: #ffffff;
                margin-top: -2px;
                top: 50%;
            }
            .hamburger.is-open .hamb-middle {
                background-color: #ffffff;
                display: none;
            }
            .hamburger.is-open .hamb-bottom {
                -webkit-transform: rotate(-45deg);
                -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.73, 1, 0.28, 0.08);
                background-color: #ffffff;
                margin-top: -2px;
                top: 50%;
            }
            .hamburger.is-open:before {
                -webkit-transform: translate3d(0, 0, 0);
                -webkit-transition: all 0.35s ease-in-out;
                color: #ffffff;
                content: '';
                display: block;
                font-size: 14px;
                line-height: 32px;
                opacity: 0;
                text-align: center;
                width: 100px;
            }
            .hamburger.is-open:hover before {
                -webkit-transform: translate3d(-100px, 0, 0);
                -webkit-transition: all 0.35s ease-in-out;
                display: block;
                opacity: 1;
            }

        </style>
    </head>
    <body>

    <div id="wrapper" class="toggled">
<#--        <#include "../common/nav.ftl">-->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        卖家管理系统
                    </a>
                </li>
                <li>
                    <a href="/sell/seller/order/list"><i class="fa fa-fw fa-list-alt"></i> 订单</a>
                </li>
                <li class="dropdown open">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 商品 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="dropdown-header">操作</li>
                        <li><a href="/sell/seller/product/list">列表</a></li>
                        <li><a href="/sell/seller/product/index">新增</a></li>
                    </ul>
                </li>
                <li class="dropdown open">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i class="fa fa-fw fa-plus"></i> 类目 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="dropdown-header">操作</li>
                        <li><a href="/sell/seller/category/list">列表</a></li>
                        <li><a href="/sell/seller/category/index">新增</a></li>
                    </ul>
                </li>

                <li>
                    <a href="/sell/seller/logout"><i class="fa fa-fw fa-list-alt"></i> 登出</a>
                </li>
            </ul>
        </nav>

        <div id="page-content-wrapper">
        <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTOPage.content as orderDTO>
                                <tr>
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.orderStatusEnum.message}</td>
                                    <td>${orderDTO.payStatusEnum.message}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                                    <td>
                                        <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                            </#if>
                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if currentPage gte orderDTOPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        提醒
                    </h4>
                </div>
                <div class="modal-body">
                    您有新的订单
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                </div>
            </div>

        </div>

    </div>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script>
        var websocket = null;
        if ('WebSocket' in window) {
            websocket = new WebSocket('ws://127.0.0.1:8080/sell/webSocket');
        } else {
            alert('该浏览器不支持webSocket');
        }

        websocket.onopen = function (event) {
            console.log('建立连接');
        }
        
        websocket.onclose = function (wvent) {
            console.log('连接关闭');
        }

        websocket.onmessage = function (event) {
            console.log('收到消息', event.data);
            //弹窗提醒
            $('#myModal').modal('show');
        }

        websocket.onerror = function () {
            alert('webSocket通信发生错误')
        }

        window.onbeforeunload = function (ev) {
            websocket.close();
        }

    </script>
    </body>
</html>