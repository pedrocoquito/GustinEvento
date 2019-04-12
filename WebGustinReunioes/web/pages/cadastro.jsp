<h1>Cadastrar Usuário</h1>
<fieldset>
    <form id="formCadastroUsuario" action="home?ac=salvarUsuario" method="POST">
        Nome: <input type="text" id="cpNome" name="cpNome" value="${requestScope.usuario.nome}" /><br />
        E-mail: <input type="text" id="cpEmail" name="cpEmail" value="${requestScope.usuario.email}" /><br />
        Senha: <input type="password" id="cpSenha" name="cpSenha" value="" /><br />
        <br />
        <input type="submit" value="Salvar" />
        <br />
        <label style="color: blue" id="msg"></label>
        <c:foreach itens="${requestScope.erros}" var="erro">
            ${erro}<br />
        </c:foreach>
    </form>
</fieldset>