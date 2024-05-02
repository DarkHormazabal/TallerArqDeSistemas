package org.example.Helpers;

import org.modelmapper.ModelMapper;

/**
 * Automapper with dtos to model and inverse
 */
public class AutoMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <TSource, TDestination> TDestination map(TSource source, Class<TDestination> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    public static <TSource, TDestination> void map(TSource source, TDestination destination) {
        modelMapper.map(source, destination);
    }

}
