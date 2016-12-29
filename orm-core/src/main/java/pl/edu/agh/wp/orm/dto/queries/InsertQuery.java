package pl.edu.agh.wp.orm.dto.queries;

import pl.edu.agh.wp.orm.exception.ORMException;
import pl.edu.agh.wp.orm.postres.DatabaseStatement;

public class InsertQuery extends DBQuery {

    private String tableName;

    public InsertQuery(String table){
        super();
        tableName = table;


    }

    @Override
    public void doStartQuery() {
        super.doStartQuery();
        appendWithSpace(DatabaseStatement.INSERT);
        appendWithSpace(DatabaseStatement.INTO);
        appendWithSpace(tableName);
        appendWithSpace("(");
    }

    @Override
    public void doEndQuery() {
        super.doEndQuery();
        if(getArgumetnNumber().equals(0))
            throw new ORMException("Cannot create insert query with 0 arguments");

        appendWithSpace(")");
        appendWithSpace(DatabaseStatement.VALUES);
        append("(");

        for(int i = 0; i<getArgumetnNumber()-1; i++){
            append("?,");
        }

        append("?");
        append(");");

    }
}
