package com.producer.controller;

import com.producer.service.RabbitMQService;
import com.produto.constants.RabbitMQConstants;
import com.produto.dto.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping
    private ResponseEntity enviarProduto(@RequestBody ProdutoDto produtoDto) {
        this.rabbitMQService.enviarMensagem(RabbitMQConstants.FILA_PRODUTO, produtoDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
