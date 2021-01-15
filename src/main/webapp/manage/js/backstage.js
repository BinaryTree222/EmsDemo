function checkLoginBackStage(){
    //检查用户名
    var userName =$("#user").val().trim();
    if (userName==null|| userName==""){
        //用户名不能为空
      $("#user").attr("placeholder","请输入用户名");
      return false;
    }
    //检查密码
    var pwd =$("#pwd").val().trim();
    if (pwd==null|| pwd==""){
        //用户名不能为空
        $("#pwd").attr("placeholder","请输入密码");
        return false;
    }
}