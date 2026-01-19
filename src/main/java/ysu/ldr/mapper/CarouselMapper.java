package ysu.ldr.mapper;

import org.apache.ibatis.annotations.Param;
import ysu.ldr.pojo.Carousel;

import java.util.List;

public interface CarouselMapper {
    public Integer addCarousel(@Param("movieId") Integer movieId, @Param("managerId")Integer managerId);

    public Integer getCountAll();

    public Integer findCarouselByMovieId(Integer movieId);

    public List<Carousel> getAllMovieId();

    public Integer deleteCarouselMovie(Integer movieId);
}
