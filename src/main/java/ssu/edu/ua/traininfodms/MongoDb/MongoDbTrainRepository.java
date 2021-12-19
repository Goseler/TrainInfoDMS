package ssu.edu.ua.traininfodms.MongoDb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Models.DocumentKeys;
import ssu.edu.ua.traininfodms.Models.Mapper;
import ssu.edu.ua.traininfodms.Models.SearchRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    public ArrayList<AppTrainInfo> getTrainInfoList(SearchRequestDto requestDto) {
        ArrayList<Document> list = new ArrayList<>();

        var destinationFilter = Filters.regex(DocumentKeys.destination, ".*" + Pattern.quote(requestDto.getDestination()) + ".*");
        var deptHourFilter = Filters.gte(DocumentKeys.deptHour, requestDto.getDeptHour());
        var generalSeatsFilter = Filters.and(
                Filters.eq(DocumentKeys.seats + "." + DocumentKeys.SeatsKeys.firstClass, 0),
                Filters.eq(DocumentKeys.seats + "." + DocumentKeys.SeatsKeys.secondClass, 0),
                Filters.eq(DocumentKeys.seats + "." + DocumentKeys.SeatsKeys.thirdClass, 0)
        );
        var emptyFilter = Filters.empty();

        var combineFilter = Filters.and(
                destinationFilter,
                deptHourFilter,
                requestDto.isGeneralSeats() ? emptyFilter : generalSeatsFilter
        );

        collection.aggregate(List.of(Aggregates.match(combineFilter))).into(list);

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
