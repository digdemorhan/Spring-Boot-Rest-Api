package com.example.spring_boot_rest_api.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Konfigürasyon class'ı olduğunu belirttik
public class ModelMapperConfig {

    @Bean //Instance oluşumu için eklenen anotasyon
    public ModelMapper getModelMapper(){ //Dto-Entity dönüşümü için ModelMapper kullandık
        ModelMapper modelMapper = new ModelMapper(); //ModelMapper'dan instance oluşturduk
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); //Tam eşleştirme
        return modelMapper;
    }

    /*
    Tam eşleştirmeden kasıt, dto’daki field’lara karşılık gelen user entity nesnesindeki birebir örtüşen alanların
    eşleştirilmesidir.
     */
}
