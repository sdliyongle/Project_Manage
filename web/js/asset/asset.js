layui.config({
    base: '/layui/extend/'
}).use(['table', 'element', 'form', 'dtree', 'tablePlug'], function () {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form;
    var dtree = layui.dtree;
    var tablePlug = layui.tablePlug;

    tablePlug.smartReload.enable(true);

    //用户列表展示
    var tableIns = table.render({
        elem: '#asset-table',
        url: '/asset/list',
        toolbar: '#toolbar',
        cellMinWidth : 95,
        smartReloadModel: true,
        page: true,
        id: "assetListTable",
        limits : [5,10,15,20,25],
        limit : 5,
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: "assetId", title:'编号',fixed:"true", minWidth:80, align:"center"},
            {field: 'assetName', title: '资产名称', minWidth:50, align:"center"},
            {field: 'assetType', title: '资产类型', minWidth:100, align:'center'},
            {field: 'assetStatus', title: '资产状态', align:'center'},
            {field: 'assetValue', title: '资产价值', align:'center',minWidth:150},
            {field: 'assetRentalStatus', title: '是否外借', align:'center',minWidth:150},
            {title: '操作', fixed: 'right', align: 'center', toolbar: '#column-toolbar'}
        ]]
    });


    //条件搜索按钮
    $(".search_btn").on("click", function (){
        console.log($("input[name='asset_id']").val());
        table.reload("assetListTable", {
            page: {
                curr:1
            },
            where:{
                assetId: $("input[name='asset_id']").val(),  //用户名
            }
        })
    })

    // 工具条点击事件：增
    table.on('toolbar', function (obj) {
        var data = obj.data;
        var event = obj.event;

        if (event === 'add') {
            layer.open({
                content: "/view/asset/asset-add.html",
                title: "新增资产",
                area: ['40%', '85%'],
                type: 2,
                maxmin: true,
                shadeClose: true
            });
        }
    });

    // 删改
    table.on('tool', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            edit(data.assetId);
        } else if (event === 'del') {
            layer.confirm("确定删除用户吗?", {icon: 3, title: '提示'}, function (index) {
                $.post("/asset/delete", {asset_id:obj.data.assetId}, function (data) {
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
        var url = "/asset/toUpdate"
        if(id) {
            url = url+"?asset_id="+id;
        }
        layer.open({
            content: url,
            title: "编辑",
            area: ['40%', '85%'],
            type: 2,
            maxmin: true,
            shadeClose: true,
            end: function () {
                table.reload('asset-table');
            }
        });
    }

    form.on('submit(search)', function (form) {
        table.reload('asset-table', {
            where: form.field
        });
        return false;
    });

});