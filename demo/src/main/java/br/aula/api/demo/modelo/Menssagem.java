package br.aula.api.demo.modelo;


import org.springframework.stereotype.Component;

@Component // quando sua aplicação spring for exec. ele vai varrer todos os elements que estao nessa classe
// depois que ele fizer isso posso usar o AUTOWIRED para instanciar um obj dessa classe.

public class Menssagem {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
