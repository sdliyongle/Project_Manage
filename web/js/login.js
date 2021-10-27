layui.use(['form', 'jquery'], function(){
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;
    // layer.msg('玩命卖萌中', function(){
    //   //关闭后的操作
    //   });
    //监听提交
    form.on('submit(login)', function(data){
        data = data.field;
        alert(data.userName);
        alert(data.password);
        if ( data.userName =="undefined" || data.userName =="" || data.userName.trim()=="") {
            layer.msg('用户名不能为空');
            return false;
        }
        if ( data.password =="undefined" || data.password =="" || data.password.trim()=="")  {
            layer.msg('密码不能为空');
            return false;
        }
        $.ajax({
            type:"post",
            url:"user/login",
            data:{
                userName:data.userName,
                password:data.password,
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    layer.msg('登录成功', function () {
                        window.location.href="index.html";
                    });
                } else {
                    layer.msg(data.message);
                }
            }
        });
        return false;
    });
});