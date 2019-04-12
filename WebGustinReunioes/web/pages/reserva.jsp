<h1>Realizar reserva de sala</h1>
<fieldset>
    <form>
        Convidados: <select>
                        <option value="volvo">User1</option>
                        <option value="saab">User2</option>
                      </select><br />
        Hora: <input type="time" name="cpHora" value="" /><br />
        Dia: <input type="date" name="cpDia" value="" /><br />
        Pauta: <input type="text" name="cpPauta" value="" /><br />
        Projetor: <input type="checkbox" name="cpProjetorReserva" value="" /><br />
        Conference Call: <input type="checkbox" name="cpConferenceReserva" value="" /><br />
        <br />
        <input type="submit" value="Reservar" />
        <br />
        <label style="color: blue" id="msg"></label>
    </form>
</fieldset>