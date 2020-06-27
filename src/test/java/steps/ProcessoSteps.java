package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.DadosProcesso;
import pages.NewProcesso;
import pages.Processo;
import support.BaseSteps;

public class ProcessoSteps extends BaseSteps {
    private static Processo processo = new Processo(driver);
    private static NewProcesso newProcesso = new NewProcesso(driver);
    private static DadosProcesso dadosProcesso = new DadosProcesso(driver);
    private String codigo= null;

    @Dado("^que tenha acessado a tela de processos$")
    public void que_tenha_acessado_a_tela_de_processos() throws Throwable {
        processo.acessarProcesso();
    }

    @Dado("^clicar em Novo Processo$")
    public void clicar_em_Novo_Processo() throws Throwable {
        processo.clickNovoProcesso();
    }

    @Dado("^preencher o campo Numero da vara do processo (\\d+)$")
    public void preencher_o_campo_Numero_da_vara_do_processo(int arg1) throws Throwable {
        newProcesso.preencherVara((Integer.toString(arg1)));
    }

    @Dado("^preencher o campo Numero do Processo (\\d+)$")
    public void preencher_o_campo_Numero_do_Processo(int arg1) throws Throwable {
       newProcesso.preencherNumeroProcesso((Integer.toString(arg1)));
    }

    @Dado("^preencher o campo Natureza \"([^\"]*)\"$")
    public void preencher_o_campo_Natureza(String arg1) throws Throwable {
        newProcesso.preencherNatureza(arg1);
    }

    @Dado("^preencher o campo Partes \"([^\"]*)\"$")
    public void preencher_o_campo_Partes(String arg1) throws Throwable {
        newProcesso.preencherPartes(arg1);
    }

    @Dado("^preencher o campo Urgente \"([^\"]*)\"$")
    public void preencher_o_campo_Urgente(String arg1) throws Throwable {
        newProcesso.preencherUrgente(arg1);
    }

    @Dado("^preencher o campo Arbitramento \"([^\"]*)\"$")
    public void preencher_o_campo_Arbitramento(String arg1) throws Throwable {
        newProcesso.preencherArbitramento(arg1);
    }

    @Dado("^preencher o campo Assistente Social \"([^\"]*)\"$")
    public void preencher_o_campo_Assistente_Social(String arg1) throws Throwable {
        newProcesso.preencherAssistenteSocial(arg1);
    }

    @Dado("^preencher o campo Data Entrada \"([^\"]*)\"$")
    public void preencher_o_campo_Data_Entrada(String arg1) throws Throwable {
        newProcesso.preencherDataEntrada(arg1);
    }

    @Dado("^preencher o campo Data saida \"([^\"]*)\"$")
    public void preencher_o_campo_Data_saida(String arg1) throws Throwable {
        newProcesso.preencherDataSaida(arg1);
    }

    @Dado("^preencher o campo Dara Agendamento \"([^\"]*)\"$")
    public void preencher_o_campo_Dara_Agendamento(String arg1) throws Throwable {
        newProcesso.preencherDataAgendamento(arg1);
    }

    @Dado("^preencher o campo Status \"([^\"]*)\"$")
    public void preencher_o_campo_Status(String arg1) throws Throwable {
        newProcesso.preencherStatus(arg1);
    }

    @Dado("^preencher o campo Observacao \"([^\"]*)\"$")
    public void preencher_o_campo_Observacao(String arg1) throws Throwable {
        newProcesso.preencherObservacao(arg1);
    }

    @Quando("^clicar em Salvar Processo$")
    public void clicar_em_Salvar_Processo() throws Throwable {
        newProcesso.clickSalvar();
    }

    @Então("^o sistema deve exibir a mensagem \"([^\"]*)\"$")
    public void o_sistema_deve_exibir_a_mensagem(String arg1) throws Throwable {
        String result = newProcesso.pegarMensagem();
        Assert.assertEquals(arg1,result);
    }
    @Dado("^pegar o codigo do processo salvo$")
    public void pegar_o_codigo_do_processo_salvo() throws Throwable {
       codigo = dadosProcesso.getCodigProcesso();
    }

    @Quando("^clicar em Mostrar no processo que foi criado$")
    public void clicar_em_Mostrar_no_processo_que_foi_criado() throws Throwable {
        processo.clickMostrarProcesso(codigo);
    }

    @Então("^o sistema deve apresentar o processo (\\d+)$")
    public void o_sistema_deve_apresentar_o_processo(int arg1) throws Throwable {

        Assert.assertEquals(Integer.toString(arg1),dadosProcesso.getNumeroProcesso());
    }

    @Quando("^clicar em Editar o Processo criado$")
    public void clicar_em_Editar_o_Processo_criado() throws Throwable {
        processo.clickEditarProcesso(codigo);
    }

    @Quando("^clicar em Apagar$")
    public void clicar_em_Apagar() throws Throwable {
        processo.clickApagarProcesso(codigo);
    }

    @Quando("^clicar em sim no alerta de confirmação$")
    public void clicar_em_sim_no_alerta_de_confirmação() throws Throwable {
        driver.ChooseOkOnNextConfirmation();
    }

    @Então("^não deve exibir o processo no grid$")
    public void não_deve_exibir_o_processo_no_grid() throws Throwable {
        processo.validarProcessoApagado(codigo);
    }
    @Dado("^clicar em voltar para Processos$")
    public void clicar_em_voltar_para_Processos() throws Throwable {
         dadosProcesso.clickVoltar();
    }

    @Então("^o sistema deve apresentar o valor de processo \"([^\"]*)\"$")
    public void oSistemaDeveApresentarOValorDeProcesso(String arg0) throws Throwable {
        Assert.assertEquals(arg0,dadosProcesso.getNumeroProcesso());
    }

    @E("^o valor de Vara \"([^\"]*)\"$")
    public void oValorDeVara(String arg0) throws Throwable {
        Assert.assertEquals(arg0,dadosProcesso.getVara());
    }

    @E("^o valor de natureza \"([^\"]*)\"$")
    public void oValorDeNatureza(String arg0) throws Throwable {
        Assert.assertEquals(arg0,dadosProcesso.getNatureza());
    }

    @E("^o valor de partes \"([^\"]*)\"$")
    public void oValorDePartes(String arg0) throws Throwable {
        Assert.assertEquals(arg0,dadosProcesso.getPartes());
    }
}
