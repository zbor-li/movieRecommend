package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.CarouselMapper;
import ysu.ldr.pojo.Carousel;
import ysu.ldr.service.CarouselService;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;
    @Override
    public Integer addCarousel(Integer movieId, Integer managerId) {
        return carouselMapper.addCarousel(movieId, managerId);
    }

    @Override
    public Integer getCountAll() {
        return carouselMapper.getCountAll();
    }

    @Override
    public Integer findCarouselByMovieId(Integer movieId) {
        return carouselMapper.findCarouselByMovieId(movieId);
    }

    @Override
    public List<Carousel> getAllMovieId() {
        return carouselMapper.getAllMovieId();
    }

    @Override
    public Integer deleteCarouselMovie(Integer movieId) {
        return carouselMapper.deleteCarouselMovie(movieId);
    }
}
