package pages;

import support.DriverQA;

import javax.swing.text.html.CSS;

public class NewProcesso extends BasePage{

    public NewProcesso(DriverQA stepDriver) {
        super(stepDriver);
    }
    public void preencherVara(String value){
        driver.sendKeys(value,"processo_vara");
    }
    public void preencherNumeroProcesso(String value){
        driver.sendKeys(value,"processo_numero_processo");
    }
    public void preencherNatureza(String value){
        driver.sendKeys(value,"processo_natureza");
    }
    public void preencherPartes(String value){
        driver.sendKeys(value,"processo_partes");
    }
    public void preencherUrgente(String value){
        driver.selectByText(value,"processo_urgente","CSS");
                //sendKeys(value,"");
    }
    public void preencherArbitramento(String value){
        if (value.equals("Sim")){
            driver.click("processo_arbitramento_s");
        }
        else {
            driver.click("processo_arbitramento_n");
        }

    }
    public void preencherAssistenteSocial(String value){
        driver.sendKeys(value,"processo_assistente_social");
    }
    public void preencherDataEntrada(String value){
        driver.sendKeys(value,"processo_data_entrada");
    }
    public void preencherDataSaida(String value){
        driver.sendKeys(value,"processo_data_saida");
    }
    public void preencherDataAgendamento(String value){
        driver.sendKeys(value,"processo_data_agendamento");
    }
    public void preencherStatus(String value){
        driver.sendKeys(value,"processo_status");
    }
    public void preencherObservacao(String value){
        driver.sendKeys(value,"processo_observacao");
    }
    public void clickSalvar(){
        driver.click("btn-save");
    }
    public String pegarMensagem(){
        return driver.getText("notice");
    }
}
