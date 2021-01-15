// 检查用户名为一性
function checkUserName(){
    var userName=$("#userName").val().trim();
    if (userName !=null && userName !=""){
        $.ajax({
            type: "POST",
            url: "/EmsDemo_war_exploded/checkname.user",
            data: "name="+$("#userName").val(),
            success: function(msg){
                $("#unflag").val(msg);
            }
        });
    }else{
        $("#errUserName").html("用户名不能为空");
        $("#errUserName").attr({style:"color:red"});
    }
}
// 表单验证
function checkAll(){
     //检查用户名
    var userName=$("#userName").val().trim();
    var unflag=$("#unflag").val();
    if (userName ==null || userName==""){
        //用户名不能为空
        $("#errUserName").html("用户名不能为空");
        $("#errUserName").attr({style:"color:red"});
        return false;
    }else if (unflag==1){
        //用户名已存在
        $("#errUserName").html("用户名已存在");
        $("#errUserName").attr({style:"color:red"});
        return false;
    }else{
        $("#errUserName").removeAttr("color");
    }
    //检查姓名
    var name=$("#name").val().trim();
    if (name ==null || name ==""){
        //姓名不能为空
        $("#errName").html("姓名不能为空");
        $("#errName").attr({style:"color:red"});
        return false;

    }
    //检查密码
    var pwd=$("#passWord").val().trim();
    if (pwd==null | pwd ==""){
        //密码不能为空
        $("#errPwd").html("密码不能为空");
        $("#errPwd").attr({style:"color:red"});
        return  false;
    }
    //检查重复密码
    var repwd =$("#repassWord").val().trim();
    if (repwd != pwd){
        //密码与重复密码不一致
        $("#errRePwd").html("密码与重复密码不一致");
        $("#errRePwd").attr({style:"color:red"});
        return false;
    }
    //检查地址
    var add=$("#address").val().trim();
    if (add==null || add==""){
        //地址不能为空
        $("#errAddress").html("地址不能为空");
        $("#errAddress").attr({style:"color:red"});
        return false;
    }
   //检查验证码
    if (!check()){
        //验证码错误
        return false;
    }
}
// 登录检查
function loginCheck() {
    //检查用户名
    var userName=$("#uN").val().trim();
    if(userName==null || userName==""){
        //用户名不能位空
        $("#errU").html("用户名不能位空");
        return false;
    }
    //检查密码
    var pw=$("#pW").val().trim();
    if (pw==null || pw==""){
        //密码不能为空
        $("#errP").html("密码不能为空");
        return  false;
    }
    if (!check()){
        //验证吗不对
        return  false;
    }

}