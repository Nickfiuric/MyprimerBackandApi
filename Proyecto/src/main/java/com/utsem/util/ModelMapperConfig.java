package com.utsem.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
	@Bean /*Lo_pone_a_dispocicion y son_componentes*/
ModelMapper modelMapper() {
	return new ModelMapper();
	}
}
