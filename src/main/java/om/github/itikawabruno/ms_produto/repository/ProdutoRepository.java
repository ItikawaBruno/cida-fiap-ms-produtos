package om.github.itikawabruno.ms_produto.repository;


import om.github.itikawabruno.ms_produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findProdutoByNome(String nome);
}
