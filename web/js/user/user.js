layui.config({
    base: '/layui/extend/'
}).use(['table', 'element', 'form', 'dtree', 'tablePlug'], function () {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;
    var dtree = layui.dtree;
    var tablePlug = layui.tablePlug;

    tablePlug.smartReload.enable(true);

    // dtree.renderSelect({
    //     elem: "#deptTree",
    //     url: "/data/dept/tree.json",
    //     dataStyle: "layuiStyle",
    //     width: "100%",
    //     method: "GET",
    //     dot: false,
    //     menubar: true,
    //     response: {
    //         statusCode: 0,
    //         message: "msg",
    //         treeId: "id",
    //         parentId: "parentId",
    //         title: "name"
    //     }
    // });
    //
    // dtree.on("node('deptTree')" ,function(obj) {
    //     var typeDom = layui.$('#deptId');
    //     console.log(typeDom.val() , obj.param.nodeId);
    //     console.log(typeDom.val() === obj.param.nodeId);
    //     if (typeDom.val() === obj.param.nodeId) {
    //         typeDom.val('');
    //         layui.$("input[dtree-id='deptTree']").val('请选择');
    //     } else {
    //         typeDom.val(obj.param.nodeId)
    //     }
    // });

    //用户列表展示
    var tableIns = table.render({
        elem: '#user-table',
        url: '/user/list',
        toolbar: '#toolbar',
        cellMinWidth : 95,
        smartReloadModel: true,
        page: true,
        id: "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: "id", title:'编号',fixed:"true", width:80},
            {field: 'userName', title: '用户名', minWidth:50, align:"center"},
            {field: 'bz', title: '备注名', minWidth:100, align:'center'},
            {field: 'trueName', title: '真实姓名', align:'center'},
            {field: 'remarks', title: '备注', align:'center',minWidth:150},
            {title: '操作', fixed: 'right', align: 'center', toolbar: '#column-toolbar'}
        ]]
    });


    //条件搜索按钮
    $(".search_btn").on("click", function (){
        console.log($("input[name='username']").val());
        table.reload("userListTable", {
            page: {
                curr:1
            },
            where:{
                userName: $("input[name='username']").val(),  //用户名
            }
        })
    })
    // // 账号状态(正常/锁定)点击事件
    // form.on('switch(status)', function(data){
    //     if (data.elem.checked) {
    //         parent.layer.msg("激活成功", {icon: 6});
    //     } else {
    //         parent.layer.msg("禁用成功", {icon: 6});
    //
    //     }
    // });

    // 工具条点击事件
    table.on('toolbar', function (obj) {
        var data = obj.data;
        var event = obj.event;

        if (event === 'add') {
            layer.open({
                content: "/view/user/user-add.html",
                title: "新增用户",
                area: ['40%', '85%'],
                type: 2,
                maxmin: true,
                shadeClose: true
            });
        }
    });

    // 行点击事件 重置密码
    table.on('tool', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            edit(data.id);
        } else if (event === 'del') {
            layer.confirm("确定删除用户吗?", {icon: 3, title: '提示'}, function (index) {
                $.post("/user/delete", {id:obj.data.id}, function (data) {
                    data = eval("("+data+")")
                    if(data.code==200) {
                        layer.msg("操作成功!");
                        tableIns.reload();
                    } else {
                        layer.msg(data.message, {icon: 5})
                    }
                });
            });
        }
    });


    function edit(id) {
        var url = "/user/toUpdate"
        if(id) {
            url = url+"?id="+id;
        }
        layer.open({
            content: url,
            title: "编辑",
            area: ['40%', '85%'],
            type: 2,
            maxmin: true,
            shadeClose: true,
            end: function () {
                table.reload('user-table');
            }
        });
    }

    form.on('submit(search)', function (form) {
        table.reload('user-table', {
            where: form.field
        });
        return false;
    });

});