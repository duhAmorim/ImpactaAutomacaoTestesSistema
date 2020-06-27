package pages;

import support.DriverQA;

public class Processo extends BasePage{

    public Processo(DriverQA stepDriver) {
        super(stepDriver);
    }



    public void acessarProcesso() {
        String url = "http://agapito-server.herokuapp.com/processos/";
        driver.openURL(url);
    }
    public void clickNovoProcesso(){
        driver.click("btn-novo");
    }
    public void clickMostrarProcesso(String id){
        String elemento = "btn-show_"+id;
        driver.waitElementToBeClickable(elemento);
        driver.click(elemento);
    }
    public void clickEditarProcesso(String id){
        driver.click("btn-edit_"+id);
    }
    public void clickApagarProcesso(String id){
        driver.click("btn-delete_"+id);
    }
    public void validarProcessoApagado(String codigo){
        driver.waitInvisibilityOfElement("btn-delete_"+codigo);
    }

}
