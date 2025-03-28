package br.aula.api.demo.controller;


import br.aula.api.demo.modelo.Cliente;
import br.aula.api.demo.modelo.Pessoa;
import br.aula.api.demo.repository.Repositorio;
import br.aula.api.demo.servico.Servico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    //metodo ação = sobrescreve o repositorio
    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    //rota post cadastra um objeto do tipo pessoa e salva no db
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selectBycode(@PathVariable int codigo){
        return servico.selecionarByCodigo(codigo);
    }


    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);

    }

    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover (@PathVariable int codigo){
        return servico.excluir(codigo);

    }

    @GetMapping("api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("/api/ordenarnomes2")
    public List<Pessoa> OrdenarNomes_B(){
        return acao.findByNomeOrderByIdadeDesc("diego");
    }

    @GetMapping("/api/contem")
    public List<Pessoa> contem(){
        return acao.findByNomeContaining("ie");
    }

    @GetMapping("api/somaIdade")
    public int somaIdades(){
        return acao.somaIdades();
    }

    @GetMapping("api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(40);
    }

    @GetMapping("api/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){

    }




    @GetMapping("")
    public String boasVindas() {
        return "Boa Vindas";

    }

}
