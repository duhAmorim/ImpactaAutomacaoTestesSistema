#language:pt

@processo
  Funcionalidade: Validar funcionalidade gestão de Processos

    Contexto:
      Dado que tenha acessado a tela de processos
      E clicar em Novo Processo
      E preencher o campo Numero da vara do processo 77712369
      E preencher o campo Numero do Processo 204362872
      E preencher o campo Natureza "Crime"
      E preencher o campo Partes "todas"
      E preencher o campo Urgente "Sim"
      E preencher o campo Arbitramento "Sim"
      E preencher o campo Assistente Social "Maria das Dores"
      E preencher o campo Data Entrada "15/12/1990"
      E preencher o campo Data saida "27/10/2021"
      E preencher o campo Dara Agendamento "20/08/2020"
      E preencher o campo Status "Operante"
      E preencher o campo Observacao "Um processo longo e duradouro"
      Quando clicar em Salvar Processo

    Cenário: Criar um novo processo
      Então o sistema deve exibir a mensagem "Processo foi criado com sucesso."

    Esquema do Cenario: Selecionar o Processo criado
       E pegar o codigo do processo salvo
       E clicar em voltar para Processos
       Quando clicar em Mostrar no processo que foi criado
       Então o sistema deve apresentar o valor de processo "<process>"
       E o valor de Vara "<vara>"
       E o valor de natureza "<natureza>"
       E o valor de partes "<partes>"
       Exemplos:
       |process  |vara     |natureza|partes|
       |204362872|77712369 |Crime   |todas|

    Cenario: Atualizar o Status o Status do processo já criado
      E pegar o codigo do processo salvo
      E clicar em voltar para Processos
      Quando clicar em Editar o Processo criado
      E preencher o campo Status "Quase la"
      E clicar em Salvar Processo
      Então o sistema deve exibir a mensagem "Processo atualizado com sucesso."

    Cenario: Excluir um processo criado
      E pegar o codigo do processo salvo
      E clicar em voltar para Processos
      Quando clicar em Apagar
      E clicar em sim no alerta de confirmação
      Então não deve exibir o processo no grid

