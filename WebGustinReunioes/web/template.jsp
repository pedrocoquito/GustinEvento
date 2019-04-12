<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head> 
    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="js/script.js" type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Gustin Business</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" charset="utf-8" />	
</head>
<body>
   
	<div id="header">
		<a href="home?ac=home" id="logo"><img src="images/logo.jpg" alt="LOGO" /></a>
		<div id="navigation">
			<ul>
				<li><a href="home?ac=home">Principal</a></li>                              
				<li><a href="home?ac=reunioes">Reuniões</a></li>
                                <c:if test="${sessionScope.user == null}">
                                <li><a href="home?ac=login">Login</a></li>
                                <li><a href="home?ac=cadastro">Cadastre-se</a></li>
                                </c:if>
                                <c:if test="${sessionScope.user != null}">
                                <li><a href="home?ac=secured/reserva">Reservar Sala</a></li>
                                <li><a href="home?ac=sair">Sair</a></li>
                                    <c:if test="{sessionScope.user.nome == 'admin'}">
                                    <li><a href="home?ac=cadastroSala">Cadastrar Sala</a></li>
                                    </c:if>
                                </c:if>
			</ul>
		</div>
	</div> <!-- /#header -->
	<div id="contents">
		<div class="background">
			<div id="services"><!-- div que será alterada -->
                            <c:catch var="erro">
                                <c:if test="${param.page == null}">
                                <jsp:include page="pages/home.jsp" />
                            </c:if>
                            <c:if test="${param.page != null}">
                                <jsp:include page="pages/${param.page}.jsp" />
                            </c:if>
                            </c:catch>
                            <c:if test="${erro != null}">
                                <jsp:include page="pages/pageNotFound.jsp" />
                            </c:if>                          
			</div>
		</div>
	</div> 
	<div id="footer">
		<ul class="contacts">
			<h3>Contato</h3>
			<li><p>E-mail: salareuniao@gustinbusiness.com</p></li>
			<li><p>Endereço: Quadra 0503 Bloco C, 1085</p></li>
			<li><p>Telefone: (99)2345-1789</p></li>
		</ul>
		<span class="footnote">&copy; Copyright &copy; 2019. All rights reserved</span>
	</div> 
</body>
</html>