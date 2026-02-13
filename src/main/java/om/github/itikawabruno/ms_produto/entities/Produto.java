package om.github.itikawabruno.ms_produto.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;

}
