package pl.edu.agh.wp.orm.criterion.queries;

public class SimpleCriterion extends AbstractCriterion {

    private Object value;

    public SimpleCriterion(String column, Object value, String operator){
        super();
        this.column = column;
        this.operator = operator;
        this.value = value;
        buildQuery();
    }

    @Override
    public void buildQuery() {
        appendWithSpace(column);
        appendWithSpace(operator);
        if (value instanceof String){
            append("'");
            appendArgument(value);
            appendWithSpace("'");
        }
        else
            appendArgument(value);
    }

}
