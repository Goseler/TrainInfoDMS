package ssu.edu.ua.traininfodms.MongoDb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Models.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MongoDbTrainRepository implements ITrainRepository {
    private final MongoCollection<Document> collection = MongoDbContext.getCollection();

    @Override
    public AppTrainInfo getTrainInfo(ObjectId id) {
        Bson filter = Filters.eq(id);
        Document document = collection.aggregate(List.of(Aggregates.match(filter))).first();
        assert document != null;
        return Mapper.MapToAppTrainInfo(document);
    }

    @Override
    public ArrayList<AppTrainInfo> getTrainInfoList() {
        ArrayList<Document> list = new ArrayList<>();
        collection.aggregate(List.of(Aggregates.match(Filters.empty()))).into(list);

        ArrayList<AppTrainInfo> appTrainInfos = new ArrayList<>();
        for (Document document : list) {
            appTrainInfos.add(Mapper.MapToAppTrainInfo(document));
        }

        return appTrainInfos;
    }

    @Override
    public void insertTrainInfo(AppTrainInfo appTrainInfo) {
        collection.insertOne(Mapper.MapToDocument(appTrainInfo));
    }

    @Override
    public void updateTrainInfo(AppTrainInfo appTrainInfo) {
        Bson filter = Filters.eq(appTrainInfo.getId());
        collection.replaceOne(filter, Mapper.MapToDocument(appTrainInfo));
    }

    @Override
    public void deleteTrainInfo(ObjectId id) {
        Bson filter = Filters.eq(id);
        collection.deleteOne(filter);
    }
}
