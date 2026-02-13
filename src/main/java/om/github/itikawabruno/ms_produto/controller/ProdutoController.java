package om.github.itikawabruno.ms_produto.controller;

import om.github.itikawabruno.ms_produto.dto.ProdutoDTO;
import om.github.itikawabruno.ms_produto.dto.ProdutoInputDTO;
import om.github.itikawabruno.ms_produto.entities.Produto;
import om.github.itikawabruno.ms_produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getProduto(){
        return service.getProdutos();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> postProduto(@RequestBody ProdutoInputDTO inputDTO){
        return service.inputProduto(new ProdutoInputDTO(inputDTO.nome(), inputDTO.descricao(), inputDTO.valor()));
    }

}
