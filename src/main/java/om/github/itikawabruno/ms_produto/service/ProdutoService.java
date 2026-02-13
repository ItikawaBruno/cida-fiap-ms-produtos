package om.github.itikawabruno.ms_produto.service;

import om.github.itikawabruno.ms_produto.dto.ProdutoDTO;
import om.github.itikawabruno.ms_produto.dto.ProdutoInputDTO;
import om.github.itikawabruno.ms_produto.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    public ResponseEntity<List<ProdutoDTO>> getProdutos(){
        List<ProdutoDTO> listDTO = createMock();
        return ResponseEntity.ok(listDTO);
    }

    public ResponseEntity<ProdutoDTO> inputProduto(ProdutoInputDTO inputDTO){
        ProdutoDTO dto = new ProdutoDTO(1L, inputDTO.nome(), inputDTO.descricao(), inputDTO.valor());
        return ResponseEntity.created(null).body(dto);
    }


    //Método de auxilio
    private List<ProdutoDTO> createMock(){
        List<Produto> list = List.of( new Produto(1L, "Smart Tv", "Smart TV LG Led 50 polegadas", 2285.0),
        new Produto(2L, "Smart Phone", "Smart Phone de ultima geração", 6985.0),
        new Produto(3L, "Teclado", "Teclado Aula com 87 teclas", 300.0),
        new Produto(4L, "Null", "Teclado Aula com 87 teclas", 450.0));

        List<ProdutoDTO> listDTO = list.stream().map(p -> new ProdutoDTO(p.getId(), p.getNome(),p.getDescricao(), p.getValor())).toList();
        return listDTO;
    }

}
