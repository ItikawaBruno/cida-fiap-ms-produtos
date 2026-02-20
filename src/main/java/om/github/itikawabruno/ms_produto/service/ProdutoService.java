package om.github.itikawabruno.ms_produto.service;

import jakarta.persistence.EntityNotFoundException;
import om.github.itikawabruno.ms_produto.dto.ProdutoDTO;
import om.github.itikawabruno.ms_produto.dto.ProdutoInputDTO;
import om.github.itikawabruno.ms_produto.entities.Produto;
import om.github.itikawabruno.ms_produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> getProdutos(){
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getValor(), p.getEstoque())).toList();
    }

    public ResponseEntity<ProdutoDTO> inputProduto(ProdutoInputDTO inputDTO){
        Produto produto = new Produto();
        produto.setDescricao(inputDTO.descricao());
        produto.setNome(inputDTO.nome());
        produto.setValor(inputDTO.valor());
        produto.setEstoque(inputDTO.estoque());
        Produto newProduto = produtoRepository.save(produto);
        ProdutoDTO dto = new ProdutoDTO(newProduto.getId(), newProduto.getNome(), newProduto.getDescricao(), newProduto.getValor(), produto.getEstoque());
        return ResponseEntity.created(null).body(dto);
    }

    public ProdutoDTO getProdutoByNome(String nome) {
        Produto produto = produtoRepository.findProdutoByNome(nome).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getEstoque());
    }

    public Double getAllValorOfProducts(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().mapToDouble(p -> p.getValor() * p.getEstoque()).sum();
    }

    @Transactional(readOnly = true)
    public ProdutoDTO getProdutoById(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado. ID: "+id));
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getEstoque());
    }
}
