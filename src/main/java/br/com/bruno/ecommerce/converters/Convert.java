package br.com.bruno.ecommerce.converters;

public interface Convert<model, dto>{

    model convert(dto dto);

    dto unConvert(model model);
}
