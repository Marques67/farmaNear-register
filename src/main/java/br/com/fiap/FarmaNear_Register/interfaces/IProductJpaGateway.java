package br.com.fiap.FarmaNear_Register.interfaces;

import br.com.fiap.FarmaNear_Register.controller.dto.ProductDto;

import java.util.List;

public interface IProductJpaGateway {

    ProductDto saveProduct(ProductDto productDto);

    List<ProductDto> saveProduct(List<ProductDto> productDto);
}
