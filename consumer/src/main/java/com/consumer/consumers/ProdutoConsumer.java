package com.consumer.consumers;

import com.produto.constants.RabbitMQConstants;
import com.produto.dto.ProdutoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Castro
 */
@Component
public class ProdutoConsumer {

    // ANOTAÇÃO QUE PARA ESCUTAR AS MENSAGEM QUE SÃO ENVIADAS AO RABBITMQ
    @RabbitListener(queues = RabbitMQConstants.FILA_PRODUTO)
    private void produtoConsumer(ProdutoDto produtoDto) {
        System.out.println("--- [CONSUMER] PRODUTO ---");
        System.out.println(produtoDto.codigo_produto);
        System.out.println(produtoDto.nome_produto);
        System.out.println(produtoDto.valor_produto);
        System.out.println(produtoDto.quantidade_produto);
    }
}
