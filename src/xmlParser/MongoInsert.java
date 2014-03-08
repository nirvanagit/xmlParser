package xmlParser;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoInsert {

	public void insertMongo(Employee emp) {

			//System.out.println("List contains:" + emp.);
		try {
			MongoClient mongoclient = new MongoClient("localhost", 27017);
			DB db = mongoclient.getDB("authorData");
			Set<String> colls = db.getCollectionNames();
			DBCollection table = db.getCollection("User");
			BasicDBObject document = new BasicDBObject();
			document.put("firstname", emp.firstName);
			document.put("lastName", emp.lastName);
			document.put("location", emp.location);
			table.insert(document);
			for (String s : colls) {

				System.out.println(s);

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
