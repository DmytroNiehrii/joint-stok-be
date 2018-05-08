package com.jointstock.jointstokbe.converter;

import com.jointstock.jointstokbe.model.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConverterConfig {

    @Autowired
    CommunityRepository communityRepository;

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        ConversionService object = bean.getObject();
        return object;
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<Converter>();

        converters.add(new CommunityToCommunityCard());
        converters.add(new CommunityDAOToCommunityEntity(communityRepository));

        return converters;
    }
}
