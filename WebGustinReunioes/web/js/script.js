$(document).ready(function (){
    
    $("#formCadastroUsuario").on("submit", function (){
        if($("#cpNome").val() === ""){
            alert("Informe o nome");
            $("#cpNome").css("border","1px solid red");
            $("#cpNome").focus();
            $("#msg").html("Informe o nome");
            return false;
        }
        if($("#cpEmail").val() === ""){
            alert("Informe seu e-mail");
            $("#cpEmail").css("border","1px solid red");
            $("#cpEmail").focus();
            $("#msg").html("Informe seu e-mail");
            return false;
        }
        if($("#cpSenha").val() === ""){
            alert("Informe sua senha");
            $("#cpSenha").css("border","1px solid red");
            $("#cpSenha").focus();
            $("#msg").html("Informe sua senha");
            return false;
        }
        if($("#msg").html() !== ""){
            return false;
        }
        return true;
    });
    
    $("#cpSenha").on("blur", function (){
       $("#msg").load("home?ac=passwordAjax",{senha : $("#cpSenha").val()}); 
    });
});

