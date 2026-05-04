package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.RecommendationMapper;
import ysu.ldr.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationMapper recommendationMapper;
    @Override
    public Integer insertUserCFRecommends(Integer userId, String recommends) {
        return recommendationMapper.insertUserCFRecommends(userId, recommends);
    }

    @Override
    public String getUserCFRecommends(Integer userId) {
        return recommendationMapper.getUserCFRecommends(userId);
    }

    @Override
    public String getItemCFRecommends(Integer userId) {
        return recommendationMapper.getItemCFRecommends(userId);
    }

    @Override
    public Integer insertItemCFRecommends(Integer userId, String recommends) {
        return recommendationMapper.insertItemCFRecommends(userId, recommends);
    }

    @Override
    public Integer deleteRecommends(Integer userId) {
        return recommendationMapper.deleteRecommends(userId);
    }
}
