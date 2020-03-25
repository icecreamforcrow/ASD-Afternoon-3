package at.tugraz.asdafternoon3.businesslogic;

import at.tugraz.asdafternoon3.data.Flat;
import at.tugraz.asdafternoon3.database.DatabaseConnection;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class FlatCreator {

    public FlatCreator() {
    }

    public boolean validateFlat(Flat flat) {
        if (flat.getName().length() == 0) {
            return false;
        }

        if (flat.getAddress().length() == 0) {
            return false;
        }

        if (flat.getSize() == 0) {
            return false;
        }

        // TODO: Name should not contain any special characters
        String str;
        str = flat.getName().toLowerCase();

        char[] charArray = str.toCharArray();
        for (int i=0; i < charArray.length; i++)
        {
            char ch = charArray[i];
            if (!(ch >= 'A' && ch <= 'z'))
            {
                return false;
            }
        }

        return true;
    }

    public Flat createFlat(Flat flat) throws SQLException {
        Dao<Flat, Integer> dao = DatabaseConnection.getInstance().getFlatDao();
        dao.create(flat);
        return flat;
    }
}
