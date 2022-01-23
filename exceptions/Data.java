package exceptions;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Data {
    public int dia;
    public int mes;
    public int ano;

    public void preencheData (int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
    }
    
}
