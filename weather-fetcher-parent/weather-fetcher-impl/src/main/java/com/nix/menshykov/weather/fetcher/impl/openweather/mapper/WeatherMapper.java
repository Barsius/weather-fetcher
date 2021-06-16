package com.nix.menshykov.weather.fetcher.impl.openweather.mapper;

import com.nix.menshykov.weather.fetcher.api.model.WeatherModel;
import com.nix.menshykov.weather.fetcher.impl.openweather.model.OpenWeatherModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);
    Logger LOG = LogManager.getLogger(WeatherMapper.class);

    @Mapping(target = "temp", source = "main.temp")
    @Mapping(target = "tempFeeling", source = "main.tempFeeling")
    @Mapping(target = "windSpeed", source = "wind.speed")
    WeatherModel openWeatherModelToWeatherModel(OpenWeatherModel openWeatherModel);

    @AfterMapping
    default void after(@MappingTarget WeatherModel.WeatherModelBuilder weather, OpenWeatherModel openWeatherModel) {
        if(!openWeatherModel.getWeather().isEmpty()) {
            if (openWeatherModel.getWeather().size() > 1) {
                LOG.warn("There is more than one weather descriptions");
            }
            weather.description(openWeatherModel.getWeather().get(0).getDescription());
        } else {
            weather.description("no description");
        }
    }

}
