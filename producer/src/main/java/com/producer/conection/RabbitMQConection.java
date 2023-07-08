package com.producer.conection;

import com.produto.constants.RabbitMQConstants;
import javax.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Castro
 */
@Component
public class RabbitMQConection {

    private static final String NOME_EXCHANGE = "amq.direct";

    private AmqpAdmin amqpAdmin;

    // INTERFACE RESPONSÁVEL POR CONECTAR O RABBITMQ E FAZER AS CRIAÇÕES DAS FILAS.
    public RabbitMQConection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    // FILA
    private Queue queue(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    // EXCHANGE
    private DirectExchange directExchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    // BIND ENTRE FILA E EXCHANGE
    private Binding bindingFilaExchange(Queue fila, DirectExchange direct) {

        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, direct.getName(), fila.getName(), null);
    }

    // ANOTAÇÃO 'PostConstruct' PARA QUANDO LEVANTAR A APLICAÇÃO E A CLASSE FOR CONSTRUÍDA EXECUTA O QUE ESTA DENTRO DA FUNÇÃO
    @PostConstruct
    // MÉTODO RESPONSÁVEL POR UTILIZAR AS FUNÇÕES CRIADAS E CRIAR AS FILAS DENTRO DO RABBITMQ
    private void adicionar() {

        Queue filaProduto = this.queue(RabbitMQConstants.FILA_PRODUTO);

        // RECEBE AS MENSAGEM E DIRECIONA PARA A DIRECT
        DirectExchange direct = this.directExchange();

        Binding bindingProduto = this.bindingFilaExchange(filaProduto, direct);

        // CRIANDO AS FILAS NO RABBITMQ
        this.amqpAdmin.declareQueue(filaProduto);
        this.amqpAdmin.declareExchange(direct);
        this.amqpAdmin.declareBinding(bindingProduto);
    }
}
