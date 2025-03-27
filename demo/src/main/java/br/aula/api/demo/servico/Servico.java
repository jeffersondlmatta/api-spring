package br.aula.api.demo.servico;

import br.aula.api.demo.modelo.Menssagem;
import br.aula.api.demo.modelo.Pessoa;
import br.aula.api.demo.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;

@Service
public class Servico {

    @Autowired
    private Menssagem mensagem;

    @Autowired
    private Repositorio acao;
    @Autowired
    private StringHttpMessageConverter stringHttpMessageConverter;

    //metodo para cadastrar pessoas, vai ser chamado no controller, aqui tem todas as regras
    public ResponseEntity<?> cadastrar(Pessoa obj){
        if (obj.getNome().equals("")){

            mensagem.setMensagem("nome deve ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() < 0 ){
            mensagem.setMensagem("idade deve ser valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //metodo para selecionar pessoas
    public ResponseEntity<?> selecionar(){

        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);

    }
}
