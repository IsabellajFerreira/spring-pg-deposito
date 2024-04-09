package br.com.fiap.springpgdeposito.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record ProdutoRequest(

        @Size(min = 5, max = 255)
        @NotNull(message = "O nome do produto é obrigatório")
        String nome,


        @Size(min = 10, max = 255)
        @NotNull(message = "A descriçao do produto é obrigatório")
        String descricao,

        @Min(0)
        @NotNull(message = "O valor do produto é obrigatório")
        BigDecimal valor

) {
}
