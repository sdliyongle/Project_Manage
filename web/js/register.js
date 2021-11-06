layui.use(['form', 'jquery'], function(){
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;
    // layer.msg('玩命卖萌中', function(){
    //   //关闭后的操作
    //   });
    //监听提交
    form.on('submit(register)', function(data){
        data = data.field;
        console.log(data);
        if ( data.userName =="undefined" || data.userName =="" || data.userName.trim()=="") {
            layer.msg('用户名不能为空');
            return false;
        }
        if ( data.trueName =="undefined" || data.trueName =="" || data.trueName.trim()=="") {
            layer.msg('真实姓名不能为空');
            return false;
        }
        if ( data.mail =="undefined" || data.mail =="" || data.mail.trim()=="") {
            layer.msg('邮箱不能为空');
            return false;
        }
        if ( data.password =="undefined" || data.password =="" || data.password.trim()=="")  {
            layer.msg('密码不能为空');
            return false;
        }
        if ( data.role =="undefined" || data.role =="" || data.role.trim()=="")  {
            layer.msg('角色不能为空');
            return false;
        }
        $.ajax({
            type:"post",
            url:"user/register",
            data:{
                userName:data.userName,
                trueName: data.trueName,
                email: data.email,
                password:data.password,
                role: data.role
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    layer.msg('注册成功', function () {
                        window.location.href="login.html";
                    });
                } else {
                    layer.msg(data.message);
                }
            }
        });
        return false;
    });

});