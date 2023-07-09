package com.example.sj1.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 해당 클래스가 설정파일임을 정의
public class rootConfig {

    // .setFieldMatchingEnabled(true) : 객체의 필드명이 일치하는 경우 자동으로 매핑을 수행
    // .setFieldAccessLevel(org.modelmapper.~ .PRIVATE) : 비공개(private) 필드에 대해서도 접근하여 매핑 가능
    // .setMatchingStrategy(MatchingStrategies.LOOSE) : 필드명이 부분적으로 일치하는 경우에도 매핑을 수행
    @Bean // Bean으로 등록하고, 다른 클래스에서 @Autowired로 주입받을 수 있음
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true) 
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper;
    }
    
}
