package ysu.ldr.service;

import ysu.ldr.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    Integer addCarousel(Integer movieId, Integer managerId);

    public Integer getCountAll();

    public Integer findCarouselByMovieId(Integer movieId);

    public List<Carousel> getAllMovieId();

    public Integer deleteCarouselMovie(Integer movieId);
}
