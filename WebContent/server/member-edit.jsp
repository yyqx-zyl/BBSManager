<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" >
        	<c:forEach items="${user }" var="u">
        		<div class="layui-form-item">
	              <label for="L_username" class="layui-form-label">
	                  <span class="x-red">*</span>账户名
	              </label>
	              <div class="layui-input-inline">
	                  <input type="text" id="L_username" name="userId" required="" lay-verify="nikename"
	                  autocomplete="off" class="layui-input" value="${u.userId }">
	              </div>
	          </div>
	          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="userPsw" required="" lay-verify="userPsw"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  1到16个字符
              </div>
          </div>
	          <div class="layui-form-item">
	              <label for="L_email" class="layui-form-label">
	                  <span class="x-red">*</span>邮箱
	              </label>
	              <div class="layui-input-inline">
	                  <input type="text" id="L_email" name="userEmail" required="" lay-verify="email"
	                  autocomplete="off" class="layui-input" value="${u.userEmail }">
	              </div>
	              <div class="layui-form-mid layui-word-aux">
	                  <span class="x-red">*</span>将会成为您唯一的登入名
	              </div>
	          </div>
	          
	           <div class="layui-form-item">
	              <label for="L_sex" class="layui-form-label">
	                  <span class="x-red">*</span>性别
	              </label>
	              <div class="layui-input-inline">
	              	<c:if test="${u.userSex eq '女' }" var="i">
	              		<input type="radio" checked="checked" name="userSex" value="女" />女
	              		<input type="radio" name="userSex" value="男" />男
	              	</c:if>
	              	<c:if test="${!i }">
	              		<input type="radio"  name="userSex" value="女" />女
	              		<input type="radio" checked="checked" name="userSex" value="男" />男
	              	</c:if>
	              </div>
	              <div class="layui-form-mid layui-word-aux">
	              </div>
	          </div>
	          
	          <div class="layui-form-item">
	              <label for="L_repass" class="layui-form-label">
	              </label>
	              <button  class="layui-btn" lay-filter="add" lay-submit="">
	               			  确认修改
	              </button>
	          </div>
        	</c:forEach>
      	</form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            /* nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            } */
            pass: [/(.+){1,12}$/, '密码必须1到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });
        //序列化表单
  	    $.fn.extend({
  	        serializeObject : function() {
  	            var o = {};
  	            var a = this.serializeArray();
  	            $.each(a, function() {
  	                if(this.name != "file"){//排除文件上传
  	                    if (o[this.name]) {
  	                        if (!o[this.name].push) {
  	                            o[this.name] = [ o[this.name] ];
  	                        }
  	                        o[this.name].push(this.value || '');
  	                    } else {
  	                        o[this.name] = this.value || '';
  	                    }
  	                }
  	            });
  	            return o;
  	        }
  	    });
        
          //监听提交
          form.on('submit(add)', function(data){
        	  // 使用ajax进行数据的增加
	          $.ajax({
	            	url:"${pageContext.request.contextPath }/UserServlet?op=xiu",
	            	type:"post",
	            	data:data.field,
	            	dataType:"text",// servlet中返回的是普通文本
	            	success:function(text){
	            		if(text.trim()=="true"){
	            			layer.alert("修改成功", {icon: 6},function () {
		                        //关闭当前frame
		                        x_admin_close();
		                        // 可以对父窗口进行刷新 
		                        x_admin_father_reload();
		                    }); 
	            		}else{
	            			layer.alert("修改失败", {icon: 6},function () {
		                        //关闭当前frame
		                        x_admin_close();
		                        // 可以对父窗口进行刷新 
		                        x_admin_father_reload();
		                    }); 
	            		}
	            	}
	            });
            return false;
          }); 
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>