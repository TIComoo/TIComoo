package g5.app.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import g5.app.model.Orden_Usuario;

@Service
public class GeneradorSecuenciaService {

    private static MongoOperations mongoOperations;

    @Autowired
    public GeneradorSecuenciaService(MongoOperations mongoOperations) {
        GeneradorSecuenciaService.mongoOperations = mongoOperations;
    }

    public static int generateSequence(String seqName) {

         Orden_Usuario counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                Orden_Usuario.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}