package ysu.ldr.pojo.recommend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransfToDat {
    public void transfToDat(List<DatTransf> transfToDatList) throws IOException {
        // 输出的 .txt 文件路径
        String outputFile = "/home/zbor/IdeaProjects/movie_recommendation_ldr/src/main/resources/recommendData.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
//        writer.write("userId,movieId,rating");
//        writer.newLine();
        for (DatTransf datTransf : transfToDatList) {
            int userId = datTransf.getUserId();
            int movieId = datTransf.getMovieId();
            int rating = datTransf.getRating();

            writer.write(userId + "," + movieId + "," + rating);
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
}
