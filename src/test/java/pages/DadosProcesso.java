package pages;

import support.DriverQA;

public class DadosProcesso extends BasePage{
    public DadosProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }
    public String getCodigProcesso(){
        return driver.getText("codigo");
    }
    public String getVara(){
        return driver.getText("vara");
    }
    public String getNumeroProcesso(){
        return driver.getText("numero");
    }
    public String getNatureza(){
        return driver.getText("natureza");
    }
    public String getPartes(){
        return driver.getText("partes");
    }
    public String gatUrgente(){
        return driver.getText("urgente");
    }
    public String getArbitramento(){
        return driver.getText("arbitramento");
    }
    public String getAssistenteSocial(){
        return driver.getText("as_social");
    }
    public String getDataEntrada(){
        return driver.getText("dt_entrada");
    }
    public String getDataSaida(){
        return driver.getText("dt_saida");
    }
    public String getDataAgendamento(){
        return driver.getText("dt_agendamento");
    }
    public String getStatus(){
        return driver.getText("status");
    }
    public String getObservacao(){
        return driver.getText("observacao");
    }
    public void clickVoltar(){

        driver.click("Voltar","link");

    }
}
