<%@page contentType="text/html; charset=utf-8"%>
<%@page import = "dao.UserDAO" %>
<%
request.setCharacterEncoding("utf-8");

String uid = request.getParameter("memId");
String upass = request.getParameter("memPw");

UserDAO dao = new UserDAO();
int code = dao.login(uid, upass);

if(code==1){
out.print("아이디가 존재하지않습니다");
}
else if(code==2){
out.print("비밀번호가 일치하지않습니다");
}

out.print("123");

%>