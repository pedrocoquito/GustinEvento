package br.evento.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IActionsCommand {
    
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
