layui.config({
    base: '/layui/extend/'
}).extend({
    formSelects: 'formSelects-v4'
}).use(['form', 'layer', 'formSelects', 'dtree'], function () {
    $ = layui.jquery;
    var form = layui.form
        , layer = parent.layer === undefined ? layui.layer : top.layer
        , formSelects = layui.formSelects
        , dtree = layui.dtree;

    // dtree.renderSelect({

    //     elem: "#deptTree",
    //     url: "/data/dept/tree.json",
    //     dataStyle: "layuiStyle",
    //     width: "100%",
    //     method: "GET",
    //     dot: false,
    //     accordion: true,
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
    // dtree.on("node('deptTree')" ,function(obj){
    //     $("#deptId").val(obj.param.nodeId);
    // });

    form.on('submit(add)', function (form) {
        index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        // form.field.role = formSelects.value('role-select', 'val');
        var url = "/meeting/add";
        console.log(form.field);
        $.post(url, form.field, function (res) {
            res = eval("("+res+")")
            if(res.code==200) {
                setTimeout(function () {
                    top.layer.close(index);
                    top.layer.msg("操作成功！",{icon: 6});
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }, 500);
            } else {
                layer.msg(
                    res.message, {
                        icon: 5
                    }
                )
            }
        })
        return false;
    });
});