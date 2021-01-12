/**
 * 
 */
package br.com.flowers.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author cbgomes
 *
 */
@Component
public class Mapper {

	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
