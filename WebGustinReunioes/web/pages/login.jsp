<h1>Login</h1>
<form action="home?ac=validaLogin" method="POST">
    Login:<input type="text" name="cpLogin" value="" /><br />
    Senha:<input type="password" name="cpSenhaLogin" value="" /><br />
    <br />
    <br />
    <input type="submit" value="Logar" />
    <br />
    <label style="color:red">${requestScope.msg}</label>
</form>