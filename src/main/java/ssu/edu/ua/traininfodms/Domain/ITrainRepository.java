package ssu.edu.ua.traininfodms.Domain;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface ITrainRepository {
    AppTrainInfo getTrainInfo(ObjectId id);
    ArrayList<AppTrainInfo> getTrainInfoList();
    void insertTrainInfo(AppTrainInfo appTrainInfo);
    void updateTrainInfo(AppTrainInfo appTrainInfo);
    void deleteTrainInfo(ObjectId id);
}
