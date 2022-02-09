package com.OEMarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = { "com.OEMarket.mapper" })
@SpringBootApplication
public class OeMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(OeMarketApplication.class, args);
	}

}
